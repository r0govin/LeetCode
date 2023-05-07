package com.thread.semphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemphoreExample {
	public static void main(String[] args) throws InterruptedException {
		Semaphore semphore = new Semaphore(3);
		ExecutorService service = Executors.newFixedThreadPool(50);
		for (int i = 1; i <= 10; i++) {
			service.execute(new SemphoreJob(semphore, new String("Thread-" + i)));
		}
		service.shutdown();
		service.awaitTermination(1, TimeUnit.MINUTES);
	}
}

class SemphoreJob implements Runnable {
	private Semaphore semphore;
	private String name;

	public SemphoreJob(Semaphore _semphore, String _name) {
		this.semphore = _semphore;
		this.name = _name;
	}

	public void run() {

		try {
			System.out.println(name + " aquired the lock...");
			semphore.acquireUninterruptibly();
			Thread.currentThread().sleep(10000);
			semphore.release();
			System.out.println(name + " released the lock...");
		} catch (InterruptedException e1) {

			e1.printStackTrace();
		}

	}
}
