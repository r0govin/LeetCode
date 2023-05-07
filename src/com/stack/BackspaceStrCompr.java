/*
 * 

    PermutationString 3: 844. Backspace String Compare

    Given two strings s and t, return true if they are equal when both are typed into empty text 
    editors. '#' means a backspace character.

    For example, given s = "ab#c" and t = "ad#c", return true. Because of the backspace, 
    the strings are both equal to "ac".

 * */

package com.stack;

import java.util.Stack;

public class BackspaceStrCompr {

	public static void main(String[] args) {
		BackspaceStrCompr strCompr = new BackspaceStrCompr();
		String s1 = "ab#c";
		String s2 = "ad#c";
		System.out.println(strCompr.backspaceCompare(s1, s2));
	}

	public boolean backspaceCompare(String s, String t) {
		return build(s).equals(build(t));
	}

	public String build(String s) {
		Stack<Character> stack = new Stack<>();
		for (char c : s.toCharArray()) {
			if (c != '#') {
				stack.push(c);
			} else if (!stack.empty()) {
				stack.pop();
			}
		}

		return String.valueOf(stack);
	}
}
