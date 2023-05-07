/* 
 * 
    PermutationString 3: 713. Subarray Product Less Than K.
    Given an array of positive integers nums and an integer k, return the number of 
    contiguous subarrays where the product of all the elements in the subarray is 
    strictly less than k.
    
    For example, given the input nums = [10, 5, 2, 6], k = 100, the answer is 8. 
    The subarrays with products less than k are:
    [10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6]
    
    Key idea: Whenever you see a problem asking for the number of subarrays, 
    think of this: at each index, how many valid subarrays end at this index? 
    Let's split the 8 subarrays by their ending indices:
 * */

package com.arrays.twopointer.slidingwindow.array;

public class SubArrayProduct {

	public static void main(String[] args) {
		SubArrayProduct subArrayProduct = new SubArrayProduct();
		int[] nums = { 10, 5, 2, 6 };
		int k = 100;
		System.out.println(subArrayProduct.numSubarrayProductLessThanK(nums, k));
	}

	public int numSubarrayProductLessThanK(int[] nums, int k) {
		if (k <= 1) {
			return 0;
		}
		int ans = 0;
		int left = 0;
		int curr = 1;
		for (int right = 0; right < nums.length; right++) {
			curr *= nums[right];
			while (left <= right && curr >= k) {
				curr /= nums[left];
				left++;
			}
			ans += right - left + 1;
		}
		return ans;
	}

}
