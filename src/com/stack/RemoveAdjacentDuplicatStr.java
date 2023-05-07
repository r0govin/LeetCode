/*
 * 
    PermutationString 2: 1047. Remove All Adjacent Duplicates In String
    You are given a string s. Continuously remove duplicates (two of the same character beside 
    each other) until you can't anymore. Return the final string after this.

    For example, given s = "abbaca", you can first remove the "bb" to get "aaca". Next, 
    you can remove the "aa" to get "ca". This is the final answer.

 * */

package com.stack;

import java.util.Stack;

public class RemoveAdjacentDuplicatStr {

	public static void main(String[] args) {
		String str = "abbaca";
		RemoveAdjacentDuplicatStr duplicate = new RemoveAdjacentDuplicatStr();
		System.out.println(duplicate.removeDuplicates(str));
	}

	public String removeDuplicates(String s) {
		Stack<Character> stack = new Stack<>();
		for (char c : s.toCharArray()) {
			if (!stack.empty() && stack.peek() == c) {
				stack.pop();
			} else {
				stack.push(c);
			}
		}
		StringBuilder sb = new StringBuilder();
		while (!stack.empty()) {
			sb.append(stack.pop());
		}
		return sb.reverse().toString();
	}

	public String myRemoveDuplicates(String s) {
		Stack<Character> stck = new Stack<>();
		StringBuffer result = new StringBuffer();
		for (char c : s.toCharArray()) {
			if (!stck.isEmpty() && stck.peek() == c) {
				stck.pop();
			} else {
				stck.push(c);
			}
		}
		stck.forEach(a -> result.append(" " + a));
		return result.toString();
	}
}
