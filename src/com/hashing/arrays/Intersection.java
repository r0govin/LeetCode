/*
 * 
    PermutationString 2: 2248. Intersection of Multiple Arrays
    Given a 2D array nums that contains n arrays of distinct integers, return a sorted array 
    containing all the numbers that appear in all n arrays.
    For example, given nums = [[3,1,2,4,5],[1,2,3,4],[3,4,5,6]], return [3, 4]. 3 
    and 4 are the only numbers that are in all arrays.
    
 * */

package com.hashing.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Intersection {

	public static void main(String[] args) {
		Intersection intersection = new Intersection();
		int[][] nums = { { 3, 1, 2, 4, 5 }, { 1, 2, 3, 4 }, { 3, 4, 5, 6 } };
		System.out.println(intersection.intersection(nums));
	}

	public List<Integer> intersection(int[][] nums) {
		Map<Integer, Integer> counts = new HashMap<>();
		for (int[] arr : nums) {
			for (int x : arr) {
				counts.put(x, counts.getOrDefault(x, 0) + 1);
			}
		}
		int n = nums.length;
		List<Integer> ans = new ArrayList<Integer>();
		for (int key : counts.keySet()) {
			if (counts.get(key) == n) {
				ans.add(key);
			}
		}
		Collections.sort(ans);
		return ans;
	}

}
