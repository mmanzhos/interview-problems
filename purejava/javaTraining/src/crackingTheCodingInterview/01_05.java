/*
Write a method to replace all spaces in a string with ‘%20’.

My thoughts:
I will need bigger characters array.
After each space replacement all next elements should be moved to the right on (3-1) steps


Pseudo-code:
Count spaces in a string
Create a new array with length of (length of string + 2 * amount of spaces)
Create 2 pointers: current = 0, tail = 0
for tail = 0 to initial string length
  if string[tail] equals space ' '
    newString[current++] = '%'
    newString[current++] = '2'
    newString[current++] = '0'
    // we can safely increment because new array size is excpected to that size
  else
    newString[current++] = string[tail]
return newString toString

Example:
['a', ' ', 'b']
['a', '%', '2', '0', 'b']

*/

public class Main {

	public void replaceSpaces(String str) {
		if (str == null || str.length() == 0) return false;

		char[] initial = str.toCharArray();
		
		int countSpaces = 0;
		for (char c : initial)
			if (c == ' ')
				countSpaces++;
		char[] newString = new char[initial.length + 2 * countSpaces];
		
		int tail;
		int current = 0;

		for (tail = 0; tail < initial.length; tail++) {
			if (initial[tail] == ' ') {
				newString[current++] = '%';
				newString[current++] = '2';
				newString[current++] = '0';
			} else {
				newString[current++] = initial[tail];
			}
		}

		return newString.toString();

	}
}