/*
 * Given the root of a binary tree and an integer targetSum, return true if there 
 * is a path from the root to a leaf such that the sum of the nodes on the path 
 * is equal to targetSum, and return false otherwise.
 * */

package com.binarytree.dfs;

import java.util.Stack;

public class PathSum {

	int target;

	public static void main(String[] args) {
		BinaryTree root = new BinaryTree(5);

		BinaryTree four = new BinaryTree(4);
		BinaryTree eleven = new BinaryTree(11);
		BinaryTree seven = new BinaryTree(7);
		BinaryTree two = new BinaryTree(2);
		root.setLeft(four);
		four.setLeft(eleven);
		eleven.setLeft(seven);
		eleven.setRight(two);

		BinaryTree eight = new BinaryTree(8);
		BinaryTree thirteen = new BinaryTree(13);
		BinaryTree four2 = new BinaryTree(4);
		BinaryTree one = new BinaryTree(1);
		root.setRight(eight);
		eight.setLeft(thirteen);
		eight.setRight(four2);
		four2.setRight(one);

		PathSum pathSum = new PathSum();
		boolean hasPathSum = pathSum.hasPathSum(root, 22);
		System.out.println();
		System.out.println(hasPathSum);
	}

	public boolean hasPathSum(BinaryTree root, int targetSum) {
		target = targetSum;
		return dfs(root, 0);
	}

	public boolean dfs(BinaryTree node, int curr) {
		if (node == null) {
			return false;
		}

		if (node.left == null && node.right == null) {
			return (curr + node.val) == target;
		}
		System.out.print(node.val + " ");
		curr += node.val;
		boolean left = dfs(node.left, curr);
		boolean right = dfs(node.right, curr);
		return left || right;
	}

	public boolean hasPathSumIterative(BinaryTree root, int targetSum) {
		if (root == null) {
			return false;
		}

		Stack<Pair> stack = new Stack<>();
		stack.push(new Pair(root, 0));

		while (!stack.empty()) {
			Pair pair = stack.pop();
			BinaryTree node = pair.node;
			int curr = pair.depth;

			if (node.left == null && node.right == null) {
				if ((curr + node.val) == targetSum) {
					return true;
				}
			}

			curr += node.val;
			if (node.left != null) {
				stack.push(new Pair(node.left, curr));
			}
			if (node.right != null) {
				stack.push(new Pair(node.right, curr));
			}
		}

		return false;
	}

}
