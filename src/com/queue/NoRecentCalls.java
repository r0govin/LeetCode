/*
 * 
    PermutationString: 933. Number of Recent Calls
    Implement the RecentCounter class. It should support ping(int t), which records a 
    call at time t, and then returns an integer representing the number of calls that 
    have happened in the range [t - 3000, t]. Calls to ping will have increasing t.
    
 * */

package com.queue;

import java.util.LinkedList;
import java.util.Queue;

public class NoRecentCalls {

	static Queue<Integer> queue;

	public NoRecentCalls() {
		queue = new LinkedList<>();
	}

	public static void main(String[] args) {
		NoRecentCalls noRecentCalls = new NoRecentCalls();
		System.out.println("Queue: " + queue.toString());
		System.out.println(noRecentCalls.ping(1));
		System.out.println("Queue: " + queue.toString());
		System.out.println(noRecentCalls.ping(100));
		System.out.println("Queue: " + queue.toString());
		System.out.println(noRecentCalls.ping(3000));
		System.out.println("Queue: " + queue.toString());
		System.out.println(noRecentCalls.ping(4001));
		System.out.println("Queue: " + queue.toString());
		System.out.println(noRecentCalls.ping(5001));
		System.out.println("Queue: " + queue.toString());

	}

	public int ping(int t) {
		while (!queue.isEmpty() && queue.peek() < t - 3000) {
			queue.poll();
		}

		queue.offer(t);
		return queue.size();
	}

}
