package ctciTest;

public class FindIntersection {

	public boolean findIntersections(int[] sequence) {
		if (sequence == null) return false;
		if (sequence.length == 0) return false;
		int xDiff = 0;
		int yDiff = 0;
		boolean changeSignX = false;
		boolean changeSignY = false;
		for (int i = 0; i < sequence.length; i++) {
			if ((i & 1) == 0) { // for Y [0, 2, 4, ..., 2n]
				yDiff = (changeSignY) ? yDiff - sequence[i] : yDiff + sequence[i];
				changeSignY = !changeSignY;
			} else {
				xDiff = (!changeSignX) ? xDiff - sequence[i] : xDiff + sequence[i];
				changeSignX = !changeSignX;
			}
		}

		return xDiff <= 1 && yDiff >= 0;
	}
	
	public static void main(String[] args) {
		FindIntersection fi = new FindIntersection();
		//int[] seq = {2, 1, 3, 3, 1, 4}; // true
		//int[] seq = {2, 1, 1, 2}; // true
		//int[] seq = {1, 2, 3, 4}; // false
		int[] seq = {2, 1, 3, 3, 1, 1}; // false
		System.out.println(fi.findIntersections(seq));
	}

}
