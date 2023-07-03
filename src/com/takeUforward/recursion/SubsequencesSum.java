package com.takeUforward.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsequencesSum {

	public static void main(String[] args) {
		SubsequencesSum subSequence = new SubsequencesSum();
		List<Integer> element = Arrays.asList(1, 2, 1);
		subSequence.printTargetSum(0, element, 0, 2, new ArrayList<>());
	}

	public void printTargetSum(int index, List<Integer> element, int sum, int target, List<Integer> list) {

		if (index == element.size()) {
			if (sum == target) {
				System.out.print(list.toString() + " ");
			}
			return;
		}
		list.add(element.get(index));
		sum += element.get(index);
		printTargetSum(index + 1, element, sum, target, list);
		Integer removeElement = element.get(index);
		list.remove(removeElement);
		sum -= removeElement;
		printTargetSum(index + 1, element, sum, target, list);
	}

}
