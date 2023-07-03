package com.takeUforward.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsequencesSumAnyOne {
	public static void main(String[] args) {
		SubsequencesSumAnyOne subSequence = new SubsequencesSumAnyOne();
		List<Integer> element = Arrays.asList(1, 2, 1);
		subSequence.printTargetSum(0, element, 0, 2, new ArrayList<>());
	}

	public boolean printTargetSum(int index, List<Integer> element, int sum, int target, List<Integer> list) {

		if (index == element.size()) {
			if (sum == target) {
				System.out.print(list.toString() + " ");
				return true;
			}
			return false;
		}
		list.add(element.get(index));
		sum += element.get(index);
		if (printTargetSum(index + 1, element, sum, target, list)) {
			return true;
		}

		Integer removeElement = element.get(index);
		list.remove(removeElement);
		sum -= removeElement;
		if (printTargetSum(index + 1, element, sum, target, list)) {
			return true;
		}
		return false;
	}

}
