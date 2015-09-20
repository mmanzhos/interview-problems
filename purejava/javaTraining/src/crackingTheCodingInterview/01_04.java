/*
Write a method to decide if two strings are anagrams or not.

Anagrams:
cat, tac, cta, tca, atc, act

My thoughts:
count quantity of each character in the 1st string
compare with quantity of each character in the 2nd string

Pseudo-code:
Create a characters set
for i = 0 to string1 length
  add each character to unique characters set
for i = 0 to string2 length
  subtract quantity of each character in the 2nd string from the characters set
for i = 0 to string2 length
  if characters[i] is greater than 0
    return false
return true

*/

public class Main {
	public boolean areAnagrams(String str1, String str2) {
		if (str1 == null || str2 == null str1.length != str2.length) return false;

		int[] characters = new int[256];

		char[] charAr1 = str1.toCharArray();
		char[] charAr2 = str2.toCharArray();
		
		for (int i = 0; i < charAr1.length; i++) {
			characters[charAr1[i]]++;
		}
		for (int i = 0; i < charAr1.length; i++) {
			characters[charAr2[i]]--;
		}
		for (int i = 0; i < charAr1.length; i++) {
			if (characters[i] > 0) return false;
		}

		return true;
	}
}