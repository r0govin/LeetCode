package com.thread;

public class SharedObject {
	private String message;

	public synchronized void setMessage(String message) {
		this.message = message;
		notify();
		System.out.println("thread notified...");
	}

	public synchronized void printMessage() {
		while (message == null) {
			try {
				System.out.println("thread Locked...");
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("print message: " + message);

	}
	
	public static void main (String[] args) {
        SharedObject obj = new SharedObject();

        Thread thread1 = new Thread(() -> {
            obj.printMessage();
        });

        Thread thread2 = new Thread(() -> {
        	try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            obj.setMessage("A message from thread1");
        });

        thread1.start();
        thread2.start();
    }


}
