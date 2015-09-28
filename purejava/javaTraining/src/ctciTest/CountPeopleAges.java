package ctciTest;

public class CountPeopleAges {

	public int[] countPeopleAges(int[] ages) {
    	if (ages == null) return null;
    	int len = ages.length;
    	if (len == 0) return null;

    	int startIndex = 0;
    	int endIndex = -1;
    	

    	int endNumber = ages[len-1];
    	int[] countedPeopleAges = new int[endNumber + 1];

    	for (int i = 0; i <= endNumber; i++) {
    		if (i == endNumber)
    			endIndex = len - 1;
    		else {
    			int possibleNewEndIndex = binarySearch(ages, startIndex, ages.length-1, i);
    			endIndex = (possibleNewEndIndex == -1) ? endIndex : possibleNewEndIndex;
    		}

    		if (endIndex == -1) {
    			countedPeopleAges[i] = 0;
    		} else {
    			countedPeopleAges[i] = endIndex - startIndex + 1;
    		}

    		startIndex = endIndex + 1;
    	}
		return countedPeopleAges;
    }

    private int binarySearch(int[] ages, int startIndex, int endIndex, int value) {
    	while (startIndex < endIndex) {
    		int mid = (endIndex - startIndex) / 2 + startIndex;

    		if (ages[mid] == value && ages[mid+1] > value)
    			return mid;

    		if (value < ages[mid]) {
    			endIndex = mid;
    		} else {
    			startIndex = mid + 1;
    		}
    	}
    	return -1;
    }
	
	
	public static void main(String[] args) {
		CountPeopleAges cpa = new CountPeopleAges();
		int[] ages = {
				1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
				3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3,
				4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4
		};
		System.out.println(ages.length);
		int[] countedAges = cpa.countPeopleAges(ages);
		for (int age : countedAges) {
			System.out.println(age);
		}
	}

}
