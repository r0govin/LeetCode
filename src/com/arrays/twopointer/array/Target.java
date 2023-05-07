
/* 
 * 
    PermutationString 2: Given a sorted array of unique integers and a target integer, return true if there exists 
    a pair of numbers that sum to target, false otherwise. This problem is similar to Two Sum.
    
    For example, given nums = [1, 2, 4, 6, 8, 9, 14, 15] and target = 13, return true because 4 + 9 = 13.
    
    Logic: if sum > target ---> right--
    	   if sum < target ---> left++
    
    In this example, we either increment or decrement any left or right index one time...
 * */

package com.arrays.twopointer.array;

public class Target {
	public static void main(String[] args) {
		int[] nums = { 1, 2, 4, 6, 8, 9, 14, 15 };
		int target = 77;
		System.out.println(checkForTarget(nums, target));
	}

	public static boolean checkForTarget(int[] nums, int target) {
		int left = 0;
		int right = nums.length - 1;
		int sum = 0;

		while (left < right) {
			sum = nums[left] + nums[right];
			if (sum == target) {
				return true;
			} else {
				if (sum > target) {
					right--;
				} else {
					left++;
				}
			}
		}
		return false;
	}
}
