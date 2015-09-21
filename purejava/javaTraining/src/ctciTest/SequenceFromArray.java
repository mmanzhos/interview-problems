package ctciTest;

public class SequenceFromArray {

	public String consecutiveSegments(int[] array) {
        if (array == null) return null;
        int len = array.length;
        if (len < 2) return "" + array[0];

        StringBuilder result = new StringBuilder();
        result.append("" + array[0]);

        boolean endedSeq = false;
        int seqLength = 0;
        
        for (int i = 1; i <= len; i++) {
            if (endedSeq) {
                result.append(", ");
                result.append("" + array[i-1]);
                endedSeq = false;
                seqLength = 1;
            }
            
            if (i != len && array[i-1] + 1 >= array[i]) {
            	seqLength++;
            } else {
            	endedSeq = true;
            	if (seqLength > 1)
            		result.append("-" + array[i-1]);
            }
        }
		return result.toString();

    }
	
	public static void main(String[] args) {
		SequenceFromArray sfa = new SequenceFromArray();
		String result = sfa.consecutiveSegments(new int[]{1, 2, 3, 3, 10, 11, 15, 25, 26});
		System.out.println(result);
	}
	

}
