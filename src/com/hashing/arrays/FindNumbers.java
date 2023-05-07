
/*
 * PermutationString 3: Given an integer array nums, find all the numbers x that satisfy the following: 
 * x + 1 is not in nums, and x - 1 is not in nums.
 * 
 * */

package com.hashing.arrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindNumbers {
	public static void main(String[] args) {
		
	}
	public List<Integer> findNumbers(int[] nums) {
	    List<Integer> ans = new ArrayList<>();
	    Set<Integer> numSet = new HashSet<>();
	    for (int num: nums) {
	        numSet.add(num);
	    }
	    for (int num: nums) {
	        if (!numSet.contains(num + 1) && !numSet.contains(num - 1)) {
	            ans.add(num);
	        }
	    }
	    return ans;
	}
}
