/*
 * PermutationString 1: 347. Top K Frequent Elements
Given an integer array nums and an integer k, return the k most frequent elements.

 * */

package com.heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements {

	public static void main(String[] args) {
		TopKFrequentElements top = new TopKFrequentElements();
		int[] values = { 5, 4, 3, 3, 2, 2, 2, 1, 1, 1 };
		int k = 3;
		int[] topKFrequent = top.topKFrequent(values, k);
		for (int tp : topKFrequent) {
			System.out.print(tp + " ");
		}
	}

	public int[] topKFrequent(int[] nums, int k) {
		Map<Integer, Integer> counts = new HashMap<>();
		for (int num : nums) {
			counts.put(num, counts.getOrDefault(num, 0) + 1);
		}

		PriorityQueue<Integer> heap = new PriorityQueue<>((n1, n2) -> counts.get(n1) - counts.get(n2));
		for (int num : counts.keySet()) {
			heap.add(num);
			if (heap.size() > k) {
				heap.remove();
			}
		}

		int[] ans = new int[k];
		for (int i = 0; i < k; i++) {
			ans[i] = heap.remove();
		}

		return ans;
	}

}
