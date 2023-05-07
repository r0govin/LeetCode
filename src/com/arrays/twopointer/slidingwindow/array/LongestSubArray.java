/*
 * PermutationString 1: Given an array of positive integers nums and an integer k, 
 * find the length of the longest subarray whose sum is less than or equal to k.
 * 
 * Let's use an integer curr that tracks the sum of the current window. 
 * Since the problem wants subarrays whose sum is less than or equal to k, 
 * we want to maintain curr <= k. Let's look at an example where 
 * nums = [3, 1, 2, 7, 4, 2, 1, 1, 5] and k = 8.
 * The window starts empty, but we can grow it to [3, 1, 2] while maintaining the constraint. 
 * However, after adding the 7, the window's sum becomes too large. 
 * We need to tighten the window until the sum is below 8 again, 
 * which doesn't happen until our window looks like [7]. 
 * When we try to add the next element, our window again becomes too large, 
 * and we need to remove the 7 which means we have [4]. We can now grow the window 
 * until it looks like [4, 2, 1, 1], but adding the next element makes the sum too large. 
 * We remove elements from the left until it fits the constraint again, 
 * which happens at [1, 1, 5]. The longest subarray we found was [4, 2, 1, 1] 
 * which means the answer is 4.
 * When we add an element to the window by moving the right bound, 
 * we just do curr += value. When we remove an element from the window by moving the left bound,
 * we just do curr -= value. We should remove elements so long as curr > k
 * */


package com.arrays.twopointer.slidingwindow.array;

public class LongestSubArray {

	public static void main(String[] args) {
		LongestSubArray longestSubArray = new LongestSubArray();
		int k =8;
		int[] nums = {3, 1, 2, 7, 4, 2, 1, 1, 5};
		System.out.println(longestSubArray.checkLongestSubarray(nums, k));

	}

	public int checkLongestSubarray(int[] nums, int k) {
		int left = 0;
		int curr = 0;
		int right = 0;
		int ans = 0;
		
		for (right =0 ; right < nums.length ;right++) {
			curr += nums[right];
			while (curr > k) {
				curr -= nums[left];
				left++;
			}
			ans = Math.max(ans, right-left+1);
		}
		return ans ;
	}
}
