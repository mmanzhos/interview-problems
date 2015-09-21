/*
http://www.careercup.com/question?id=5673390490779648
<p>Counting the islands. 
<br> 
<br> Given a map N x N, 2-D array
<br> 0 - sea
<br> X - land
<br> 
<br> Land is connected by 4-Neighbor connections, i.e.: above, down, left and right.
<br>
<br> 00000000000000000000000000000000000
<br> 00000000000000000000000000000000000
<br> 00000000000000000000000000000000000
<br> 0000000000000000000X000000000000000
<br> 000000000000000000XXX00000000000000
<br> 000XX000000000000000000000000000000
<br> 000XXXX0000000000000000000000000000
<br> 0000000X000000000000000000000000000
<br> 00000000000000000000000000000000000
<br> 000000000000000000000X0000000000000
<br> 00000000000000000000000000000000000
<br> 00000000000000000000000000000000000
<br> 00000000000000000000000000000000000
<br> 00000000000000000000000000000000000
<br> 00000000000000000000000000000000000
<br> 00000000000000000000000000000000000
<br> 00000000000000000000000000000000000
<br> 00000000000000000000000000000000000
<br> 
<br> Output of this map: 4 (totally 4 islands on the map)</p>



My thoughts:

simple but slow algorithm

Find first occurance of X
launch search of neighbor X
add all of them to the visited set
when this island ends increment islandCounter

then go and check for the next occurance of X which is not in set
go to step 1


Pseudo-code:
int counter
input matrix[][]
class coord(x, y)
hashset visited coords
for i = 0 to N
 for j = 0 to N
   if matrix[i][j] == 'X' AND is not visited
     visitIsland(i, j)
     counter++
return counter

function visitIsland(i, j)
  visited add coord(i,j)
  if (matrix[i+1][j] == 'X' AND coord(i+1, j) is not visited)
    visitIsland(i+1, j)
  if (matrix[i-1][j] == 'X' AND coord(i-1, j) is not visited)
    visitIsland(i-1, j)
  if (matrix[i][j+1] == 'X' AND coord(i, j+1) is not visited)
    visitIsland(i, j+1)
  if (matrix[i][j-1] == 'X' AND coord(i, j-1) is not visited)
    visitIsland(i, j-1)

*/

public class Main {
    class Coord {
    	int row;
    	int col;
    	public Coord(int row, int col) {
    		this.row = row;
    		this.col = col;
    	}
    }

    HashSet<Coord> visited;

    public int countIslands(char[][] matrix) {
        int counter = 0;
        int N = matrix.length;
        visited = new HashSet<Coord>();
        for (int i = 0; i < N; i++) {
        	for (int j = 0; j < N; j++) {
        		if (matrix[i][j] == 'X' && visited.contains(new Coord(i, j)) == false) {
        			visitIsland(i, j);
        			counter++;
        		}
        	}
        }
    }	

    private void visitIsland(int row, int col) {
    	visited.add(new Coord(row, col));
    	if (row-1 > 0 && matrix[row-1][col] == 'X' && visited.contains(new Coord(row-1, col)) == false)
    		visitIsland(row-1, col);
    	if (col+1 < N && matrix[row][col+1] == 'X' && visited.contains(new Coord(row, col+1)) == false)
    		visitIsland(row, col+1);
    	if (row+1 < N && matrix[row+1][col] == 'X' && visited.contains(new Coord(row+1, col)) == false)
    		visitIsland(row+1, col);
    	if (col-1 > 0 && matrix[row][col-1] == 'X' && visited.contains(new Coord(row, col-1)) == false)
    		visitIsland(row, col-1);
    }
}