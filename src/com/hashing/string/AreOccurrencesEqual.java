/*
 * 
    PermutationString 3: 1941. Check if All Characters Have Equal Number of Occurrences
    Given a string s, determine if all characters have the same frequency.
    
    For example, given s = "abacbc", return true. All characters appear twice. 
    Given s = "aaabb", return false. "a" appears 3 times, "b" appears 2 times. 3 != 2.
    
 * */

package com.hashing.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AreOccurrencesEqual {
	
	public static void main(String[] args) {
		AreOccurrencesEqual areOccurrencesEqual = new AreOccurrencesEqual();
		String s = "abab";
		System.out.println(areOccurrencesEqual.areOccurrencesEqual(s));
	}
	public boolean areOccurrencesEqual(String s) {
		Map<Character, Integer> mp = new HashMap<>();
		Set<Integer> set = new HashSet<Integer>();
		for (int i =0; i< s.length(); i++) {
			char c = s.charAt(i);
			mp.put(c, mp.getOrDefault(c, 0)+1);
		}
		for (int val: mp.values()) {
			set.add(val);
		}
		return set.size()==1;
	 }
}
