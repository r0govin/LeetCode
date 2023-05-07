/*
	Binary Tree Zigzag Level Order Traversal
	Given the root of a binary tree, return the zigzag level order traversal of its nodes' 
	values. (i.e., from left to right, then right to left for the next level and 
	alternate between).
	 
	PermutationString 1:
	Input: root = [3,9,20,null,null,15,7]
	Output: [[3],[20,9],[15,7]]
	
	PermutationString 2:
	Input: root = [1]
	Output: [[1]]
	
	PermutationString 3:
	Input: root = []
	Output: []

 * */

package com.binarytree.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigzagLevelOrderTraversal_IMP {
	
	public List<List<Integer>> zigzagLevelOrder(BinaryTree root) {
	    if (root == null) {
	      return new ArrayList<List<Integer>>();
	    }

	    List<List<Integer>> results = new ArrayList<List<Integer>>();

	    // add the root element with a delimiter to kick off the BFS loop
	    LinkedList<BinaryTree> node_queue = new LinkedList<BinaryTree>();
	    node_queue.addLast(root);
	    node_queue.addLast(null);

	    LinkedList<Integer> level_list = new LinkedList<Integer>();
	    boolean is_order_left = true;

	    while (node_queue.size() > 0) {
	    BinaryTree curr_node = node_queue.pollFirst();
	      if (curr_node != null) {
	        if (is_order_left)
	          level_list.addLast(curr_node.val);
	        else
	          level_list.addFirst(curr_node.val);

	        if (curr_node.left != null)
	          node_queue.addLast(curr_node.left);
	        if (curr_node.right != null)
	          node_queue.addLast(curr_node.right);

	      } else {
	        // we finish the scan of one level
	        results.add(level_list);
	        level_list = new LinkedList<Integer>();
	        // prepare for the next level
	        if (node_queue.size() > 0)
	          node_queue.addLast(null);
	        is_order_left = !is_order_left;
	      }
	    }
	    return results;
	  }

	public List<List<Integer>> myZigzagLevelOrder(BinaryTree root) {
		List<List<Integer>> mainList = new ArrayList<List<Integer>>();
		Queue<BinaryTree> queue = new LinkedList<>();
		queue.add(root);
		boolean flag = true;
		while (!queue.isEmpty()) {
			int queueLength = queue.size();
			List<Integer> list = new ArrayList<>();
			int[] listArray = new int[queue.size()];

			for (int i = 0; i < queueLength; i++) {
				BinaryTree node = queue.remove();
				// System.out.print(node.val + " ");
				if (node.left != null) {
					queue.add(node.getLeft());
				}
				if (node.right != null) {
					queue.add(node.getRight());
				}
				if (flag) {
					list.add(node.getVal());
				} else {
					int a = (queueLength - 1) - i;
					int b = node.getVal();
					listArray[a] = b;
				}
			}
			if (!flag) {
				for (int j = 0; j < listArray.length; j++) {
					list.add(listArray[j]);
				}
			}
			flag = !flag;
			mainList.add(list);
		}
		return mainList;
	}

	public static void main(String[] args) {
		ZigzagLevelOrderTraversal_IMP zigZag = new ZigzagLevelOrderTraversal_IMP();
		BinaryTree root = zigZag.getBinaryTreeRootNode();
		List<List<Integer>> zigzagLevelOrder = zigZag.myZigzagLevelOrder(root);
		System.out.println();
		System.out.println(zigzagLevelOrder);
	}

	public BinaryTree getBinaryTreeRootNode() {
		BinaryTree root = new BinaryTree(0);
		BinaryTree one = new BinaryTree(1);
		BinaryTree two = new BinaryTree(2);
		BinaryTree three = new BinaryTree(3);
		BinaryTree four = new BinaryTree(4);
		BinaryTree five = new BinaryTree(5);
		BinaryTree six = new BinaryTree(6);
		root.setLeft(one);
		root.setRight(two);
		one.setLeft(three);
		one.setRight(four);
		two.setLeft(five);
		two.setRight(six);
		return root;
	}

}
