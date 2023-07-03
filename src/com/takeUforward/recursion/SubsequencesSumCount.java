package com.takeUforward.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsequencesSumCount {
	public static void main(String[] args) {
		SubsequencesSumCount subSequence = new SubsequencesSumCount();
		List<Integer> element = Arrays.asList(1, 2, 1);
		int count = subSequence.count(0, element, 0, 2, new ArrayList<>());
		System.out.println(count);
	}

	public int count(int index, List<Integer> element, int sum, int target, List<Integer> list) {

		if (index == element.size()) {
			if (sum == target) {
				/* System.out.print(list.toString() + " "); */
				return 1;
			}
			return 0;
		}
		list.add(element.get(index));
		sum += element.get(index);
		int l = count(index + 1, element, sum, target, list);

		Integer removeElement = element.get(index);
		list.remove(removeElement);
		sum -= removeElement;
		int r = count(index + 1, element, sum, target, list);
		return l + r;
	}
}
