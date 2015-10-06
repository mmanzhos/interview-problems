package leetcode;

public class GameOfLife {
	
	public void gameOfLife(int[][] board) {
		if (board == null || board.length == 0)
			return;

		int N = board.length;
		int M = board[0].length;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				int adj = checkState(board, i, j);
				int cellState = board[i][j];
				if (cellState == 1) {
					if (adj < 2 || adj > 3) {
						board[i][j] |= (0 << 1);
					} else {
						board[i][j] |= (1 << 1);
					}
				}
				if (cellState == 0) {
					if (adj == 3) {
						board[i][j] |= (1 << 1);
					}
				}
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				board[i][j] >>= 1;
			}
		}

	}

	private int checkState(int[][] board, int i, int j) {
		int countAdjacent = 0;
		int N = board.length;
		int M = board[0].length;

		// top - left
		if (i > 0 && j > 0) {
			countAdjacent += board[i - 1][j - 1] & 1;
		}

		// top
		if (i > 0) {
			countAdjacent += board[i - 1][j] & 1;
		}

		// top - right
		if (i > 0 && j < M - 1) {
			countAdjacent += board[i - 1][j + 1] & 1;
		}

		// left
		if (j > 0) {
			countAdjacent += board[i][j - 1] & 1;
		}

		// right
		if (j < M - 1) {
			countAdjacent += board[i][j + 1] & 1;
		}

		// bottom - left
		if (i < N - 1 && j > 0) {
			countAdjacent += board[i + 1][j - 1] & 1;
		}

		// bottom
		if (i < N - 1) {
			countAdjacent += board[i + 1][j] & 1;
		}

		// bottom - right
		if (i < N - 1 && j < M - 1) {
			countAdjacent += board[i + 1][j + 1] & 1;
		}

		return countAdjacent;
	}

	public static void main(String[] args) {

		GameOfLife gol = new GameOfLife();
		int[][] board = {
				{0, 1, 1, 0},
				{1, 0, 0, 1},
				{1, 1, 1, 1}
		};
		gol.gameOfLife(board);
		
		for (int[] row : board) {
			for (int n : row) {
				System.out.print(n);
			}
			System.out.println();
		}
		
	}

}
