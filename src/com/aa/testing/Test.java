package com.aa.testing;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Test {

	public static void main(String[] args) throws InterruptedException {

		List<Integer> list = Arrays.asList(4, 2, 5, 7, 1);
		
		System.out.println("List: "+ list);

		/* Limit function example */
		List<Integer> limitList = list.stream().limit(3).collect(Collectors.toUnmodifiableList());
		System.out.println("Limit: "+ limitList);

		/* Skip function example */
		List<Integer> skipList = list.stream().skip(3).collect(Collectors.toUnmodifiableList());
		System.out.println("Skip: "+skipList);

		/* findFirst function example */
		Optional<Integer> findFirst = list.stream().findFirst();
		System.out.println("Find First: "+findFirst.get());

		/* findAny function example */
		Optional<Integer> findAny = list.stream().findAny();
		System.out.println("Find Any: "+findAny.get());
		
		/* anyMatch function example */
		boolean anyMatch = list.stream().anyMatch(a -> a.intValue()>2);
		System.out.println("AnyMatch: "+ anyMatch);
		
		/* allMatch function example */
		boolean allMatch = list.stream().allMatch(a -> a.intValue()>2);
		System.out.println("AllMatch: "+ allMatch);
		
		/* noneMatch function example , no value in the list should satisfy the condition*/
		boolean noneMatch = list.stream().noneMatch(a -> a.intValue()<0);
		System.out.println("NoneMatch: "+ noneMatch);
	}

}
