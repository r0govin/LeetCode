/*
 * Moving Average from Data Stream
 * 

	Given a stream of integers and a window size, calculate the moving average of all integers 
	in the sliding window.

	Implement the MovingAverage class:

    MovingAverage(int size) Initializes the object with the size of the window size.
    double next(int val) Returns the moving average of the last size values of the stream.

	Input
	["MovingAverage", "next", "next", "next", "next"]
	[[3], [1], [10], [3], [5]]
	Output
	[null, 1.0, 5.5, 4.66667, 6.0]
	
	Explanation
	MovingAverage movingAverage = new MovingAverage(3);
	movingAverage.next(1); // return 1.0 = 1 / 1
	movingAverage.next(10); // return 5.5 = (1 + 10) / 2
	movingAverage.next(3); // return 4.66667 = (1 + 10 + 3) / 3
	movingAverage.next(5); // return 6.0 = (10 + 3 + 5) / 3
 * */
package com.queue;

import java.util.LinkedList;
import java.util.Queue;

public class MovingAverage {

	Queue<Integer> queue = new LinkedList<>();
	int size = 0, sum = 0, count = 0;

	public static void main(String[] args) {
		MovingAverage movingAverage = new MovingAverage(3);
		System.out.println("Queue: "+movingAverage.queue.toString());
		System.out.println(movingAverage.next(1));
		System.out.println("Queue: "+movingAverage.queue.toString());
		System.out.println(movingAverage.next(10));
		System.out.println("Queue: "+movingAverage.queue.toString());
		System.out.println(movingAverage.next(3));
		System.out.println("Queue: "+movingAverage.queue.toString());
		System.out.println(movingAverage.next(5));
		System.out.println("Queue: "+movingAverage.queue.toString());
	}

	public MovingAverage(int size) {
		this.size = size;
	}

	public double next(int val) {
		count++;
		queue.add(val);
		int tail = count > size ? (int) queue.poll() : 0;
		sum = sum - tail + val;
		return sum * 1.0 / Math.min(size, count);
	}

}
