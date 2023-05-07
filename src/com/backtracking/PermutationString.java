package com.backtracking;

public class PermutationString {
	public static void main(String[] args) {
		PermutationString permutationString = new PermutationString();
		permutationString.printAllPermutation("ABC", 0, "");
		
		/* other example code....
		String str = "abc";
		printString(str, ""); */
	}

	public void printAllPermutation(String str, int idx, String perm) {
//		System.out.println("*****************START********************");
//		System.out.println();
//		System.out.println("str: " + str + " idx: " + idx + " perm: " + perm);
		if (str.length() == 0) {
			System.out.println(perm);
			return;
		}
		for (int i = 0; i < str.length(); i++) {
			char currChar = str.charAt(i);
			String newStr = str.substring(0, i) + str.substring(i + 1);
//			System.out.println("currChar: " + currChar + " newStr: " + newStr);
			printAllPermutation(newStr, idx + 1, perm + currChar);
		}
		// System.out.println("*****************END********************");
	}
	
	public static void printString(String str, String perm) {
		if (str.length() == 0) {
			System.out.println(perm);
		}

		for (int i = 0; i < str.length(); i++) {
			char curr = str.charAt(i);
			String newStr = str.substring(0, i) + str.substring(i + 1);
			printString(newStr, perm + curr);
		}
	}
}
