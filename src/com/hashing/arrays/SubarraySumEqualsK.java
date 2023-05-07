/*
 * 
 	PermutationString 4: 560. Subarray Sum Equals K
  	Given an integer array nums and an integer k, find the number of subarrays whose 
  	sum is equal to k
  	
 */

package com.hashing.arrays;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {

	public static void main(String[] args) {
		int [] nums = {1, 2, 1, 2, 1};
		int k = 3;
		SubarraySumEqualsK subarray = new SubarraySumEqualsK();
		System.out.println(subarray.subarraySum(nums, k));

	}
	public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> counts = new HashMap<>();
        counts.put(0, 1);
        
        int ans = 0;
        int curr = 0;
        
        for (int num: nums) {
            curr += num;
            ans += counts.getOrDefault(curr - k, 0);
            counts.put(curr, counts.getOrDefault(curr, 0) + 1);
        }
        
        return ans;
    }
}
