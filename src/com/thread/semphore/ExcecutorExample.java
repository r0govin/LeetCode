package com.thread.semphore;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ExcecutorExample {
	public static void main(String[] args) throws InterruptedException {
		ExecutorService service = new ThreadPoolExecutor(1, 100, 3000, TimeUnit.SECONDS, new ArrayBlockingQueue<>(5));
		for (int i = 1; i < 100; i++) {
			String name = new String("" + i);
			service.execute(new ExecutorTask(new String(name)));
		}
		service.shutdown();
		service.awaitTermination(1, TimeUnit.MINUTES);
	}
}

class ExecutorTask implements Runnable {

	private String name;

	public ExecutorTask(String name) {
		super();
		this.name = name;
	}

	@Override
	public void run() {
		try {
			Thread.currentThread().sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Thread " + name + " Job competed...");
	}

}

class CustomRejectionHandler implements RejectedExecutionHandler {

	public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
		System.out.println("Task got rejected...");
	}

}
