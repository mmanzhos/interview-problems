package differentAlgorithms;

import java.util.ArrayList;
import java.util.Scanner;

class Move {
	Square source;
	Square destination;
	Piece p;
	
	public Move(Square s, Square d, Piece p) {
		source = s;
		destination = d;
		this.p = p;
		
		System.out.println("Move " + p.name + " from " + s.c.getX() + "-" + s.c.getY() + " to " + d.c.getX() + "-" + d.c.getY() );
	}
}

class Player {
	Piece[] pieces;
	int index = 0;
	
	public Player() {
		pieces = new Piece[16];
	}
	public void addPiece(Piece piece) {
		pieces[index++] = piece;
		listPlayerPieces();
	}
	
	void listPlayerPieces() {
		for (Piece p : pieces) {
			if (p != null) System.out.println(p.name); 
		}
	}
	
}

class Coordinates {
	int x;
	int y;
	public Coordinates(int x, int y) {
		this.x = x;
		this.y = y;
	}
	int getX() {
		return x;
	}
	int getY() {
		return y;
	}
}

class Square {
	Piece p;
	Coordinates c;
	public Square(int x, int y) {
		c = new Coordinates(x, y);
	}
	public Square(Piece p, int x, int y) {
		this.p = p;
		c = new Coordinates(x, y);
	}
}


abstract class Piece {
	Player player;
	String name;
	
	boolean isMoveValid(Square source, Square destination) {
		return false;
	}
}

class Pawn extends Piece {
	
	public Pawn(Player player) {
		this.player = player;
		name = "pawn";
	}
	
	boolean isMoveValid(Square source, Square destination) {
		return true;
	}
	
}


class GameBoard {
	
	public static ArrayList<Move> moves = new ArrayList<Move>();
	public static Square[][] board = new Square[8][8];
	Player white;
	Player black;
	
	void setupBoard() {
		white = new Player();
		black = new Player();
		
		board[0][0] = new Square(new Pawn(white), 0, 0);
		board[1][0] = new Square(1, 0);
		
		
		white.addPiece(board[0][0].p);
	}
	
	void processTurn(int x1, int y1, int x2, int y2) {
		Square s = board[y1][x1];
		Square dest = board[y2][x2];
		Piece p = s.p;
		boolean isValid = p.isMoveValid(s, dest);
		if (isValid) {
			Move m = new Move(s, dest, p);
			moves.add(m);
		}
	}
	
}




public class Chess {

	public static void main(String[] args) {

		
		GameBoard gb = new GameBoard();
		gb.setupBoard();
		
		Scanner in = new Scanner(System.in);
		gb.processTurn(in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt());
		
		
		
	}

}
