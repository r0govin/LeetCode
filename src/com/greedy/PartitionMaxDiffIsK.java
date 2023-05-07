/*

    PermutationString 2: 2294. Partition Array Such That Maximum Difference Is K

    Given an integer array nums and an integer k, split nums into subsequences, 
    where each subsequences' maximum and minimum element is within k of each other. 
    What is the minimum number of subsequences needed?

    For example, given nums = [3,6,1,2,5] and k = 2, the answer is 2. 
    The subsequences are [3, 1, 2] and [6, 5].

 * */

package com.greedy;

import java.util.Arrays;

public class PartitionMaxDiffIsK {

	public static void main(String[] args) {

	}

	public int partitionArray(int[] nums, int k) {
		Arrays.sort(nums);
		int ans = 1;
		int x = nums[0];

		for (int i = 1; i < nums.length; i++) {
			if (nums[i] - x > k) {
				x = nums[i];
				ans++;
			}
		}

		return ans;
	}

}
