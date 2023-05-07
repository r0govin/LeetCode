
/*
 * Given the head of a sorted linked list, delete all duplicates such that each element 
 * appears only once. Return the linked list sorted as well.
 * */

package com.linkedlist;

public class Duplicates {
	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.add(1);
		list.add(1);
		list.add(2);
		list.add(2);
		Duplicates duplicates = new Duplicates();
		System.out.println(list.print());
		ListNode result  = duplicates.deleteDuplicates(list.getHead());
		LinkedList listResult = new LinkedList();
		listResult.addNode(result);
		System.out.println(listResult.print());
	}
	
	public ListNode deleteDuplicates(ListNode head) {
	    ListNode current = head;
	    while (current != null && current.next != null) {
	        if (current.next.val == current.val) {
	            current.next = current.next.next;
	        } else {
	            current = current.next;
	        }
	    }
	    return head;
	}
}
