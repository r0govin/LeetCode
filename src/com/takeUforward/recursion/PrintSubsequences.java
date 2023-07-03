package com.takeUforward.recursion;

import java.util.ArrayList;
import java.util.List;

public class PrintSubsequences {

	List<List<Integer>> result = new ArrayList<>();

	public static void main(String[] args) {
		PrintSubsequences subsequence = new PrintSubsequences();
		int[] values = { 3, 1, 2 };
		System.out.println(subsequence.subsets(values));
		;
	}

	public List<List<Integer>> subsets(int[] nums) {
		ArrayList<Integer> elements = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			elements.add(nums[i]);
		}
		this.printAllSubsequence(0, elements, new ArrayList<>());
		return result;
	}

	public void printAllSubsequence(int index, List<Integer> elements, List<Integer> list) {
		if (index == elements.size()) {
			// System.out.print(list.toString() + " ");
			result.add(new ArrayList<Integer>(list));
			return;
		}
		list.add(elements.get(index));
		printAllSubsequence(index + 1, elements, list);
		list.remove(elements.get(index));
		printAllSubsequence(index + 1, elements, list);
	}
}
