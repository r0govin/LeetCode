/*
 	PermutationString 1: 20. Valid Parentheses

	Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', 
	determine if the input string is valid. The string is valid if all open brackets 
	are closed by the same type of closing bracket in the correct order, and 
	each closing bracket closes exactly one open bracket.
	
	For example, s = "({})" and s = "(){}[]" are valid, but s = "(]" and s = "({)}" 
	are not valid
*/

package com.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {

	public static void main(String[] args) {
		ValidParentheses validParentheses = new ValidParentheses();
		String s = "{([]){}}";
		System.out.println(validParentheses.isValid(s));
	}

	public boolean isValid(String s) {
		Map<Character, Character> matching = new HashMap<>();
		matching.put('(', ')');
		matching.put('[', ']');
		matching.put('{', '}');

		Stack<Character> stack = new Stack<>();
		for (char c : s.toCharArray()) {
			if (matching.containsKey(c)) { // if c is an opening bracket
				stack.push(c);
			} else {
				if (stack.empty()) {
					return false;
				}
				char previousOpening = stack.pop();
				if (matching.get(previousOpening) != c) {
					return false;
				}
			}
		}

		return stack.empty();
	}

}
