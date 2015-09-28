package javaTraining;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;

public class LinkedHashSetTest {
	public static void main(String[] args) {
		LinkedHashSet<Integer> lhs = new LinkedHashSet();
		HashSet<Integer> hs = new HashSet();
		
		Random randGen = new Random();
		Integer[] arIn = new Integer[10];
		for (int i = 0; i < arIn.length; i++) {
			arIn[i] = randGen.nextInt(100);
			System.out.println(arIn[i]);
		}
		
		List<Integer> array = Arrays.asList(arIn);
		hs.addAll(array);
		lhs.addAll(array);
		System.out.println(hs);
		System.out.println(lhs);
	}
}
