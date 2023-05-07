/*
 * 
 * You are given an integer array nums consisting of n elements, and an integer k.
 * Find a contiguous subarray whose length is equal to k that has the maximum average 
 * value and return this value. Any answer with a calculation error less than 10-5 will 
 * be accepted.
 * 
 * PermutationString:1
 * Input: nums = [1,12,-5,-6,50,3], k = 4
 * Output: 12.75000
 * Explanation: Maximum average is (12 - 5 - 6 + 50) / 4 = 51 / 4 = 12.75
 * 
 * PermutationString:2
 * Input: nums = [5], k = 1
 * Output: 5.00000
 * 
 * */

package com.arrays.twopointer.slidingwindow.array;

public class SubArrayAverageFIxedLength {

	public static void main(String[] args) {

		int nums[] = { 1, 12, -5, -6, 50, 3 };
		int k = 4;
		SubArrayAverageFIxedLength subArrayAverage = new SubArrayAverageFIxedLength();
		System.out.println(subArrayAverage.findMaxAverage(nums, k));
	}

	public double findMaxAverage(int[] nums, int k) {
		double curr = 0;
		double ans = 0;
		for (int i = 0; i < k; i++) {
			curr += nums[i];
		}
		ans = curr;
		for (int j = k; j < nums.length; j++) {
			curr += (nums[j] - nums[j - k]);
			ans = Math.max(ans, curr);
		}
		return ans / k;
	}
}
