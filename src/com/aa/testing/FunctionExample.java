package com.aa.testing;

import java.util.function.Function;

public class FunctionExample {
	
	public static void main(String[] args) {
		Function<Integer, Integer> p1 = a -> {
			if (a>10) return a;
			return 0;
		};
		Function<Integer, Integer> p2 = a -> {
			if (a%2==0) return a;
			return 0;
		};
		int[] list = {3,6,7,11,14,15,18};
		int[] result = FunctionExample.result(p1.andThen(p2), list);
		for (int v: result) {
			System.out.print(v+ " ");
		}
		
	}

	public static int[] result(Function<Integer, Integer> p, int[] list) {
		int[] result = new int[list.length];
		int inc = 0;
		for (int lst : list) {
			result[inc] = p.apply(lst);
			inc++;
		}
		return result;
	}
}
