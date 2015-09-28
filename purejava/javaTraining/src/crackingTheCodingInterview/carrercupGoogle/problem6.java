/*
http://www.careercup.com/question?id=4924808426946560

You are given a matrix n rows, m columns where each row is sorted in increasing order.
Find median of the overall elements. What is the time complexity?

My thoughts:
Ok, median in [1, 2, 3, 4] is (2+3)/2; or in [1,2,3] is 2
1) initially I thought about merging, but it may be unnecessary if we find some median properties.
Let's search.

1 3 7 9
2 5 6 8
Median?
1 2 3 5 6 7 8 9
answer: 5.5

maybe this way?
1 3 7 9 - (3+7)/2 = 5    \
2 5 6 8 - (5+6)/2 = 5.5 -- (5+5.5)/2 = 5.25 - NO!



Okay, i don't know any other helpful variants.

Merging:
Time: O(nm*logn)
1) Merging = n-1 times m elements; 2 rows = 1 operation, 4 rows = 2 + 1 operations, 8 rows = 4 + 2 + 1 op., 16 rows = 8 + 4 + 2 + 1 <---- WRONG calculations
1.1) How to merge:
1 3 7 9
2 5 6 8
6 7 8 14
4 5 7 10
2 3 5 6
1 4 5 8
?
16 rows:
process 2*m + 2*m + 2*m + 2*m = 8m el.
process 2*2*m + 2*2*m = 8m el.
process 2*2*2*m = 8m el.
3 * 8m = log8 * 8m el.
O(nmlogn)
Space: O(nm)


Heap (not my):
Time: O(klogn), k = medianIndex
1) Initial heap O(nlogn) - insertion takes logn, n times
2) Processing O(klogn) - extract + insert = 2logn, k times
3) O(nlogn + (mn)/2 * logn) = O(nlogn * (1 + m)) = O(nmlogn)
!!!!!!!!!!! WRONG !!!!!!!!!!!
1) Initial heap building takes O(n) http://stackoverflow.com/questions/9755721/how-can-building-a-heap-be-on-time-complexity
Because of a CONVERGING SERIES. Where bottom-up building approach results in:
(assume we have 16 elements)
16/2               +  16/2^2    +    16/2^3  +   16/2^4             =  8 + 4 + 2 + 1 ~ 16
the lowest level                                 log16 level (root)


Space: O(n), because in the heap there will never be more than n elements.

1 3 7 9
2 5 6 8
solving...
1) minHeap = 1
            /
           2
2.1) while k < medianIndex
    poll root
    insert root.next
2.2) median index = 4*2 / 2 = 4
  2      3      5
 /   => /  =>  /
3       5     7

I found in topic version about minheap.
In other words, find n/2 smallest element.

However, there are a few questions (to better understand the trick):
1) Why do we start witn COLUMN in heap?
2) Why do we insert the next (in row) value of root element?

Answer on both:
Because it is the way of temporary merging.
It is like a zipper (slide fastener) on evidence pack.
Zipper here is a heap. And its path is array.




Merging algorithm:
1 2 4
2 3 5
1 4 7
3 5 6
-----
1 2 4
2 3 5

1 4 7
3 5 6
-----------
1 2 2 3 4 5
1 3 4 5 6 7
------------------------
1 1 2 2 3 3 4 5 5 6 7

Human code:
create an array of length M*N
separate rows by 2 until difference between start and end is not equal to 1
get start row index
get end row index




*/



public class Main {
    
    int[] tmpMerge;

    // merging approach
    // failed :(
    public int medianMerge(int[][] matrix) {
    	if (matrix == null) return -1;
        int N = matrix.length;
        if (N == 0) return -1;
        int M = matrix[0].length;

        tmpMerge = new int[M*N];

        int[] indices = new int[N];
        int count = 0;
        while (count < M*N) {
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < N; i++) {
                if (indices[i] >= M)
                    continue;
                int element = matrix[i][indices[i]];
                if (element < min) {
                    min = element;
                    indices[i]++;
                }
            }
            // risk of infinite loop
            if (min == Integer.MAX_VALUE)
                continue;
            tmpMerge[count++] = min;
        }

        int median = 0;
        if ((M*N & 1) != 0)
            median = tmpMerge[(M*N)/2];
        else
            median = (tmpMerge[(M*N)/2] + tmpMerge[(M*N)/2 + 1]);

        return median;
    }


    // working
    public int medianMerge(int[][] matrix) {
        if (matrix == null) return -1;
        int N = matrix.length;
        if (N == 0) return -1;
        int M = matrix[0].length;

        tmpMerge = new int[M*N];

        int[] indices = new int[N];
        int count = 0;
        while (count < M*N) {
            int min = Integer.MAX_VALUE;
            int minIndex = 0;
            for (int i = 0; i < N; i++) {
                if (indices[i] >= M)
                    continue;
                int element = matrix[i][indices[i]];
                if (element < min) {
                    min = element;
                    minIndex = i;
                }
            }
            incdices[minIndex]++;

            // risk of infinite loop
            if (min == Integer.MAX_VALUE)
                continue;
            tmpMerge[count++] = min;
        }

        int median = 0;
        if ((M*N & 1) != 0)
            median = tmpMerge[(M*N)/2];
        else
            median = (tmpMerge[(M*N)/2] + tmpMerge[(M*N)/2 + 1]);

        return median;
    }



    // heap approach
    public void medianWithHeap(int[][] matrix) {
        PriorityQueue<MatrixElement> minHeap = PriorityQueue<MatrixElement>();
        int N = matrix.length;
        int M = matrix[0].length;

        MatrixElement mth = null;

        // push 1st column to heap
        for (int i = 0; i < N; i++) {
            minHeap.offer(new MatrixElement(matrix[i][0], i, 0));
        }

        int approxMedIndex = M*N/2;

        boolean doubleMed = false;
        if ((approxMedIndex & 1) == 0) { // approxMedIndex % 2 == 0
            doubledMed = true;
        }

        int additionalMed = 0;
        for (int i = 0; i <= approxMedIndex; i++) {
            mth = minHeap.poll();
            if (mth.col + 1 < M) {
                MatrixElement next = new MatrixElement(matrix[mth.row][mth.col+1], mth.row, mth.col + 1);
                minHeap.offer(next);
            }
            // this is penultimate element, not the last, because our loop works for <= approxMedIndex inclusive
            if (doubledMed && i == approxMedIndex - 1) {
                additionalMed = mth.val;
            }
        }

        return doubledMed ? (additinalMed + mth.val)/2 : additinalMed;

    }

    class MatrixElement implements Comparable<MatrixElement> {
        int val;
        int row;
        int col;
        public MatrixElement(int val, int row, int col) {
            this.val = val;
            this.row = row;
            this.col = col;
        }
        public int compareTo(MatrixElement el) {
            return Integer.compare(this.val, el.val);
        }
    }


}