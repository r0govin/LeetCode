package com.thread.semphore;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CyclicBarrierExample {
	public static void main(String[] args) throws InterruptedException {
		ExecutorService service = Executors.newFixedThreadPool(50);
		CyclicBarrier cyclicBarrier = new CyclicBarrier(3);
		service.submit(new CyclicBarrierTask("Job1 ", cyclicBarrier, 3000));
		service.submit(new CyclicBarrierTask("Job2 ", cyclicBarrier, 6000));
		service.submit(new CyclicBarrierTask("Job3 ", cyclicBarrier, 9000));
		service.shutdown();
		service.awaitTermination(1, TimeUnit.MINUTES);
	}
}

class CyclicBarrierTask implements Runnable {
	private String name;
	private CyclicBarrier cyclicBarrier;
	private int numberMilliSecond;

	public CyclicBarrierTask(String name, CyclicBarrier cyclicBarrier, int numberMilliSecond) {
		super();
		this.name = name;
		this.cyclicBarrier = cyclicBarrier;
		this.numberMilliSecond = numberMilliSecond;
	}

	public void run() {
		try {
			System.out.println("Thread " + name + " started execution.." + " Millisecond "+ numberMilliSecond );
			Thread.sleep(numberMilliSecond);
			System.out.println("Thread " + name + " waiting...");
			cyclicBarrier.await();
			System.out.println("Thread " + name + " completed execution..");
		} catch (InterruptedException | BrokenBarrierException e) {
			e.printStackTrace();
		}
	}
}
