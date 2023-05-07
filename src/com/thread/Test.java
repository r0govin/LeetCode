package com.thread;

import java.util.Random;

public class Test {

	public static void main(String[] args) throws InterruptedException {
		Runnable runnable = () -> {
			Random rn = new Random();
			int answer = rn.nextInt(10) + 1;
			System.out.println();
			for (int i = answer; i < answer + 5; i++) {
				System.out.print(" Thread " + (i + 1));
				try {
					Thread.currentThread().sleep(1000);
				} catch (InterruptedException e) {
					// i = answer+5;
					System.out.println("  Thread is interuppted..");
					e.printStackTrace();
					return;
				}
			}
			System.out.println();
		};
		Thread t1 = new Thread(runnable);
		t1.start();
		Thread.currentThread().sleep(3000);
		t1.interrupt();
	}

}
