package com.aa.testing;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GroupBy {

	public static void main(String[] args) {

		Map<Integer, List<String>> fruits = Stream.of("apple", "banana", "soap", "apple", "banana")
				.collect(Collectors.groupingBy(String::length, Collectors.toList()));

		System.out.println(fruits);
		
//		Map<Integer, List<String>> fruitsList = Stream.of("apple", "banana", "soap", "apple", "banana")
//				.collect(Collectors.groupingBy(String::length, TreeMap::new ,Collectors.toList()));
//
//		System.out.println(fruitsList);

		Map<Integer, Long> collect = Stream.of(4, 2, 6, 2, 1, 9, 6, 7, 9, 4, 1, 6, 1)
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println(collect);

		Map<Integer, Optional<Integer>> collect2 = Stream.of(4, 2, 6, 2, 1, 9, 6, 7, 9, 4, 1, 6, 1)
				.collect(Collectors.groupingBy(Function.identity(), Collectors.maxBy((a1, a2) -> a1.compareTo(a2))));
		System.out.println(collect2);

	}

}
