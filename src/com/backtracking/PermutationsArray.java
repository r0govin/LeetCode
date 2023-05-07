
/*
 * Given an array nums of distinct integers, return all the possible permutations. 
 * You can return the answer in any order.
 * 
 * 	Example 1:

		Input: nums = [1,2,3]
		Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
		
	Example 2:
	
		Input: nums = [0,1]
		Output: [[0,1],[1,0]]

	Example 3:

		Input: nums = [1]
		Output: [[1]]

 * */

package com.backtracking;

import java.util.ArrayList;
import java.util.List;

public class PermutationsArray {
	
	public static void main(String[] args) {
		int[] nums = {1,2,3};
		PermutationsArray permutationsArray = new PermutationsArray();
		permutationsArray.permute(nums);
	}
	
	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> ans = new ArrayList<>();
		backtrack(new ArrayList<>(), ans, nums);
		return ans;
	}

	public void backtrack(List<Integer> curr, List<List<Integer>> ans, int[] nums) {		
		// below code for printing purpose only....
		/* nums = {1,2,3} */System.out.println();
		String val = "";for (int v: nums) {val += v;}
		System.out.println("Curr: "+ curr+ " Ans: "+ ans + " nums: "+ val);
		System.out.println("curr.size="+ curr.size() + " nums.length="+ nums.length);
		if (curr.size() == nums.length) {
			ans.add(new ArrayList<>(curr));
			return;
		}
        
		for (int num : nums) {
			System.out.println();
			System.out.println("Loop Started....");
			System.out.println("Num: "+ num + " Curr: "+ curr+ " Ans: "+ ans );
			if (!curr.contains(num)) {
				curr.add(num);
				System.out.println("curr added "+ num);
				backtrack(curr, ans, nums);
				Integer remove = curr.remove(curr.size() - 1);
				System.out.println("curr removed "+ remove);
			}
			System.out.println("Loop End....");
			System.out.println("");
		}
		System.out.println("");
	}
}
