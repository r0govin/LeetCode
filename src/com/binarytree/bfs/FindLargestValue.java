package com.binarytree.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindLargestValue {

	public List<Integer> myLargestValues(BinaryTree root) {
		List<Integer> list = new ArrayList<>();
		if (root == null) {
			return list;
		}
		Queue<BinaryTree> queue = new LinkedList<>();
		queue.add(root);

		while (!queue.isEmpty()) {
			int queueLength = queue.size();
			int max = 0;
			for (int i = 0; i < queueLength; i++) {

				BinaryTree node = queue.remove();
				if (queueLength == 1) {
					max = node.val;
				} else {
					max = Math.max(max, node.val);
				}
				System.out.print(node.val + " ");
				if (node.left != null) {
					queue.add(node.left);
				}
				if (node.right != null) {
					queue.add(node.right);
				}
			}
			list.add(max);
		}
		return list;
	}

	public List<Integer> largestValues(BinaryTree root) {
		if (root == null) {
			return new ArrayList<>();
		}

		List<Integer> ans = new ArrayList<>();
		Queue<BinaryTree> queue = new LinkedList<>();
		queue.add(root);

		while (!queue.isEmpty()) {
			int currentLength = queue.size();
			int currMax = Integer.MIN_VALUE;
			for (int i = 0; i < currentLength; i++) {
				BinaryTree node = queue.remove();
				currMax = Math.max(currMax, node.val);
				if (node.left != null) {
					queue.add(node.left);
				}
				if (node.right != null) {
					queue.add(node.right);
				}
			}

			ans.add(currMax);
		}

		return ans;
	}

	public static void main(String[] args) {
		FindLargestValue largestValue = new FindLargestValue();
		BinaryTree binaryTreeRootNode = largestValue.getBinaryTreeRootNode();
		List<Integer> largestValues = largestValue.myLargestValues(binaryTreeRootNode);
		System.out.println("largestValues " + largestValues.toString());
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
