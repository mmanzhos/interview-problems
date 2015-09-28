/*
http://www.careercup.com/question?id=5143327210995712

You are given a list of n float numbers x_1, x_2, x_3, ... x_n, where x_i > 0. 
A traveler starts at point (0, 0) and moves x_1 metres to the north, then x_2 metres to the west, x_3 to the south, x_4 to the east and so on (after each move his direction changes counter-clockwise) 
Write an single-pass algorithm that uses O(1) memory to determine, if the travelers path crosses itself, or not (i.e. if it's self-intersecting) 
e.g. 
2 1 1 2 -> crosses 
1 2 3 4 -> doesn't cross

My thoughts:
1) Examplify initially.
(I draw 4 different situations)
2) Find dependencies.
Xdifference = n1 - n3 + n5 - n7 + n9 .... n(k+1)
Ydifference = n0 - n2 + n4 - n6 + n8 .... nk
return true if (Xdiff >= 0 && Ydiff >= 0)

if at least one of the values is less than 0, there is no intersection.


guys from topic said there are a solution with only 2 checks O(1) and not O(n) as mine.
but I didn't understand them 100%. because they solution doesn't handle cases like
..... long sequence without intersections ................. intersection ...................... long sequence without intersection

*/

public class Main {
	
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
				xDiff = (changeSignX) ? xDiff - sequence[i] : xDiff + sequence[i];
				changeSignX = !changeSignX;
			}
		}

		return xDiff >= 0 && yDiff >= 0;
	}

}