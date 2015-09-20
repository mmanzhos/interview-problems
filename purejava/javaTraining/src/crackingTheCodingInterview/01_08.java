/*
Assume you have a method isSubstring which checks if one word is a substring of
another. Given two strings, s1 and s2, write code to check if s2 is a rotation of s1 using
only one call to isSubstring (i.e., “waterbottle” is a rotation of “erbottlewat”).


My thoughts:
Well, I just have heard that problem
s3 = s1 + s1 (wat_erbottlewat_ebottle)
return s3.isSubstring(s2)


*/

public class Main {


	public void checkForRotation(String s1, String s2) {
		String s3 = s1 + s1;
		return s2.isSubstring(s3);
	}


}