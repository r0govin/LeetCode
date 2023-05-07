package com.thread;

public class DataRace {
	private volatile long x;
	private volatile long y;

	public void increment() {
		x++;
		y++;
	}

	public void print() {
		if (x > y) {
			System.out.println("Data race is occured... ");
		}
	}

	public static void main(String[] args) {
		DataRace dataRace = new DataRace();
		Runnable incrementRunnable = () -> {
			for (int i = 0; i < 100 ; i++) {
				dataRace.increment();
			}
		};
		for (int i =0 ; i <100 ; i++) {
			Thread thread = new Thread(incrementRunnable) ;
			thread.start();
			dataRace.print();
		}
	}

}
