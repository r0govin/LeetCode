package com.thread.semphore;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CountDownLatchDemo {
	public static void main(String[] args) throws InterruptedException {
		ExecutorService service = Executors.newFixedThreadPool(50);
		CountDownLatch countDownLatch = new CountDownLatch(3);
		service.submit(new CountDownLatchTask(countDownLatch, new String("Job1")));
		service.submit(new CountDownLatchTask(countDownLatch, new String("Job2")));
		service.submit(new CountDownLatchTask(countDownLatch, new String("Job3")));

		countDownLatch.await();
		System.out.println(" All Job is completed...");
		service.shutdown();
		service.awaitTermination(1, TimeUnit.MINUTES);
	}
}

class CountDownLatchTask implements Runnable {
	private CountDownLatch countDownLatch;
	private String name;

	public CountDownLatchTask(CountDownLatch countDownLatch, String name) {
		super();
		this.countDownLatch = countDownLatch;
		this.name = name;
	}

	public void run() {
		try {
			Thread.currentThread().sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(name + " CountDownLatchTask is completed...");
		countDownLatch.countDown();
	}
}