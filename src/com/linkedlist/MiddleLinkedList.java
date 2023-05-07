/*
 * 	
	Given the head of a singly linked list, return the middle node of the linked list.
	If there are two middle nodes, return the second middle node.
	
	Input: head = [1,2,3,4,5]
	Output: [3,4,5]
	Explanation: The middle node of the list is node 3.
	
	Input: head = [1,2,3,4,5,6]
	Output: [4,5,6]
	Explanation: Since the list has two middle nodes with values 3 and 4, 
	we return the second one.
	
 * */

package com.linkedlist;

public class MiddleLinkedList {

	public static void main(String[] args) {
		MiddleLinkedList middleNumber = new MiddleLinkedList();
		LinkedList list = new LinkedList();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		System.out.println(list.print());
		System.out.println(middleNumber.middleNode1(list.getHead()));

	}

	public ListNode middleNode(ListNode head) {
		ListNode slow = head, fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}

	public ListNode middleNode1(ListNode head) {
		ListNode[] A = new ListNode[100];
		int t = 0;
		while (head != null) {
			A[t++] = head;
			head = head.next;
		}
		return A[t / 2];
	}

}
