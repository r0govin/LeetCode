
/*
 * 	Problem 2: Letter Combinations of a Phone Number
	Given a string containing digits from 2-9 inclusive, return all possible 
	letter combinations that the number could represent. Return the answer 
	in any order.
	
	A mapping of digits to letters (just like on the telephone buttons) 
	is given below. Note that 1 does not map to any letters.
 
	Example 1:
	Input: digits = "23"
	Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
	Example 2:
	Input: digits = ""
	Output: []
	Example 3:
	Input: digits = "2"
	Output: ["a","b","c"]


	https://www.youtube.com/watch?v=u-HgzgYe8KA&t=5188s

 * */

package com.backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LetterCombinationsPhoneNumberIMP {
	Map<Character, String> mp = Map.of('2', "abc", '3', "def", '4', "ghi", '5', "jkl", '6', "mno", '7', "pqrs", '8',
			"tuv", '9', "wxyz");
	List<String> combination = new ArrayList<>();

	public static void main(String[] args) {
		LetterCombinationsPhoneNumberIMP printResult = new LetterCombinationsPhoneNumberIMP();
		System.out.println(printResult.letterCombinations("244"));
	}

	public List<String> letterCombinations(String digits) {
		if (digits.length() == 0) {
			return combination;
		}
		printAllLetter(0, new StringBuilder(), digits);
		return combination;
	}

	public void printAllLetter(int index, StringBuilder path, String digits) {
		if (index == digits.length()) {
			combination.add(path.toString());
			return;
		}
		String str = mp.get(digits.charAt(index));
		for (char ch : str.toCharArray()) {
			path.append(ch);
			printAllLetter(index + 1, path, digits);
			path.deleteCharAt(path.length() - 1);
		}

	}
}
