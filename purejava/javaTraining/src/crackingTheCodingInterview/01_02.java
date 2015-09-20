/*
Write code to reverse a C-Style String. (C-String means that “abcd” is represented as
five characters, including the null character.)

Well, I didn't know how to solve this problem, because my coding in C/C++ is very poor,
so initially I pasted the working code, commented it and then have written a pseudo-code

Pseudo-code:
1. Duplicate given array to end
2. If str is NOT empty
3.   set the pointer of end array to the last character - '\0'
4.   set the pointer of end array to the previous character end = lastIndex-1;
5.   While str pointer is less than end pointer (they should meet in the center of given array and stop)
6.     swap first character with the last one
7.     increment str
8.     decrement end 

*/

void reverse(char *str) { // *str means an array like char[] str
	char * end = str; // creates a pointer to array str
	char tmp;

	/*
	Note:
	There is a big difference between *end and end
	*end means end'th character of end array end[end]
	end means the pointing number, initially is set to 0, but can be incremented/decremented without effecting *end array
	*/

	// C String looks like ['a', 'b', 'c', 'd', '\0']
	// I guess this one holds the case when str is an empty array ['\0']
	if (str) { 
		// iterate to the last index of array end (which is copy of str)
		//                         ↓
		//  ['a', 'b', 'c', 'd', '\0']
		while (*end) {
			++end;
		}
		//                   ↓
		//  ['a', 'b', 'c', 'd', '\0']
		--end;

		// stop when loop reached the middle of array
		while (str < end) {
			// in general: swap the first and the last characters, increment

			// put the first character of str to tmp
			tmp = *str;
			
			// set str[0] equal to end[lastIndex-1]
			// and move pointer of str to str[1]
			*str++ = *end;

			// set end[lastIndex-1] to tmp (str[0])
			// decrement pointer of end to end[lastIndex-1-1]
			*end-- = tmp;
		}
	}
}