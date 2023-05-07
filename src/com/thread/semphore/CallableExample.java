package com.thread.semphore;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class CallableExample {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService service = new ThreadPoolExecutor(1, 100, 3000, TimeUnit.SECONDS, new ArrayBlockingQueue<>(5));
		int digit = 5;
		Future<Integer> submit = service.submit(new CallableTask(0));
		try {
			Integer integer = submit.get();
			System.out.println("Factorial of " + digit + ": " + integer);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
			Future<Integer> submit1 = service.submit(new CallableTask(digit));
			Integer integer1 = submit1.get();
			System.out.println("Factorial of " + digit + ": " + integer1);
		}

		service.shutdown();
		service.awaitTermination(1, TimeUnit.MINUTES);
	}
}

class CallableTask implements Callable<Integer> {

	private int factorialNumber;

	public CallableTask(int factorialNumber) {
		super();
		this.factorialNumber = factorialNumber;
	}

	public Integer call() throws Exception {
		if (factorialNumber == 0) {
			throw new Exception("Invalid Input..............");
		}
		int fact = 1;
		for (int i = 1; i <= factorialNumber; i++) {
			fact *= i;
		}
		return fact;
	}

}