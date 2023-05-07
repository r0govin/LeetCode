package com.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianFinderIMP {

	private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
	private PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());;

	public void addNum(int num) {
		maxHeap.add(num);
		minHeap.add(maxHeap.remove());
		if (minHeap.size() > maxHeap.size()) {
			maxHeap.add(minHeap.remove());
		}
		this.print();
	}

	public double findMedian() {
		if (maxHeap.size() > minHeap.size()) {
			return maxHeap.peek();
		}

		return (minHeap.peek() + maxHeap.peek()) / 2.0;
	}

	public void print() {
		System.out.println("MaxHeap: " + maxHeap + " MinHeap: " + minHeap);

	}

	public static void main(String[] args) {
		MedianFinderIMP median = new MedianFinderIMP();
		median.addNum(27);
		System.out.println("Median: "+ median.findMedian());
		median.addNum(7);
		System.out.println("Median: "+ median.findMedian());
		median.addNum(47);
		System.out.println("Median: "+ median.findMedian());
		median.addNum(37);
		System.out.println("Median: "+ median.findMedian());
		median.addNum(17);
		System.out.println("Median: "+ median.findMedian());
	}

}
