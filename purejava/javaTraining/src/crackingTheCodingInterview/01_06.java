/*
Given an image represented by an NxN matrix, where each pixel in the image is 4
bytes, write a method to rotate the image by 90 degrees. Can you do this in place?

Examples:
1 2|3  <- N+1 = 4, N/2 = 2
---
4 5 6 
7 8 9
  ↓
7 4 1
8 5 2
9 6 3


1   2| 3  4  <- N+1 = 5, N/2 = 2
5   6| 7  8
-----
9  10 11 12
13 14 15 16
     ↓
13  9  5  1
14 10  6  2
15 11  7  3
16 12  8  4



 1  2  3| 4  5
 6  7  8| 9 10
--------
11 12 13 14 15
16 17 18 19 20
21 22 23 24 25



My thoughts:
Now let's consider the list of swaps:
Swap 9 and 15   [0][1] and [(N-1)-1][0]
Swap 15 and 8   [(N-1)-1][0] and [(N-1)-0][(N-1)-1]
Swap 8 and 2    [(N-1)-0][(N-1)-1] and [1][(N-1)-0]
Swap 2 and 9    [1][(N-1)-0] and [0][1]

Next step is to try to show all these swaps in terms of coordinates of 1st element
N = matrix.length

int tmp = matrix[i][j]; i = 0, j = 1
matrix[i][j] = matrix[N-j-1][i];
matrix[N-j-1][i] = matrix[N-i-1][N-j-1];
matrix[N-i-1][N-j-1] = matrix[j][N-i-1];
matrix[j][N-i-1] = tmp;


Pseudo-code:
N = matrix.length
for i = 0 to N/2
  for j = 0 to (N+1)/2
	4 swaps from above


*/

public class Main {

	public void rotateMatrix(int[][] matrix) {
		int N = matrix.length;

		for (int i = 0; i < N/2; i++) {
			for (int j = 0; j < (N+1)/2; j++) {
				int tmp = matrix[i][j];
				matrix[i][j] = matrix[N-j-1][i];
				matrix[N-j-1][i] = matrix[N-i-1][N-j-1];
				matrix[N-i-1][N-j-1] = matrix[j][N-i-1];
				matrix[j][N-i-1] = tmp;
			}
		}

	}
}