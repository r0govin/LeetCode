/*
 * 
    PermutationString 1: 199. Binary Tree Right Side View

    Given the root of a binary tree, imagine yourself standing on the right side of it. 
    Return the values of the nodes you can see ordered from top to bottom.

 * */

package com.binarytree.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightSideView {

	public List<Integer> rightSideView(BinaryTree root) {
		if (root == null) {
			return new ArrayList<>();
		}

		List<Integer> ans = new ArrayList<>();
		List<Integer> leftView = new ArrayList<>();
		List<Integer> rightView = new ArrayList<>();
		Queue<BinaryTree> queue = new LinkedList<>();
		queue.add(root);
		
		while (!queue.isEmpty()) {
			int currentLength = queue.size();
			int prev = 0;
			 
			for (int i = 0; i < currentLength; i++) {
				BinaryTree node = queue.remove();
				if (i ==0) {
					leftView.add(node.val);
				}
				if (i ==currentLength-1) {
					rightView.add(node.val);
				}
				prev = node.val;
				if (node.left != null) {
					queue.add(node.left);
				}
				if (node.right != null) {
					queue.add(node.right);
				}
			}

			ans.add(prev);
		}
        System.out.println("Left View: "+ leftView);
        System.out.println("Right View: "+ rightView);
		return ans;
	}

	public static void main(String[] args) {
		RightSideView rightSideView = new RightSideView();
		BinaryTree root = rightSideView.getBinaryTreeRootNode();
		BreadthFirstSearch search = new BreadthFirstSearch();
		search.printAllNodes(root);
		System.out.println();
		System.out.println(rightSideView.rightSideView(root));
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
