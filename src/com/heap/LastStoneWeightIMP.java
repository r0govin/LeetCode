/*
 * 

    PermutationString 1: 1046. Last Stone Weight
    You are given an array of integers stones where stones[i] is the weight of the 
    stone. On each turn, we choose the heaviest two stones and smash them 
    together. Suppose the heaviest two stones have weights x and y with x <= y. 
    If x == y, then both stones are destroyed. If x != y, then x is destroyed 
    and y loses x weight. Return the weight of the last remaining stone, or 0 
    if there are no stones left.
    
  

 * */

package com.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LastStoneWeightIMP {

	public static void main(String[] args) {
		LastStoneWeightIMP LastStoneWeightIMP = new LastStoneWeightIMP();
		int[] stones = { 2, 7, 4, 1, 8, 1 };
		System.out.println(LastStoneWeightIMP.lastStoneWeight(stones));
	}

	public int lastStoneWeight(int[] stones) {
		PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.reverseOrder());
		for (int stone : stones) {
			heap.add(stone);
		}

		while (heap.size() > 1) {
			int first = heap.remove();
			int second = heap.remove();
			if (first != second) {
				heap.add(first - second);
			}
		}

		return heap.isEmpty() ? 0 : heap.remove();
	}

}
