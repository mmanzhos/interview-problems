package leetcode;

import java.util.HashSet;

public class SudokuSolver {
	
	
		/*
		 Initial:

		    char[][] board;
		    HashSet<Integer>[] occupiedInRow;
		    HashSet<Integer>[] occupiedInCol;
		    HashSet<Integer>[] occupiedInSquare;
		    
		    public void solveSudoku(char[][] board) {
		        this.board = board;
		        
		        occupiedInRow = new HashSet[9];
		        for (int row = 0; row < 9; row++) {
		            occupiedInRow[row] = fillHashSet(row, -1);
		        }
		        
		        occupiedInCol = new HashSet[9];
		        for (int col = 0; col < 9; col++) {
		            occupiedInCol[col] = fillHashSet(-1, col);
		        }
		        
		        occupiedInSquare = new HashSet[9];
		        for (int sq = 0; sq < 9; sq++) {
		            occupiedInSquare[sq] = fillHashSet(sq, sq);
		        }
		    
		        tryToInsert(1, 0, 0);
		    }
		
		    
		    private boolean tryToInsert(int possibleNumber, int rowStart, int colStart) {
		        
		        // remove this condition
		        //if (rowStart > 8) return false;
		        
		        if (rowStart > 8) return true;
		        if (colStart > 8) return tryToInsert(possibleNumber, rowStart + 1, 0);
		        
		        if (board[rowStart][colStart] != '.') {
		            tryToInsert(1, rowStart, colStart + 1);
		        } else {
		            if (possibleNumber > 9) return true; // this should return result which causes backtracking
		            
		            if (isSafe(possibleNumber, rowStart, colStart)) {
		                occupy(possibleNumber, rowStart, colStart);
		                if (!tryToInsert(1, rowStart, colStart + 1)) {
		                    emptify(possibleNumber, rowStart, colStart);
		                    tryToInsert(possibleNumber + 1, rowStart, colStart);
		                } else {
		                    return true;
		                }
		            } else {
		                tryToInsert(possibleNumber + 1, rowStart, colStart);
		            }
		            return false;
		        }
		        return true;
		    }
		    
		    private boolean isSafe(int possibleNumber, int row, int col) {
		        if (occupiedInRow[row].contains(possibleNumber)) return false;
		        if (occupiedInCol[col].contains(possibleNumber)) return false;
		        // get square from row and col
		        int square = row / 3 * 3 + col % 3;
		        if (occupiedInSquare[square].contains(possibleNumber)) return false;
		        return true;
		    }
		    
		    private HashSet<Integer> fillHashSet(int row, int col) {
		        HashSet<Integer> set = new HashSet<Integer>();
		        
		        if (col == -1) {
		            for (int fillCol = 0; fillCol < 9; fillCol++) {
		                if (board[row][fillCol] != '.') {
		                    set.add((int) (board[row][fillCol] - '0'));
		                }
		            }
		            return set;
		        }
		        
		        if (row == -1) {
		            for (int fillRow = 0; fillRow < 9; fillRow++) {
		                if (board[fillRow][col] != '.') {
		                    set.add((int) (board[fillRow][col] - '0'));
		                }
		            }
		            return set;
		        }
		        
		        // if sq == 1
		        // row = [0,2]
		        // col = [0,2]
		        // if sq == 2
		        
		        // row == col == sq
		        int sq = row;
		        int fromRow = (sq / 3) * 3;
		        // sq = 8 : fromRow = 2 * 3 = 6
		        int limitRow = fromRow + 3;
		        int fromCol = (sq % 3) * 3;
		        // sq = 8 : fromCol = 2 * 3 = 6
		        int limitCol = fromCol + 3;
		        
		        for (; fromRow < limitRow; fromRow++) {
		            for (; fromCol < limitCol; fromCol++) {
		                set.add((int) (board[fromRow][fromCol] - '0'));
		            }
		        }
		        return set;
		    }
		    
		        
		    private void occupy(int possibleNumber, int row, int col) {
		        board[row][col] = (char) (possibleNumber + '0');
		        
		        occupiedInRow[row].add(possibleNumber);
		        occupiedInCol[col].add(possibleNumber);
		        // get square from row and col
		        int square = row / 3 * 3 + col % 3;
		        occupiedInSquare[square].add(possibleNumber);
		    }
		    
		    private void emptify(int possibleNumber, int row, int col) {
		        board[row][col] = '.';
		        
		        occupiedInRow[row].remove(possibleNumber);
		        occupiedInCol[col].remove(possibleNumber);
		        // get square from row and col
		        int square = row / 3 * 3 + col % 3;
		        occupiedInSquare[square].remove(possibleNumber);
		    }
		    
		}
		 
		 
		 
		 
		 */
	
	
	
	
	
		// working
	
	
	
	    /*
	    1. Find first '.'
	    2. Try to insert 1
	    
	    */
		int counter = 0;
	    
	    char[][] board;
	    HashSet<Integer>[] occupiedInRow;
	    HashSet<Integer>[] occupiedInCol;
	    HashSet<Integer>[] occupiedInSquare;
	    
	    public void solveSudoku(char[][] board) {
	        this.board = board;
	        
	        occupiedInRow = new HashSet[9];
	        for (int row = 0; row < 9; row++) {
	            occupiedInRow[row] = fillHashSet(row, -1);
	        }
	        
	        occupiedInCol = new HashSet[9];
	        for (int col = 0; col < 9; col++) {
	            occupiedInCol[col] = fillHashSet(-1, col);
	        }
	        
	        occupiedInSquare = new HashSet[9];
	        for (int sq = 0; sq < 9; sq++) {
	            occupiedInSquare[sq] = fillHashSet(sq, sq);
	        }
	    
	        tryToInsert(0, 0);
	    }

	    
	    private boolean tryToInsert(int rowStart, int colStart) {
	    	/* for i = 1 to 9
	    	 *   if isSafe than
	    	 *     occupy cell with i
	    	 *     tryToInsert cell.col + 1
	    	 *     
	    	 * if there was no insertion return false
	    	 * 
	    	 */
	    	
	    	if (rowStart > 8) return true;
	    	if (colStart > 8) return tryToInsert(rowStart + 1, 0);
	    	
	    	if (board[rowStart][colStart] == '.') {
	    		for (int i = 1; i <= 9; i++) {
	    			if (isSafe(i, rowStart, colStart)) {
	    				occupy(i, rowStart, colStart);
	    				//printBoard();
	    				if (tryToInsert(rowStart, colStart + 1))
	    					return true;
	    				else
	    					emptify(i, rowStart, colStart);
	    			}
	    		}
	    		return false;
	    	} else {
	    		return tryToInsert(rowStart, colStart + 1);
	    	}
	    }
	    
	    private void printBoard() {
	    	for (char[] row : board) {
				for (char c : row) {
					System.out.print(c+" ");
				}
				System.out.println();
			}
	    	System.out.println();
	    }
	    
	    private boolean isSafe(int possibleNumber, int row, int col) {
	        if (occupiedInRow[row].contains(possibleNumber)) return false;
	        if (occupiedInCol[col].contains(possibleNumber)) return false;
	        // get square from row and col
	        int square = row / 3 * 3 + col / 3;
	        if (occupiedInSquare[square].contains(possibleNumber)) return false;
	        return true;
	    }
	    
	    private HashSet<Integer> fillHashSet(int row, int col) {
	        HashSet<Integer> set = new HashSet<Integer>();
	        
	        if (col == -1) {
	            for (int fillCol = 0; fillCol < 9; fillCol++) {
	                if (board[row][fillCol] != '.') {
	                    set.add((int) (board[row][fillCol] - '0'));
	                }
	            }
	            return set;
	        }
	        
	        if (row == -1) {
	            for (int fillRow = 0; fillRow < 9; fillRow++) {
	                if (board[fillRow][col] != '.') {
	                    set.add((int) (board[fillRow][col] - '0'));
	                }
	            }
	            return set;
	        }
	        
	        // if sq == 1
	        // row = [0,2]
	        // col = [0,2]
	        // if sq == 2
	        
	        // row == col == sq
	        int sq = row;
	        int fromRow = (sq / 3) * 3;
	        int fromCol = (sq % 3) * 3;
	        
	        //System.out.println("Sqaure #" + sq);
	        
	        for (int i = fromRow; i < fromRow + 3; i++) {
	            for (int j = fromCol; j < fromCol + 3; j++) {
	            	//System.out.print(board[i][j] + " ");
	            	set.add((int) (board[i][j] - '0'));
	            	//}
	            }
	            //System.out.println();
	        }
	        //System.out.println();
	        return set;
	    }
	    
	        
	    private void occupy(int possibleNumber, int row, int col) {
	        board[row][col] = (char) (possibleNumber + '0');
	        
	        occupiedInRow[row].add(possibleNumber);
	        occupiedInCol[col].add(possibleNumber);
	        // get square from row and col
	        int square = row / 3 * 3 + col / 3;
	        occupiedInSquare[square].add(possibleNumber);
	    }
	    
	    private void emptify(int possibleNumber, int row, int col) {
	        board[row][col] = '.';
	        
	        occupiedInRow[row].remove(possibleNumber);
	        occupiedInCol[col].remove(possibleNumber);
	        // get square from row and col
	        int square = row / 3 * 3 + col / 3;
	        occupiedInSquare[square].remove(possibleNumber);
	    }
	    
	    
	    public static void main(String[] args) {
			SudokuSolver ss = new SudokuSolver();
			char[][] board = {
					{'.', '.', '9', '7', '4', '8', '.', '.', '.'},
					{'7', '.', '.', '.', '.', '.', '.', '.', '.'},
					{'.', '2', '.', '1', '.', '9', '.', '.', '.'},
					{'.', '.', '7', '.', '.', '.', '2', '4', '.'},
					{'.', '6', '4', '.', '1', '.', '5', '9', '.'},
					{'.', '9', '8', '.', '.', '.', '3', '.', '.'},
					{'.', '.', '.', '8', '.', '3', '.', '2', '.'},
					{'.', '.', '.', '.', '.', '.', '.', '.', '6'},
					{'.', '.', '.', '2', '7', '5', '9', '.', '.'}
			};
			ss.solveSudoku(board);
			
			for (char[] row : board) {
				for (char c : row) {
					System.out.print(c+" ");
				}
				System.out.println();
			}
			
		}

}













