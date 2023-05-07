/*
 * Two-pointers is an extremely common technique used to solve array and string problems. 
 * It involves having two integer variables that both move along an iterable. In this article, 
 * we are focusing on arrays and strings. This means we will have two integers, 
 * usually named something like i and j, or left and right which each represent an index of 
 * the array or string.

	There are several ways to implement two-pointers. To start, let's look at the following method:
	Start the pointers at the edges of the input. Move them towards each other until they meet.
	
	Converting this idea into instructions:

    1.	Start one pointer at the first index 0 and the other pointer at the last index input.length - 1.
    2.	Use a while loop until the pointers are equal to each other.
    3.	At each iteration of the loop, move the pointers towards each other. This means either increment 
    the pointer that started at the first index, decrement the pointer that started at the last index, 
    or both. Deciding which pointers to move will depend on the problem we are trying to solve.

 * */

package com.arrays.twopointer.string;

public class Polindrome {
	public static void main(String[] args) {
		System.out.println(checkPalindrome("1malayalam1"));
	}

	public static boolean checkPalindrome(String str) {
		int length = str.length();
		for (int left = 0, right = length - 1; left <= right; left++, right--) {
			if (str.charAt(left) != str.charAt(right)) {
				return false;
			}
		}
		return true;
	}

	public static boolean checkPalindromeString(String s) {
		int left = 0;
		int right = s.length() - 1;

		while (left < right) {
			if (s.charAt(left) != s.charAt(right)) {
				return false;
			}

			left++;
			right--;
		}
		return true;
	}
}

