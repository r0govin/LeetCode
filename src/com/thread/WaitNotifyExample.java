package com.thread;

public class WaitNotifyExample {
	public static void main(String[] args) {
		SharedClass sharedClass = new SharedClass();
		Thread t1 = new Thread(new Job1(sharedClass));
		Thread t2 = new Thread(new Job2(sharedClass));
		t1.start();
		t2.start();
	}
}

class Job1 implements Runnable {

	private SharedClass sharedClass;
	private String name = "Job1";

	public Job1(SharedClass _sharedClass) {
		this.sharedClass = _sharedClass;
	}

	public void run() {
		try {
			Thread.currentThread().sleep(2000);
			System.out.println("Thread Name: " + name + " Started..");
			sharedClass.waitUntilComplete();
			System.out.println("Thread Name: " + name + " End..");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class Job2 implements Runnable {

	private SharedClass sharedClass;

	public Job2(SharedClass _sharedClass) {
		this.sharedClass = _sharedClass;
	}

	public void run() {
		try {
			System.out.println("Thread Name: " + "Job 2" + " Started..");
			Thread.currentThread().sleep(5000);
			sharedClass.complete();
			System.out.println("Thread Name: " + "Job 2" + " End..");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class SharedClass {

	private boolean isComplete = false;

	public void waitUntilComplete() throws InterruptedException {
		synchronized (this) {
			while (isComplete == false) {
				System.out.println("Wait is executed..");
				this.wait();
			}
		}
	}

	public void complete() {
		synchronized (this) {
			isComplete = true;
			System.out.println("Notify is wait..");
			this.notify();
		}
	}
}