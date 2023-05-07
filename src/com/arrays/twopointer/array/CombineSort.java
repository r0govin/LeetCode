
/*
 * 
 * */

package com.arrays.twopointer.array;

import java.util.*;

public class CombineSort {

	public static void main(String[] args) {
		int[] arr1 = {1,4,7,20};
		int[] arr2 = {3,5,6};
		
//		int[] arr1 = {2,2,2,2,2,2};
//		int[] arr2 = {1,1,1,1,1,1};
		System.out.println(combine(arr1,arr2));
	}

	// arr = 1,4,7,20 arr2 = 3,5,6
	public static List<Integer> combine(int[] arr1, int[] arr2) {
		List<Integer> ans = new ArrayList<>();
	    int i = 0;
	    int j = 0;

	    while (i < arr1.length && j < arr2.length) {
	        if (arr1[i] < arr2[j]) {
	            ans.add(arr1[i]);
	            i++;
	        } else {
	            ans.add(arr2[j]);
	            j++;
	        }
	    }

	    while (i < arr1.length) {
	        ans.add(arr1[i]);
	        i++;
	    }

	    while (j < arr2.length) {
	        ans.add(arr2[j]);
	        j++;
	    }

	    return ans;
	}
}
