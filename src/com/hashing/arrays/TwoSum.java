/*
 * 
    PermutationString 1: 1. Two Sum
    Given an array of integers nums and an integer target, return indices of two numbers such that 
    they add up to target. You cannot use the same index twice.
 * */

package com.hashing.arrays;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
	public static void main(String[] args) {
		TwoSum TwoSum = new TwoSum();
		int[] input = { 5, 2, 7, 10, 3, 9 };
		int[] twoSum = TwoSum.getTwoSum(input, 8);
		for (int a = 0; a < twoSum.length; a++) {
			System.out.println(twoSum[a]);
		}
	}

	public int[] getTwoSum(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			int val = target - nums[i];
			if (map.containsKey(val)) {
				return new int[] { i, map.get(val) };
			} else
				map.put(nums[i], i);
		}
		return new int[] { -1, -1 };
	}
}
