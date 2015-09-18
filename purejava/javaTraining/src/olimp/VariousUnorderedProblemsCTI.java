package olimp;

// Cracking the Coding Interview problems

import java.util.Arrays;
import java.util.HashSet;
import java.util.Hashtable;

import olimp.LinkedList.LinkedListNode;

public class VariousUnorderedProblemsCTI {

	public static void main(String[] args) {

		long startTime = System.currentTimeMillis();

		String test = "eeeeeeeeeIm a god";

		/*
		 * System.out.println(isUniqueChars(test));
		 * System.out.println(isUniqueChars2(test));
		 * System.out.println(isUniqueChars3(test));
		 * System.out.println(isUniqueChars4(test));
		 */

		/*
		 * removeDuplicates(test.toCharArray());
		 * removeDuplicatesEff(test.toCharArray());
		 */

		/*
		 * String test1 = "abcdef"; String test2 = "fedcba";
		 * System.out.println(areAnagrams(test1, test2));
		 * System.out.println(areAnagrams2(test1, test2));
		 * System.out.println(areAnagrams3(test1, test2));
		 * 
		 * System.out.println(replaceFun(test.toCharArray(), test.length()));
		 * System.out.println(replaceFun2(test.toCharArray()));
		 * 
		 * int matrix[][] = { {1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13,
		 * 14, 15, 16} };
		 */
		// rotate(matrix);
		/*
		 * System.out.println(); rotate3(matrix); System.out.println();
		 * rotate3(matrix); System.out.println(); rotate3(matrix);
		 * System.out.println(); rotate3(matrix);
		 */

		/*
		 * int matrix[][] = { {1, 2, 3, 4}, {5, 6, 0, 8}, {9, 0, 11, 12}, {13,
		 * 14, 15, 16} };
		 * 
		 * setZeros2(matrix);
		 */

		// System.out.println(isRotation("pplea", "apple"));

		/*LinkedList<String> list = new LinkedList<String>();
		list.addLast("Apple");
		list.addLast("Bear");
		list.addLast("Chair");
		list.addLast("Apple");
		list.addLast("Apple");
		list.addLast("Chair2");
		list.addLast("Chair");

		// list.print();

		LinkedListNode<String> head = list.head;
		//deleteDups(head);
		deleteDups2(head);
		
		list.print();*/
		
		LinkedList<String> list1 = new LinkedList<String>();
		LinkedList<String> list2 = new LinkedList<String>();
		list1.addFirst("3");
		list1.addLast("1");
		list1.addLast("5");
		list2.addFirst("5");
		list2.addLast("9");
		list2.addLast("2");
		LinkedListNode<String> list3_head = addLists(list1.head, list2.head, 0);
		list3_head.print();
		
		
		

		long endTime = System.currentTimeMillis();
		// System.out.println("Total execution time: " + (endTime - startTime)
		// + "ms");

	}

	public static boolean isPowerOfTwo(long x) {
		return (x != 0) && ((x & (~x + 1)) == 0);
	}

	// this functions needs to use long instead of int to have 64 bits array
	// O (n) + space: O (1)
	public static boolean isUniqueChars(String str) {
		long checker = 0;
		for (int i = 0; i < str.length(); ++i) {
			int val = str.charAt(i) - 'a';
			if ((checker & (1L << val)) > 0)
				return false;
			checker = checker | (1L << val);
		}
		return true;
	}

	// O (n) + space: O (n)
	public static boolean isUniqueChars2(String str) {
		boolean[] unique = new boolean[256];
		for (int i = 0; i < str.length(); i++) {
			int val = str.charAt(i);
			if (unique[val])
				return false;
			unique[val] = true;
		}
		return true;
	}

	// O (n*n)
	public static boolean isUniqueChars3(String str) {
		for (int i = 0; i < str.length(); i++) {
			for (int j = i + 1; j < str.length(); j++) {
				if (str.charAt(i) == str.charAt(j))
					return false;
			}
		}
		return true;
	}

	// O (log n * n)
	public static boolean isUniqueChars4(String str) {
		char[] sorted = str.toCharArray();
		Arrays.sort(sorted);
		// System.out.println(sorted);
		for (int i = 1; i < sorted.length; i++) {
			if (sorted[i] == sorted[i - 1])
				return false;
		}
		return true;
	}

	public static void removeDuplicates(char[] str) {
		if (str == null)
			return;
		int len = str.length;
		if (len < 2)
			return;

		int tail = 1;

		for (int i = 1; i < len; ++i) {
			/*
			 * if code meets duplicate, it does nothing if not, it just sets
			 */
			int j;
			for (j = 0; j < tail; ++j) {
				if (str[i] == str[j])
					break;
			}
			// System.out.println("i=" + i + " J=" + j + " tail=" + tail);
			if (j == tail) {
				str[tail] = str[i];
				++tail;
			}
		}
		str[tail] = 0;

		for (int k = tail + 1; k < len; k++) {
			str[k] = 0;
		}

		System.out.println(str);
	}

	public static void removeDuplicatesEff(char[] str) {
		if (str == null)
			return;
		int len = str.length;
		if (len < 2)
			return;
		boolean[] hit = new boolean[256];
		/*
		 * for (int i = 0; i < 256; ++i) { hit[i] = false; }
		 */
		hit[str[0]] = true;
		int tail = 1;
		for (int i = 1; i < len; ++i) {
			if (!hit[str[i]]) {
				str[tail] = str[i];
				++tail;
				hit[str[i]] = true;
			}
		}
		str[tail] = 0;

		for (int k = tail + 1; k < len; k++) {
			str[k] = 0;
		}

		System.out.println(str);
	}

	public static boolean areAnagrams(String f, String s) {

		char[] c_f = f.toCharArray();
		Arrays.sort(c_f);

		char[] c_s = s.toCharArray();
		Arrays.sort(c_s);

		return Arrays.equals(c_f, c_s);
	}

	public static boolean areAnagrams2(String s1, String s2) {
		if (s1.length() != s2.length())
			return false;
		int[] letters = new int[256];
		int num_unique_chars = 0;
		int num_completed_s2 = 0;
		s1.toLowerCase();
		s2.toLowerCase();
		char[] s_array = s1.toCharArray();
		for (char c : s_array) { // count number of each char in s.
			if (letters[c] == 0)
				++num_unique_chars;
			++letters[c];
		}
		for (int i = 0; i < s2.length(); ++i) {
			int c = (int) s2.charAt(i);
			if (letters[c] == 0) { // Found more of char c in t than in s.
				return false;
			}
			--letters[c];
			if (letters[c] == 0) {
				++num_completed_s2;
				if (num_completed_s2 == num_unique_chars) {
					// it’s a match if t has been processed completely
					return i == s2.length() - 1;
				}
			}
		}
		return false;
	}

	public static boolean areAnagrams3(String s1, String s2) {
		if (s1.length() != s2.length())
			return false;

		int[] vars_arr = new int[256];
		int uniques = 0;
		int completed = 0;

		for (char c : s1.toCharArray()) {
			if (vars_arr[c] == 0)
				++uniques;
			++vars_arr[c];
		}

		for (int i = 0; i < s2.length(); i++) {
			char c = s2.charAt(i);
			if (vars_arr[c] == 0)
				return false;

			--vars_arr[c];
			if (vars_arr[c] == 0) {
				++completed;
				if (uniques == completed)
					return true;
				// return i == s2.length() - 1;
			}

		}

		return false;
	}

	public static char[] replaceFun(char[] str, int length) {
		int spaceCount = 0, newLength, i = 0;
		for (i = 0; i < length; i++) {
			if (str[i] == ' ') {
				spaceCount++;
			}
		}
		newLength = length + spaceCount * 2;
		char[] str2 = new char[newLength];
		// str2[newLength] = '\0';
		for (i = length - 1; i >= 0; i--) {
			if (str[i] == ' ') {
				str2[newLength - 1] = '0';
				str2[newLength - 2] = '2';
				str2[newLength - 3] = '%';
				newLength = newLength - 3;
			} else {
				str2[newLength - 1] = str[i];
				newLength = newLength - 1;
			}
		}
		return str2;
	}

	public static char[] replaceFun2(char[] str) {

		int spaceCounter = 0;
		int i;
		int len = str.length;

		for (i = 0; i < len; i++) {
			if (str[i] == ' ')
				++spaceCounter;
		}

		int newLength = len + 2 * spaceCounter;
		char[] strFin = new char[newLength];

		for (i = --len; i >= 0; --i) {
			if (str[i] == ' ') {
				strFin[newLength - 1] = '0';
				strFin[newLength - 2] = '2';
				strFin[newLength - 3] = '%';
				newLength -= 3;
			} else {
				strFin[newLength - 1] = str[i];
				--newLength;
			}
		}

		return strFin;
	}

	public static void rotate(int[][] matrix) {
		int n = matrix.length;
		for (int layer = 0; layer < n / 2; ++layer) {
			/*
			 * let's take a look to 1 case of n = 3 layer up to 1 (3/2 = 1)
			 * layer = 0 first = 0 last = 3 - 1 - 0 = 2 i = 0 offset = 0 - 0 = 0
			 * top = matrix[0][0] = 1 matrix[0][0] = matrix[2-0][0] = 7
			 * matrix[2-0][0] = matrix[2][2-0] = 9 matrix[2][2-0] = matrix[0][2]
			 * = 3 matrix[0][2] = 1
			 * -------------------------------------------------------------- i
			 * = 1 offset = 1 - 0 = 1 top = matrix[0][1] = 2 matrix[0][1] =
			 * matrix[2-1][0] = 4 matrix[2-1][0] = matrix[2][2-1] = 8
			 * matrix[2][2-1] = matrix[1][2] = 6 matrix[1][2] = 2
			 */
			int first = layer;
			int last = n - 1 - layer;
			for (int i = first; i < last; ++i) {
				System.out.println();
				int offset = i - first;
				int top = matrix[first][i]; // save top
				// left -> top
				matrix[first][i] = matrix[last - offset][first];

				// bottom -> left
				matrix[last - offset][first] = matrix[last][last - offset];

				// right -> bottom
				matrix[last][last - offset] = matrix[i][last];

				// top -> right
				matrix[i][last] = top; // right <- saved top
			}
		}

		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < n; ++j) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void rotate2(int[][] matrix) {
		int n = matrix.length;
		for (int layer = 0; layer < n / 2; ++layer) {
			int first = layer;
			int last = n - 1 - first;
			for (int i = first; i < last; i++) {
				int offset = i - first;
				int top = matrix[first][i];

				// left -> top, means that top value gets left value
				matrix[first][i] = matrix[last - offset][first];

				// bottom -> left
				matrix[last - offset][first] = matrix[last][last - offset];

				// right -> bottom == 9=3
				matrix[last][last - offset] = matrix[i][last];

				// top -> right
				matrix[i][last] = top;

			}
		}
	}

	public static void rotate3(int[][] matrix) {
		int n = matrix.length;
		for (int layer = 0; layer < n / 2; ++layer) {
			int first = layer;
			int last = n - 1 - first;
			for (int i = first; i < last; ++i) {

				int offset = i - first;

				int top = matrix[first][i];

				// left -> top ; e.g. 1=7
				matrix[first][i] = matrix[last - offset][first];

				// bottom -> left ; e.g. 7=9
				matrix[last - offset][first] = matrix[last][last - offset];

				// right -> bottom ; e.g. 9=3
				matrix[last][last - offset] = matrix[i][last];

				// top -> right
				matrix[i][last] = top;

			}
		}

		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < n; ++j) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}

	}

	public static void setZeros2(int[][] matrix) {

		int[] row = new int[matrix.length];
		int[] column = new int[matrix[0].length];

		for (int i = 0; i < matrix.length; ++i) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == 0) {
					row[i] = 1;
					column[j] = 1;
				}
			}
		}

		for (int i = 0; i < matrix.length; ++i) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (row[i] == 1 || column[j] == 1) {
					matrix[i][j] = 0;
				}
			}
		}

		for (int i = 0; i < matrix.length; ++i) {
			for (int j = 0; j < matrix[0].length; ++j) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}

	}

	public static boolean isRotation(String s1, String s2) {
		int len = s1.length();
		if (len == s2.length() && len > 0) {
			String ss = s1 + s1;
			return ss.indexOf(s2) > -1;
		}

		return false;
	}

	public static void deleteDups(LinkedListNode n) {
		Hashtable<Object, Boolean> table = new Hashtable<Object, Boolean>();
		HashSet<Object> hashSet = new HashSet<Object>();

		LinkedListNode previous = null;
		while (n != null) {
			// System.out.println();
			if (n.data != null)
				/*
				 * if(table.containsKey(n.data)) previous.next = n.next; else {
				 * table.put(n.data, true); previous = n; }
				 */
				if (hashSet.contains(n.data))
					previous.next = n.next;
				else {
					hashSet.add(n.data);
					previous = n;
				}
			n = n.next;
		}
	}

	public static void deleteDups2(LinkedListNode head) {
		if (head == null)
			return;
		LinkedListNode previous = head;
		LinkedListNode current = previous.next;
		while (current != null) {
			LinkedListNode runner = head;
			while (runner != current) { // Check for earlier dups
				if (runner.data == current.data) {
					LinkedListNode tmp = current.next; // remove current
					previous.next = tmp;
					current = tmp; // update current to next node
					break; // all other dups have already been removed
				}
				runner = runner.next;
			}
			if (runner == current) { // current not updated - update now
				previous = current;
				current = current.next;
			}
		}
	}

	public static void deleteDups3(LinkedListNode head) {
		if(head == null) return;
		LinkedListNode previous = head;
		LinkedListNode current = previous.next;
		while(current != null){
			LinkedListNode runner = head;
			while(runner != current){
				if(runner.data == current.data){
					LinkedListNode tmp = current.next;
					previous.next = tmp;
					current = tmp;
				}
			}
			if(runner == current){
				previous = current;
				current = current.next;
			}
		}
	}
	
	public static LinkedListNode nthToLast(LinkedListNode head, int n){
		if(head == null || n < 1) return null;
		LinkedListNode p1 = head;
		LinkedListNode p2 = head;
		for(int i = 0; i < n-1; ++i){
			if(p2 == null) return null;
			p2 = p2.next;
		}
		while(p2 != null){
			p1 = p1.next;
			p2 = p2.next;
		}
		return p1;
	}
	
	public static boolean deleteNode(LinkedListNode n){
		if(n==null || n.next == null) return false;
		LinkedListNode next = n.next;
		n.next = next.next;
		n.data = next.data;
		return true;
	}
	
	public static LinkedListNode addLists(LinkedListNode l1, LinkedListNode l2, int carry) {
		if (l1 == null && l2 == null) {
			return null;
		}
		LinkedListNode result = new LinkedListNode();
		result.data = carry;
		int value = carry;
		//System.out.println("1");
		if (l1 != null) {
			if(l1.data != null) {
				value += Integer.parseInt((String)l1.data);
			}
		}
		if (l2 != null) {
			if(l2.data != null) {
				value += Integer.parseInt((String)l2.data);
			}
		}
		result.data = value % 10;
		LinkedListNode more = addLists(l1 == null ? null : l1.next,
									   l2 == null ? null : l2.next,
									   value >= 10 ? 1 : 0);
		result.next = more;
		return result;
	}

}
















