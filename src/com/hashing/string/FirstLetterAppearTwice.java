/*
 * 
    PermutationString 2: 2351. First Letter to Appear Twice
    Given a string s, return the first character to appear twice. It is guaranteed that the 
    input will have a duplicate character.
 * */

package com.hashing.string;

import java.util.HashSet;
import java.util.Set;

public class FirstLetterAppearTwice {
	public static void main(String[] args) {
		FirstLetterAppearTwice letterAppearTwice = new FirstLetterAppearTwice();
		System.out.println(letterAppearTwice.repeatedCharacter("ravikiran"));

	}

	public char repeatedCharacter(String s) {
		Set<Character> seen = new HashSet<>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (seen.contains(c)) {
				return c;
			}
			seen.add(c);
		}
		return ' ';
	}
}
