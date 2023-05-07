package com.queue;

import java.util.LinkedList;
import java.util.Queue;

public class Demo {

	@SuppressWarnings("static-access")
	public static void main(String[] args) throws InterruptedException {        
        Queue<Integer> queue = new LinkedList<>();
        
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        
        while (!queue.isEmpty()) {
            // poll() removes and returns from the front of the queue
        	Thread.currentThread().sleep(2000);
            System.out.println(queue.poll());
        }
        
        if (queue.isEmpty()) {
        	Thread.currentThread().sleep(2000);
            System.out.println("Queue is empty!");
        }
    }
}
