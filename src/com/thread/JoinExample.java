package com.thread;

import java.util.Arrays;
import java.util.List;

public class JoinExample {
	public static void main(String[] args) throws InterruptedException {
		List<Integer> addList = Arrays.asList(2, 2, 2, 2, 2);
		List<Integer> multiplicationList = Arrays.asList(3, 3, 3);
		Operations operations = new Operations();
		Thread multiplyThread = new Thread(new MultiplicationTask(operations, multiplicationList));
		Thread additionThread = new Thread(new AddTask(operations, addList));
		multiplyThread.start();
		additionThread.start();
		multiplyThread.join();
		additionThread.join();
		int addResult = operations.getAddResult();
		System.out.println("Add Result: "+ addResult);
		System.out.println("Mulitplication Result: "+ operations.getMultiplicationResult());
	}
}

class MultiplicationTask implements Runnable {

	private Operations operations;
	private List<Integer> list;

	public MultiplicationTask(Operations _operations, List<Integer> _list) {
		this.operations = _operations;
		this.list = _list;
	}

	public void run() {
		operations.multiplication(list);
	}
}

class AddTask implements Runnable {

	private Operations operations;
	private List<Integer> list;

	public AddTask(Operations _operations, List<Integer> _list) {
		this.operations = _operations;
		this.list = _list;
	}

	public void run() {
		operations.addition(list);
	}
}

class Operations {

	private volatile int addResult;
	private volatile int multiplicationResult;

	public synchronized int addition(List<Integer> val) {
		val.stream().forEach(a -> {
			addResult += a;
		});
		return addResult;
	}

	public synchronized int multiplication(List<Integer> val) {
		multiplicationResult = 1;
		val.stream().forEach(a -> {
			multiplicationResult *= a;

		});
		return multiplicationResult;
	}

	public int getAddResult() {
		return addResult;
	}
	
	public int getMultiplicationResult() {
		return multiplicationResult;
	}

}
