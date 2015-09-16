package differentAlgorithms;

public class BitManipulation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//String s1 = String.format("Sheet =%8s", Integer.toBinaryString(updateBits(0b1111111111, 0b001, 1, 4) & 0xFFFF)).replace(' ', '0');
		//System.out.println(s1);
	
		System.out.println(printBinary("0.101"));
	
	}
	
	/**
	 * For example. n = 11111111111, m = 010, i = 1, j = 3, 
	 * 1) MASK = clear bits from 1 to 3: 1111111110001
	 * 2) M_modification make m able to fit to those 000: 010 << 1 = 0100
	 * 3) MASK & N : 1111111100011 & 11111111111 = 11111111_000_11
	 * 4) insert M to N : 1111111100011 | 0100 = 11111111_010_1
	 * */
	public static int updateBits(int n, int m, int i, int j) {
		// 1111111111
		int max = ~0; /* All 1’s */

		// 1’s through position j, then 0’s
		// j = 6
		// = 111111111 - ( 001000000  - 000000001) = 111111111 - 00111111 = 1111111111000000
		/*
		 * How does decrement of 1 work?
		 *   001000000
		 *  -000000001
		 *  ---|------
		 *   000111111
		 *   It makes all bits equal to 1 until first bit with value of 1 in upper sequence
		 *   and then all bits after those 1s equal to 0
		 *   
		 * */
		int left = max - ((1 << j) - 1);
		String s1 = String.format("Left=%8s", Integer.toBinaryString(left & 0xFFFF)).replace(' ', '0');
		System.out.println(s1);

		// 1’s after position i
		// i = 2
		// = ( 0000000100 - 0000000001 ) = 00000011
		int right = ((1 << i) - 1);
		s1 = String.format("Right=%8s", Integer.toBinaryString(right & 0xFFFF)).replace(' ', '0');
		System.out.println(s1);
		
		// 1’s, with 0s between i and j
		// 1111111111_0000_00 | 00_0000_11 = 111111111_0000_11
		// | == bitwise or == if 0-0 then 0 else 1
		int mask = left | right;
		s1 = String.format("Mask=%8s", Integer.toBinaryString(mask & 0xFFFF)).replace(' ', '0');
		System.out.println(s1);
		
		// ( 10000000000 & 111111111000011 ) = 10000000000
		// & == bitwise and == if 1-1 then 1 else 0
		int step1 = (n & mask);
		s1 = String.format("Step1=%8s", Integer.toBinaryString(step1 & 0xFFFF)).replace(' ', '0');
		System.out.println(s1);
		
		// ( 10101 << 2 ) = 01010100
		// shifts all bits into the left side || or simply add zeros on the right side
		int step2 = (m << i);
		s1 = String.format("Step2=%8s", Integer.toBinaryString(step2 & 0xFFFF)).replace(' ', '0');
		System.out.println(s1);
		
		// 10000000000 | 01010100 = 10001010100
		int final1 = (n & mask) | (m << i);
		s1 = String.format("Final1=%8s", Integer.toBinaryString(final1 & 0xFFFF)).replace(' ', '0');
		System.out.println(s1);

		// Clear i through j, then put m in there
		return (n & mask) | (m << i);
	}
	
	
	
	public static String printBinary(String n) {
		int intPart = Integer.parseInt(n.substring(0, n.indexOf(".")));
		double decPart = Double.parseDouble(n.substring(n.indexOf(".") , n.length()));
		String int_string = "";
		while (intPart > 0) {
			int r = intPart % 2;
			intPart >>= 1;
			int_string = r + int_string;
		}
		StringBuffer dec_string = new StringBuffer();
		while (decPart > 0) {
			if (dec_string.length() > 32)
				return "ERROR";
			if (decPart == 1) {
				dec_string.append((int) decPart);
				break;
			}
			double r = decPart * 2;
			if (r >= 1) {
				dec_string.append(1);
				decPart = r - 1;
			} else {
				dec_string.append(0);
				decPart = r;
			}
		}
		return int_string + "." + dec_string.toString();
	}
	
	

}
