/*
 * Given an array nums containing n distinct numbers in the range [0, n], return the only 
 * number in the range that is missing from the array.
 * 
  	Eg 1:
  	Input: nums = [3,0,1]
	Output: 2
	Explanation: n = 3 since there are 3 numbers, so all numbers are in the range [0,3].
	2 is the missing number in the range since it does not appear in nums.

	Eg 2:
	Input: nums = [9,6,4,2,3,5,7,0,1]
	Output: 8
	Explanation: n = 9 since there are 9 numbers, so all numbers are in the range [0,9]. 
	8 is the missing number in the range since it does not appear in nums.
	
 *  
 * */

package com.hashing.arrays;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class MissingNumber {

	public static void main(String[] args) {
		
		MissingNumber missingNumber = new MissingNumber();
		int[] nums = {1,2,3,4,5,6,7,8,9,10,11,12};	
		System.out.println(missingNumber.missingNumberAddition(nums));
	}
	
	public int missingNumberAddition(int[] nums) {

		int expectedSum = 0, actualSum = 0;
		for (int i = 0 ; i <=nums.length ; i++) {
			expectedSum += i;
		}
		for (int i = 0 ; i <nums.length ; i++) {
			actualSum += nums[i];
		}
		return expectedSum-actualSum;
	}
	
	public int missingNumberXor(int[] nums) {
		int expectedXor =0;
		for (int i =0 ; i <= nums.length ; i++) {
			System.out.println(" Before ---> expectedXor: "+ expectedXor + " i: "+ i);
			expectedXor = expectedXor ^ i;
			System.out.println("After  expectedXor: "+ expectedXor);
		}
		int actualXor = 0;
		for (int j =0 ; j < nums.length ; j++) {
			System.out.println(" Before ---> actualXor: "+ actualXor + " nums[j]: "+ nums[j]);
			actualXor = actualXor ^ nums[j];
			System.out.println("After actualXor: "+ actualXor);
		}
		System.out.println();
		System.out.println("ExpectedXor: "+ expectedXor + " ActualXor: "+ actualXor);
		
		int missingNumber = expectedXor ^ actualXor ;
		System.out.println("expectedXor ^ actualXor: "+ missingNumber);
		return missingNumber;
	}
	
	public int missingNumberSort(int[] nums) {
		Arrays.sort(nums);
		int n = nums.length;
		for (int i  =0; i < n ; i++) {
			if (nums[i]!=i) {
				return i;
			}
		}
		return n;
	}
	
	public int missingNumber(int[] nums) {
		Set<Integer> set = new TreeSet<Integer>(); 
		int missingNumber = 0 ;
		if (nums.length ==1) {
			return nums.length;
		}
		for (int i =0 ; i < nums.length ; i++) {
			set.add(nums[i]);
		}
		Object[] values = set.toArray();
		for (int i = 1; i < values.length -1; i++) {
			if (values[i+1] !=null) {
				int curr = (int) values[i];
				int next =	(int) values[i+1];
				if (next-curr ==2) {
					missingNumber = next-1 ;
					return missingNumber;
				}
			}
		}
		if (missingNumber != nums.length) {
			return nums.length;
		}
		return -1;
	}

}
