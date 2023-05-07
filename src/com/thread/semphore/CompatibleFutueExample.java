package com.thread.semphore;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class CompatibleFutueExample {
	

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		for (int i =1 ; i<=5; i++) {
			CompletableFuture<Void> thenAccept = CompletableFuture.supplyAsync(() -> {
			    try {
			        TimeUnit.SECONDS.sleep(1);
			    } catch (InterruptedException e) {
			        throw new IllegalStateException(e);
			    }
			    return "Inventory task completed...";
			}).thenAccept((a) -> {
				System.out.println("Order task completed...");
			}).thenAccept((a)-> {
				System.out.println("Payment task completed...");
			});
		}
	}
}

class Inventory implements Runnable {

	private String name;

	public Inventory(String name) {
		super();
		this.name = name;
	}

	public void run (){
		System.out.println("Inventory task " + name + " completed...");
	}

}

class Order implements Callable<String> {

	private String name;

	public Order(String name) {
		super();
		this.name = name;
	}

	public String call() throws Exception {
		System.out.println("Order task " + name + " completed...");
		return name;
	}

}

class Payment implements Callable<String> {

	private String name;

	public Payment(String name) {
		super();
		this.name = name;
	}

	public String call() throws Exception {
		System.out.println("Order task " + name + " completed...");
		return name;
	}

}
