package com.linkedlist;

public class LinkedList {

	private ListNode head;
	private int size;

	// LinkedList constructor
	public LinkedList() {
		// this is an empty list, so the reference to the head node
		// is set to a new node with no data
		head = new ListNode(0);
		size = 0;
	}
	
	public void addNode(ListNode node)
	// post: appends the specified element to the end of this list.
	{
		ListNode current = head;
		// starting at the head node, crawl to the end of the list
		while (current.next != null) {
			current = current.next;
		}
		// the last node's "next" reference set to our new node
		current.setNext(node);
		/// head = current;
		size++;// increment the number of elements variable
	}

	public void add(int data)
	// post: appends the specified element to the end of this list.
	{
		ListNode temp = new ListNode(data);
		ListNode current = head;
		// starting at the head node, crawl to the end of the list
		while (current.next != null) {
			current = current.next;
		}
		// the last node's "next" reference set to our new node
		current.setNext(temp);
		/// head = current;
		size++;// increment the number of elements variable
	}

	public void add(int data, int index)
	// post: inserts the specified element at the specified position in this list.
	{
		ListNode temp = new ListNode(data);
		ListNode current = head;
		// crawl to the requested index or the last element in the list,
		// whichever comes first
		for (int i = 1; i < index && current.next != null; i++) {
			current = current.next;
		}
		// set the new node's next-node reference to this node's next-node reference
		temp.setNext(current.next);
		// now set this node's next-node reference to the new node
		current.setNext(temp);
		size++;// increment the number of elements variable
	}

	// Let prevNode be the node at position i - 1
	public void addNode(ListNode prevNode, ListNode nodeToAdd) {
		nodeToAdd.next = prevNode.next;
		prevNode.next = nodeToAdd;
		size++;
	}

	public boolean remove(int index)
	// post: removes the element at the specified position in this list.
	{
		// if the index is out of range, exit
		if (index < 1 || index > size())
			return false;

		ListNode current = head.next;
		for (int i = 1; i < index; i++) {
			if (current.getNext() == null)
				return false;

			current = current.getNext();
		}
		current.setNext(current.getNext().getNext());
		size--; // decrement the number of elements variable
		return true;
	}

	// Let prevNode be the node at position i - 1
	public void deleteNode(ListNode prevNode) {
		prevNode.next = prevNode.next.next;
		size--;
	}

	public String print() {
		ListNode node = this.head.next;
		String output = "";
		while (node != null) {
			output += "[" + node.val + "]";
			node = node.next;
		}
		return output;
	}

	public int getSum(ListNode head) {
		int ans = 0;
		while (head != null) {
			ans += head.val;
			head = head.next;
		}
		return ans;
	}

	public int getSumRecursivve(ListNode head) {
		if (head == null) {
			return 0;
		}
		return head.val + getSumRecursivve(head.next);
	}

	public ListNode getHead() {
		return this.head;
	}

	public int size() {
		return this.size;
	}

}
