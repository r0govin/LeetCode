package com.linkedlist;

public class MiddleNumber {

	public static void main(String[] args) {
		MiddleNumber middleNumber = new MiddleNumber();
		LinkedList list = new LinkedList();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		System.out.println(list.print());
		System.out.println(middleNumber.getMiddleFastSlowPointer(list.getHead()));
	}

	public int getMiddleFastSlowPointer(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		return slow.val;
	}

	public int getMiddle(ListNode head) {
		int middleValue = 0;
		ListNode current = head;
		int length = 0;
		while (current.next != null) {
			length++;
			current = current.next;
		}
		ListNode value = head;
		for (int i = 0; i < length / 2; i++) {
			value = value.next;
		}
		middleValue = value.val;
		return middleValue;
	}

}
