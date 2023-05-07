package com.binarytree.dfs;

public class DepthFirstSearch {

	public void preorderDfs(BinaryTree node) {
		if (node == null) {
			return;
		}
		System.out.print(node.getVal() + " ");
		preorderDfs(node.left);
		preorderDfs(node.right);
	}

	public void inorderDfs(BinaryTree node) {
		if (node == null) {
			return;
		}
		inorderDfs(node.left);
		System.out.print(node.getVal() + " ");
		inorderDfs(node.right);
	}

	public void postorderDfs(BinaryTree node) {
		if (node == null) {
			return;
		}
		postorderDfs(node.left);
		postorderDfs(node.right);
		System.out.print(node.getVal() + " ");
	}

	public static void main(String[] args) {
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

		DepthFirstSearch d = new DepthFirstSearch();
		System.out.println("Pre-Order Traverse");
		d.preorderDfs(root);
		System.out.println();
		System.out.println("In-Order Traverse");
		d.inorderDfs(root);
		System.out.println();
		System.out.println("Post-Order Traverse");
		d.postorderDfs(root);
	}
}
