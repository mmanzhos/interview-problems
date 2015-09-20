/*
Design an algorithm and write code to remove the duplicate characters in a string
without using any additional buffer. NOTE: One or two additional variables are fine.
An extra copy of the array is not.

1. ['a', 'a', 'b', 'b']
How to get ['a', 'b', ' ', 'b'] ?
2. ['a', 'b', 'b', 'b']
3. ['a', 'b', ' ', 'b']



Pseudo-code:
Create 2 pointer which initially points to 1st index
Create set of duplicates
Loop for every character - index tail:
  If c is unique
    mark as duplicate
    set array[current] to array[tail]
    current++
Set array[current] to space ' '

*/

public class Main {
	public void removeDuplicates(char[] str) {
		if (str == null) return;
		if (str.length < 2) return;

		int current = 1;
		int tail;
		boolean[] duplicate = new boolean[256];

		duplicate[0] = true;

		for (tail = 1; tail < str.length; tail++) {
			int charIndex = array[tail];
			if (!duplicate[charIndex]) {
				duplicate[charIndex] = true;
				str[current] = str[tail];
				current++;
			}
		}

		str[current] = 0; 
	}
}