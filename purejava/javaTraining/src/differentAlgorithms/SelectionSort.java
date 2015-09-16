package differentAlgorithms;

public class SelectionSort {

    public static void sort(int[] array) {
    
        // 2, 5, 3, 8
        for (int i = 0; i < array.length; i++) {    

        	int index = i;
        	
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[index]) {
                    index = j;
                }
            }
            
            if (index != i) {
	            int tmp = array[index];
	            array[index] = array[i];
	            array[i] = tmp;
            }
            
        }
    
    
    }



    public static void main(String[] args) {
        int[] array = {2, 5, 3, 8};
        sort(array);
        for (int n : array)
        	System.out.print(n + ", ");
    }
    
}
