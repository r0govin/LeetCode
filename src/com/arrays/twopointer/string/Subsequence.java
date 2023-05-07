
/*

    PermutationString 4: 392. Is Subsequence.
    Given two strings s and t, return true if s is a subsequence of t, or false otherwise.
    A subsequence of a string is a new string that is formed from the original string by deleting some 
    (can be none) of the characters without disturbing the relative positions of the remaining characters. 
    (i.e., "ace" is a subsequence of "abcde" while "aec" is not).
*/

package com.arrays.twopointer.string;

public class Subsequence {

	public static void main(String[] args) {
		
		Subsequence subsequence = new Subsequence();
		System.out.println(subsequence.checkSubsequence("ace","abcde"));
		System.out.println(subsequence.checkSubsequence("acm","abcde"));

	}
	
	public boolean checkSubsequence(String s, String t) {
		int i =0, j =0;
		while (i < s.length() && j < t.length()) {
			if (s.charAt(i)==t.charAt(j)) {
				i++;
			}
			j++;
		}
		return i == s.length();
	}

}
