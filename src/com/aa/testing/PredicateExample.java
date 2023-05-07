package com.aa.testing;

import java.util.function.Predicate;

public class PredicateExample {

	public static void main(String[] args) {
		Predicate<Integer> p1 = a -> a>10;
		Predicate<Integer> p2 = a -> a%2==0;
		int[] list = {3,6,7,11,14,15,18};
		boolean[] result = PredicateExample.result(p1.and(p2), list);
		for (boolean v: result) {
			System.out.print(v+ " ");
		}
		
	}
	public static boolean [] result(Predicate<Integer> p , int[] list) {
		boolean[] result = new boolean[list.length];
		int inc =0;
		for (int lst: list) {
			result[inc] = p.test(lst);
			inc++;
		}
		return result;
	}

}
