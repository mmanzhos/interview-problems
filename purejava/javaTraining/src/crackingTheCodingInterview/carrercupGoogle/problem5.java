/*
http://www.careercup.com/question?id=5642432622362624

<p>You have a sorted array containing the age of every person on Earth.
<br>
<br>[0, 0, 0, 0, ..., 1, 1, ..., 28, 28, ..., 110, ...]
<br>
<br>Find out how many people have each age.</p>


My thoughts (stolen):
1. EVERY PERSON ON EARTH, means that O(n) solutions go away
2. On that amount of data modified binary search would work great.

Example:
000000000000000000000000000000000000000000001111111111111111111111111111111111111222222222222222222222222222222222222222
find 0 starting index
 obviously 0
find 0 end index
                         2        4    5  673                   1
find 1 start index
	0 end index + 1
find 1 end index
                                                                1        4   5 67 3                   2
find 2 start index
	1 end index + 1
find 2 end index
	input length - 1


Pseudo-code:
startIndex = 0
endIndex = 0
endNumber = array[length - 1]

peopleAges = int[endNumber]

for i = 0 to endNumber (inclusive)
  if (i == endNumber)
  	endIndex = length - 1
  else
    endIndex = binarySearch(startIndex, array.length, i);

  if (endIndex == -1)
    return
  else
    peopleAges[i] = endIndex - startIndex
  startIndex = endIndex + 1


function binarySearch(startIndex, endIndex, value)
  while startIndex < endIndex
    mid = (endIndex - startIndex) / 2 + startIndex

    if (array[mid] == value && array[mid+1] == value + 1)
      return mid

    if (value < array[mid])
      endIndex = mid
    else if (value == array[mid])
      startIndex = mid + 1

  return -1;



*/



// initial version
// I forgot to return array and nulls, end there was a bug in calculations of (endIndex - startIndex), +1 is needed here
// and a bug when BS returns -1, so we should handle this result in possibleNewEndIndex
public class Main {
    
    // there are may be possible int overflow on indexing, but is not possible long as array index.
    public int[] countPeopleAges(int[] ages) {
    	if (ages == null) return;
    	int len = ages.length;
    	if (len == 0) return;

    	int startIndex = 0;
    	int endIndex = -1;

    	int endNumber = ages[len-1];
    	int[] countedPeopleAges = new int[endNumber + 1];

    	for (int i = 0; i <= endNumber; i++) {
    		if (i == endNumber)
    			endIndex = len - 1;
    		else 
    			endIndex = binarySearch(ages, startIndex, array.length-1, i);

    		if (endIndex == -1) {
    			countedPeopleAges[i] = 0;
    		} else {
    			countedPeopleAges[i] = endIndex - startIndex;
    		}

    		startIndex = endIndex + 1;
    	}
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
}






// working one

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