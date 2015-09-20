/*
Write an algorithm such that if an element in an MxN matrix is 0, its entire row and
column is set to 0.

My thoughts:
There is an unobvious mistake if you consider to change elements in first pass.
That may lead to unexpected result such as a whole matrix of zeros.

So better way would be to collect coordinates of zeros,
and than with help of function setToZeros(rowX, colY)
set all appropriate rows and columns to zeros. Well it is not a O(mn),
but O(mn + k*(m+n)) where k is amount of zeros


Pseudo-code:
coords set
for i = 0 to m
  for j = 0 to n
    if (matrix[i][j] equals to 0)
       coordsSet add (i and j)

for k = 0 to coords set length
  coordPair = coorsSet get k'th
  setToZeros(coordPair.x, coordPair.y)


function setToZeros(x, y):
  for i = 0 to m
    matrix[i][y] = 0
  for j = 0 to n
    matrix[x][j] = 0


*/

public class Main {

	class Coords {
		int row;
		int col;
		public Coords(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}

	public void zerosSetter(int[][] matrix) {
		if (matrix == null || matrix.length == 0) return;

		HashSet<Coords> set = new HashSet<Coords>();
		int M = matrix.length;
		int N = matrix[0].length;

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (matrix[i][j] == 0)
					set.add(new Coords(i, j));
			}
		}

		for (Coords coord : set) {
			setToZeros(coord, matrix, M, N);
		}


	}

	private void setToZeros(Coords coord, int[][] matrix, int M, int N) {
		for (int i = 0; i < M; i++) {
			matrix[i][coord.col] = 0;
		}
		for (int j = 0; j < N; j++) {
			matrix[coord.row][j] = 0;
		}
	}


}