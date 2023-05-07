package com.thread.semphore;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

public class PhaserExample {

	public static void main(String[] args) throws InterruptedException {
		ExecutorService service = Executors.newFixedThreadPool(50);
		Phaser phaser = new Phaser(3);
		service.submit(new PhaserTask("Job1 ", phaser, 3000));
		service.submit(new PhaserTask("Job2 ", phaser, 6000));
		service.submit(new PhaserTask("Job3 ", phaser, 9000));
		phaser.awaitAdvance(1);
		System.out.println(" Main thread is execution completed... ");
		service.shutdown();
		service.awaitTermination(1, TimeUnit.MINUTES);
	}

}

class PhaserTask implements Runnable {
	private String name;
	private Phaser phaser;
	private int numberMilliSecond;

	public PhaserTask(String name, Phaser phaser, int numberMilliSecond) {
		super();
		this.name = name;
		this.phaser = phaser;
		this.numberMilliSecond = numberMilliSecond;
	}

	public void run() {
		try {
			System.out.println("Thread " + name + " started execution.." + " Millisecond " + numberMilliSecond);
			Thread.sleep(numberMilliSecond);
			System.out.println("Thread " + name + " waiting...");
			phaser.arrive();
			System.out.println("Thread " + name + " completed execution..");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
