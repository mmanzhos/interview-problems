package ctciTest;

import java.util.PriorityQueue;

public class MergeMatrix {

	public float medianWithHeap(int[][] matrix) {
        PriorityQueue<MatrixElement> minHeap = new PriorityQueue<MatrixElement>();
        int N = matrix.length;
        int M = matrix[0].length;

        MatrixElement mth = null;

        // push 1st column to heap
        for (int i = 0; i < N; i++) {
            minHeap.offer(new MatrixElement(matrix[i][0], i, 0));
        }

        int approxMedIndex = M*N/2;
        boolean doubleMed = false;
        if ((approxMedIndex & 1) == 0) {
            doubleMed = true;
        }

        int additionalMed = 0;
        for (int i = 0; i <= approxMedIndex; i++) {
            mth = minHeap.poll();
            System.out.println(mth.val);
            if (mth.col + 1 < M) {
                MatrixElement next = new MatrixElement(matrix[mth.row][mth.col+1], mth.row, mth.col + 1);
                minHeap.offer(next);
            }
            if (doubleMed && i == approxMedIndex - 1) {
                additionalMed = mth.val;
            }
        }

        return doubleMed ? (additionalMed + mth.val)/2.0f : additionalMed;

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
	
	public static void main(String[] args) {
		MergeMatrix mm = new MergeMatrix();
		int[][] matrix1 = {
				{1, 3, 7, 9},
				{2, 5, 6, 8}
				// 1 2 3 5 6 7 8 9
				// 5.5
		};
		
		int[][] matrix2 = {
				{1, 2, 4},
				{2, 3, 5},
				{1, 4, 7},
				{3, 5, 6}
		};
		
		float median = mm.medianWithHeap(matrix2);
		System.out.println("\n"+median);
	}

}
