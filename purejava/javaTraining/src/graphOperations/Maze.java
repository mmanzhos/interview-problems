package graphOperations;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;

class Coord {
	int row;
	int col;
	public Coord(int row, int col) {
		this.row = row;
		this.col = col;
	}
}

/**
 * https://en.wikipedia.org/wiki/Maze_generation_algorithm<br>
 *
 * <br>1. Start at a particular cell and call it the "exit."
 * <br>2. Mark the current cell as visited, and get a list of its neighbors. For each neighbor, starting with a randomly selected neighbor:
 * <br>2.1 If that neighbor hasn't been visited, remove the wall between this cell and that neighbor, and then recur with that neighbor as the current cell.
 * 
 * 
 * <br><br>
 * <b> (!) Works only on the half </b>
 */
public class Maze {
	
	int[][] field;
	boolean[][] visited;
	int size;
	
	public Maze(int size) {
		this.size = ((size & 1) == 0) ? size : size-10;
		field = new int[size-1][size-1];
		visited = new boolean[size-1][size-1];
	}
	
	public void removeWall(int from, int to, int either, boolean isRow) {
		from = Math.min(from, to);
		if (isRow) {
			field[from+0][either] = 1;
			field[from+1][either] = 1;
			field[from+2][either] = 1;
		} else {
			field[either][from+0] = 1;
			field[either][from+1] = 1;
			field[either][from+2] = 1;
		}
	}
	
	public void generateMaze(Coord initial) {
		Coord end = new Coord(size-1, size-1);
		dfsBuilder(initial);
		System.out.println();
		for (int[] row : field) {
			for (int col : row) {
				System.out.print(col + " ");
			}
			System.out.println();
		}
	}
	
	private void dfsBuilder(Coord initial) {
		Random rand = new Random();
		HashSet<Integer> blocked = checkAvailable(initial);
		if (blocked.isEmpty()) return;
		
		//int randomIndex = rand.nextInt(blocked.size());
		//int count = 0;
		//int direction = 0;
		//for (int possibleDirection : blocked) {
			//direction = possibleDirection;
			//if (randomIndex == count) break;
		//}
		
		visited[initial.row][initial.col] = true;
		
		
		for (int i = 0; i < blocked.size(); i++) {
			int randomIndex = rand.nextInt(blocked.size());
			int count = 0;
			int direction = 0;
			for (int possibleDirection : blocked) {
				direction = possibleDirection;
				if (randomIndex == count)
					break;
			}
			
			System.out.println("Loop of " + initial.row + "," + initial.col);
			
			blocked.remove(direction);

			Coord goTo;
			switch (direction) {
				case 0: // top
					goTo = new Coord(initial.row - 2, initial.col);
					removeWall(initial.row, goTo.row, initial.col, true);
					dfsBuilder(goTo);
					break;
				case 1: // right
					goTo = new Coord(initial.row, initial.col + 2);
					removeWall(initial.col, goTo.col, initial.row, false);
					dfsBuilder(goTo);
					break;
				case 2: // bottom
					goTo = new Coord(initial.row + 2, initial.col);
					removeWall(initial.row, goTo.row, initial.col, true);
					dfsBuilder(goTo);
					break;
				case 3: // left
					goTo = new Coord(initial.row, initial.col - 2);
					removeWall(initial.col, goTo.col, initial.row, false);
					dfsBuilder(goTo);
					break;
			}
			
		}
		
		
		
		
		
	}
	
	
	public HashSet<Integer> checkAvailable(Coord initial) {
		int row = initial.row;
		int col = initial.col;
		
		HashSet<Integer> set = new HashSet<Integer>(Arrays.asList(0, 1, 2, 3));
		
		//System.out.println("row = " + row +  " col = " + col);
		
		// return set of possible direction
		// if index is out bounds - not possible
		// if already visited - not posible
		
		
		if (row <= 2) {
			set.remove(0);
		}
		if (row + 2 >= size) {
			set.remove(2);
		}
		if (col <= 2) {
			set.remove(3);
		}
		if (col + 2 >= size) {
			set.remove(1);
		}
		
		if (set.isEmpty()) return set;
		
		Iterator iter = set.iterator();
		while (iter.hasNext()) {
			int possibleDirection = (int) iter.next();
			//System.out.println("possible... " + possibleDirection);
			switch (possibleDirection) {
				case 0:
					if (visited[row][col] == true)
						iter.remove();
					break;
				case 1:
					if (visited[row][col+2] == true)
						iter.remove();
					break;
				case 2:
					if (visited[row+2][col] == true)
						iter.remove();
					break;
				case 3:
					if (visited[row][col-2])
						iter.remove();
					break;
			}
			if (set.isEmpty()) return set;
		}
		
		return set;
	}

	public static void main(String[] args) {
		
		Maze maze = new Maze(30);
		Coord initial = new Coord(0, 0);
		maze.generateMaze(initial);
		
	}

}
