/*
 * 
	Deepest Leaves Sum
	Given the root of a binary tree, return the sum of values of its deepest leaves.

 * */

package com.binarytree.bfs;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class DeepestLeavesSumImp {

	public int myDeepestLeavesSum(BinaryTree root) {
		Queue<BinaryTree> queue = new LinkedList<>();
		queue.add(root);
		int sum =0;
		while (!queue.isEmpty()) {
			int queueLength = queue.size();
			sum =0;
			for (int i = 0; i < queueLength; i++) {
				BinaryTree node = queue.remove();
				//System.out.print(node.val + " ");
				if (node.left != null) {
					queue.add(node.getLeft());
				}
				if (node.right != null) {
					queue.add(node.getRight());
				}
				sum +=node.val;
			}
			
		}
		return sum;
	}
	
	public int deepestLeavesSum(BinaryTree root) {
	    ArrayDeque<BinaryTree>  nextLevel = new ArrayDeque(),
	                          currLevel = new ArrayDeque();
	    nextLevel.offer(root);

	    while (!nextLevel.isEmpty()) {
	      // prepare for the next level
	      currLevel = nextLevel.clone();
	      nextLevel.clear();

	      for (BinaryTree node: currLevel) {
	        // add child nodes of the current level
	        // in the queue for the next level
	        if (node.left != null) {
	          nextLevel.offer(node.left);
	        }
	        if (node.right != null) {
	          nextLevel.offer(node.right);
	        }
	      }
	    }
	    int deepestSum = 0;
	    for (BinaryTree node: currLevel) {
	      deepestSum += node.val;
	    }
	    return deepestSum;
	  }

	public static void main(String[] args) {
		DeepestLeavesSumImp deepLeaveSum = new DeepestLeavesSumImp();
		BinaryTree binaryTreeRootNode = deepLeaveSum.getBinaryTreeRootNode();
		int deepestLeavesSum = deepLeaveSum.myDeepestLeavesSum(binaryTreeRootNode);
		System.out.println();
		System.out.println("Sum: " +deepestLeavesSum);
	}

	public BinaryTree getBinaryTreeRootNode() {

		BinaryTree one = new BinaryTree(1);
		BinaryTree two = new BinaryTree(2);
		BinaryTree three = new BinaryTree(3);
		BinaryTree four = new BinaryTree(4);
		BinaryTree five = new BinaryTree(5);
		BinaryTree six = new BinaryTree(6);
		BinaryTree seven = new BinaryTree(7);
		BinaryTree eight = new BinaryTree(8);

		one.setLeft(two);
		one.setRight(three);
		two.setLeft(four);
		two.setRight(five);
		four.setLeft(seven);

		three.setRight(six);
		six.setRight(eight);

		return one;
	}
}
