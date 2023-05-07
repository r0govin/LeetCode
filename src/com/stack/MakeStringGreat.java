/*
 * 
Given a string s of lower and upper case English letters.
A good string is a string which doesn't have two adjacent characters s[i] and s[i + 1] where:
0 <= i <= s.length - 2
s[i] is a lower-case letter and s[i + 1] is the same letter but in upper-case or vice-versa.

To make the string good, you can choose two adjacent characters that make the string bad 
and remove them. You can keep doing this until the string becomes good.

Return the string after making it good. The answer is guaranteed to be unique under the given 
constraints.
Notice that an empty string is also good.

Input: s = "leEeetcode"
Output: "leetcode"
Explanation: In the first step, either you choose i = 1 or i = 2, both will result "leEeetcode" 
to be reduced to "leetcode".

Input: s = "abBAcC"
Output: ""
Explanation: We have many possible scenarios, and all lead to the same answer. For example:
"abBAcC" --> "aAcC" --> "cC" --> ""
"abBAcC" --> "abBA" --> "aA" --> ""
 * */

package com.stack;

import java.util.Stack;

public class MakeStringGreat {

	public static void main(String[] args) {
		String s = "leEeetcode";
		MakeStringGreat makeString = new MakeStringGreat();
		System.out.println(makeString.makeGood(s));
	}
	
	 public String makeGood(String s) {
	        // Use stack to store the visited characters.
	        Stack<Character> stack = new Stack<>();
	        
	        // Iterate over 's'.
	        for (char ch : s.toCharArray()) {
	            // If the current character make a pair with the last character in the stack,
	            // remove both of them. Otherwise, we the add current character to stack.
	        	if (!stack.isEmpty() && Math.abs(stack.peek() - ch) == 32) 
	        		// ABOVE METHOD IS IMPORTANT......
	                stack.pop();
	            else
	                stack.add(ch);
	        }
	        
	        // Returns the string concatenated by all characters left in the stack.
	        StringBuilder result = new StringBuilder();
	        for (char c : stack) 
	        	result.append(c);
	        return result.toString();
	    }

	public String makeGoodIteration(String s) {
		StringBuilder newS = new StringBuilder(s);

		// if s has less than 2 characters, we just return itself.
		while (newS.length() > 1) {
			// 'find' records if we find any pair to remove.
			boolean find = false;

			// Check every two adjacent characters, currChar and nextChar.
			for (int i = 0; i < newS.length() - 1; ++i) {
				char currChar = newS.charAt(i), nextChar = newS.charAt(i + 1);

				// If they make a pair, remove them from 's' and let 'find = true'.
				if (Math.abs(currChar - nextChar) == 32) {
					newS.deleteCharAt(i);
					newS.deleteCharAt(i);
					find = true;
					break;
				}
			}

			// If we cannot find any pair to remove, break the loop.
			if (!find)
				break;
		}
		return newS.toString();
	}
}
