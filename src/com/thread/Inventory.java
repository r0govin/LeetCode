package com.thread;

public class Inventory {
	private volatile long item;

	Object lock1 = new Object();
	Object lock2 = new Object();

	public void incrementItem() {
		synchronized (lock1) {
			item++;
		}
	}

	public void decrementItem() {
		synchronized (lock1) {
			item--;
		}

	}

	public long getItem() {
		return this.item;
	}

	public static void main(String[] args) throws InterruptedException {
		Inventory inventory = new Inventory();
		IncrementInventory incrementInventory = new IncrementInventory(inventory);
		DecrementInventory decrementInventory = new DecrementInventory(inventory);
		Thread incrementThread = new Thread(incrementInventory);
		Thread decrementThread = new Thread(decrementInventory);

		incrementThread.start();
		decrementThread.start();
		incrementThread.join();
		decrementThread.join();

		System.out.println("total item details: " + inventory.getItem());
	}
}

class DecrementInventory implements Runnable {

	private Inventory inventory;

	public DecrementInventory(Inventory invent) {
		this.inventory = invent;
	}

	public void run() {
		for (int i = 0; i < 10000; i++) {
			inventory.decrementItem();
		}
	}

}

class IncrementInventory implements Runnable {

	private Inventory inventory;

	public IncrementInventory(Inventory invent) {
		this.inventory = invent;
	}

	public void run() {
		for (int i = 0; i < 10000; i++) {
			inventory.incrementItem();
		}
	}

}
