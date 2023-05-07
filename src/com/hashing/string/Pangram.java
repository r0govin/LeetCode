


package com.hashing.string;

import java.util.HashSet;
import java.util.Set;

public class Pangram {

	public static void main(String[] args) {
		Pangram pangram = new Pangram() ;
		String str = "kiran";
//		for (int i =0 ; i < 26 ; i++) {
//			char c = (char)('a' + i);
//			System.out.println(c);
//		}
		System.out.println(pangram.checkIfPangramBit("thequickbrownfoxjumpsoverthelazydog"));

	}
	
	// Best approach
	
	public boolean checkIfPangramBit(String sentence) {
        // Initialize seen = 0 since we start with no letter.
        int seen = 0;
        
        // Iterate over 'sentence'.
        for (char currChar : sentence.toCharArray()) {
            // Map each 'currChar' to its index using its ASCII code.
            int mappedIndex = currChar - 'a';

            // 'currBit' represents the bit for 'currChar'.
            int currBit = 1 << mappedIndex;

            // Use 'OR' operation since we only add its bit for once.
            seen |= currBit;
        }
        
        // Once we finish iterating, check if 'seen' contains 26 bits of 1.
        return seen == (1 << 26) - 1;
    }
	
	// Better Approach....
	
	public boolean checkIfPangramSet(String sentence) {
        // Empty set 'seen'.
        Set<Character> seen = new HashSet<>();
        
        // Iterate over 'sentence' add every letter to 'seen'.
        for (char currChar : sentence.toCharArray())
            seen.add(currChar);
        
        // If the size of 'seen' is 26, then 'sentence' is a pangram.
        return seen.size() == 26;
    }
	
	public boolean checkIfPangram(String sentence) {
        // We iterate over 'sentence' for 26 times, one for each letter 'currChar'.
        for (int i = 0; i < 26; ++i) {
            char currChar = (char)('a' + i);

            // If 'sentence' doesn't contain currChar, it is not a pangram.
            if (sentence.indexOf(currChar) == -1)
                return false;
        }
        
        // If we manage to find all 26 letters, it is a pangram.
        return true;
    }

}
