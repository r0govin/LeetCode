
/*
 * Given an integer array arr, count how many elements x there are, such that x + 1 is also 
 * in arr. If there are duplicates in arr, count them separately.
 * 
 	Eg 1: 
	Input: arr = [1,2,3]
	Output: 2
	Explanation: 1 and 2 are counted cause 2 and 3 are in arr.
	 
 	Eg 2:
 	Input: arr = [1,1,3,3,5,5,7,7]
	Output: 0
	Explanation: No numbers are counted, cause there is no 2, 4, 6, or 8 in arr.
 	
 * */

package com.hashing.arrays;

import java.util.HashSet;
import java.util.Set;

public class CountingElements {

	public static void main(String[] args) {
		CountingElements countingElements= new CountingElements();
		int[] arr = {1,2,3};
		System.out.println(countingElements.countElements(arr));
		
	}
	public int countElements(int[] arr) {
	      int count =0;
	      Set<Integer> set = new HashSet<Integer>();
	      for (int i  =0; i < arr.length ; i++) {
	          set.add(arr[i]);
	      }
	      for (int i = 0; i< arr.length; i++) {
	          if (set.contains(arr[i]+1)) {
	              count++;
	          }
	      }
	      return count;
	    }
}
