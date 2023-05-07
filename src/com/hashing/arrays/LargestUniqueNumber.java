/*
 * Given an integer array nums, return the largest integer that only occurs once. 
 * If no integer occurs once, return -1.
 * 
  	Input: nums = [5,7,3,9,4,9,8,3,1]
	Output: 8
	Explanation: The maximum integer in the array is 9 but it is repeated. 
	The number 8 occurs only once, so it is the answer.
 * 
 * */

package com.hashing.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LargestUniqueNumber {

	public static void main(String[] args) {

	}

	public int largestUniqueNumberHash(int[] A) {
		Map<Integer, Integer> count = new HashMap<Integer, Integer>();
		// Store counts of each element
		for (int i : A) {
			count.put(i, count.getOrDefault(i, 0) + 1);
		}
		int result = -1;
		for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
			// If count of the integer is 1 get maximum.
			if (entry.getValue() == 1) {
				result = Math.max(result, entry.getKey());
			}
		}
		return result;
	}

	public int largestUniqueNumber(int[] A) {
		// Sort in ascending order.
		Arrays.sort(A);

		for (int i = A.length - 1; i >= 0; i--) {
			// If there is no duplicate return.
			if (i == 0 || A[i] != A[i - 1])
				return A[i];

			// While duplicates exist.
			while (i > 0 && A[i] == A[i - 1]) {
				i--;
			}
		}
		return -1;
	}
}
