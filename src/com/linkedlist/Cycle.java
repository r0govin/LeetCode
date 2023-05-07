
/*
 * 
	PermutationString 2: 141. Linked List Cycle
	Given the head of a linked list, determine if the linked list has a cycle.
	There is a cycle in a linked list if there is some node in the list that can be 
	reached again by continuously following the next pointer.
	
 * */

package com.linkedlist;

import java.util.HashSet;
import java.util.Set;

public class Cycle {

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		list.addNode(list.getHead());	
		Cycle cycle = new Cycle();
		System.out.println(cycle.hasCycle(list.getHead()));	
	}
	public boolean hasCycle(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		while (fast !=null && fast.next !=null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				return true;
			}
		}
		return false;
	}
	
	public boolean detectCycle(ListNode head) {
	    Set<ListNode> seen = new HashSet<>();
	    while (head != null) {
	        if (seen.contains(head)) {
	            return true;
	        }
	        seen.add(head);
	        head = head.next;
	    }
	    return false;
	}
	
}
