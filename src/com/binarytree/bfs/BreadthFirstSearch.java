package com.binarytree.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch {

	public void printAllNodes(BinaryTree root) {
		Queue<BinaryTree> queue = new LinkedList<>();
		queue.add(root);

		while (!queue.isEmpty()) {
			int nodesInCurrentLevel = queue.size();
			// do some logic here for the current level

			for (int i = 0; i < nodesInCurrentLevel; i++) {
				BinaryTree node = queue.remove();

				// do some logic here on the current node
				System.out.print(node.val + " ");

				// put the next level onto the queue
				if (node.left != null) {
					queue.add(node.left);
				}
				if (node.right != null) {
					queue.add(node.right);
				}
			}
		}
	}

	public static void main(String[] args) {
		BreadthFirstSearch breadthFirstSearch = new BreadthFirstSearch();
		BinaryTree root = breadthFirstSearch.getBinaryTreeRootNode();
		breadthFirstSearch.printAllNodes(root);

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
