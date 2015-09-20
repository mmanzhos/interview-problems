/*
Implement an algorithm to determine if a string has all unique characters. What if you
can not use additional data structures?

Pseudo-code:
1. Create a data structure to hold every unique (!) character (HashSet / boolean[] / long (setting bits))
2. Loop for every character in a string as c:
3.   If there is c in data set:
4.     return duplicate!
5.   else
6.     add c to data set

Notes:
1. We can create a boolean array only if we are sure of usage only ASCII characters
2. In case of thousands of symbols it would be better to use HashSet, though is not space efficient
*/

public class Main {
	public boolean areAllUnique(String str) {
		long uniqueSet = 0L; // create 64-bits variable
		for (char c : str.toCharArray()) {
			int charNumber = c - 'a';
			if ((uniqueSet & (1L << c)) != 0) {
				return false;
			} else {
				uniqueSet = uniqueSet | (1L << c);
			}
		}
		return true;
	}
}