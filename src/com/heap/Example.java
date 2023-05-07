package com.heap;

import java.util.PriorityQueue;

public class Example {

	public static void main(String[] args) {
		PriorityQueue<Integer> heap = new PriorityQueue<>();
		int[] nums = { 67, 341, 234, -67, 12, -976 };
		
		for (int va: nums) {
			System.out.print(va + " ");
		}
		

		for (int num : nums) {
			heap.add(num);
		}
		System.out.println();
		System.out.println(heap);
		heap.add(7451);
		heap.add(-5352);
		System.out.println(heap);
		System.out.println();
		 while (!heap.isEmpty()) {
	            System.out.print(heap.remove()+" ");
	        }

	}

}
