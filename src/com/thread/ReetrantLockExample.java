package com.thread;

import java.util.concurrent.locks.ReentrantLock;

public class ReetrantLockExample {
	public static void main(String[] args) throws InterruptedException {
		Operation operation = new Operation();
		Thread t1 = new Thread(new Add(operation, 2, 2));
		Thread t2 = new Thread(new Subtract(operation, 2, 2));
		System.out.println("T1 start");
		t1.start();
		t1.join();
		System.out.println("T1 join completed..");
		System.out.println("T2 start");
		t2.start();
		t2.join();
		System.out.println("T2 join completed..");
		System.out.println(operation.result);
	}
}

class Subtract implements Runnable {
	private int a;
	private int b;
	private Operation operation;

	public Subtract(Operation operation, int a, int b) {
		this.operation = operation;
		this.a = a;
		this.b = b;
	}

	public void run() {
		try {
			operation.subtract(a, b);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

class Add implements Runnable {
	private int a;
	private int b;
	private Operation operation;

	public Add(Operation operation, int a, int b) {
		this.operation = operation;
		this.a = a;
		this.b = b;
	}

	public void run() {
		try {
			operation.add(a, b);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

class Operation {
	volatile int result = 0;
	ReentrantLock lock1 = new ReentrantLock();
	ReentrantLock lock2 = new ReentrantLock();

	public void multiply(int a, int b) {
		result = a * b;
	}

	public void add(int a, int b) throws InterruptedException {
		lock1.lockInterruptibly();
		result = a + b;
		lock1.unlock();
	}

	public void subtract(int a, int b) throws InterruptedException {
		lock2.lockInterruptibly();
		result = a - b;
		lock2.unlock();
	}
}