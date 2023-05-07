package com.backtracking;

public class Test {

	public static void main(String[] args) {
		String str = "abc";
		printString(str, "");
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
