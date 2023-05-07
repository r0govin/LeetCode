/*
 * 
    PermutationString 3: Given the head of a linked list and an integer k, return the kthkth node 
    from the end.
    For example, given the linked list that represents 1 -> 2 -> 3 -> 4 -> 5 and k = 2, 
    return the node with value 4, as it is the 2nd node from the end.
    
 * */

package com.linkedlist;

public class ReturnKElement {

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		list.add(7);
		list.add(8);
		list.add(9);
		list.add(10);
		ReturnKElement returnKElement = new ReturnKElement();
		System.out.println(returnKElement.findNode(list.getHead(), 5));
	}

	ListNode findNode(ListNode head, int k) {
		ListNode slow = head;
		ListNode fast = head;
		for (int i = 0; i < k; i++) {
			fast = fast.next;
		}
		while (fast != null) {
			slow = slow.next;
			fast = fast.next;
		}
		return slow;
	}
}
