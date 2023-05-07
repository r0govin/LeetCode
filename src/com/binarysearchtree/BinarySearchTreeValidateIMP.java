package com.binarysearchtree;

public class BinarySearchTreeValidateIMP {

	public static void main(String[] args) {
		BinarySearchTree binarySearchTree = new BinarySearchTree();
		BinarySearchTree root = binarySearchTree.getBinaryTreeRootNode();
		BinarySearchTreeValidateIMP binarySearchTreeValidateIMP = new BinarySearchTreeValidateIMP();
		boolean validateBinarySearchTree = binarySearchTreeValidateIMP.validateBinarySearchTree(root);
		System.out.println(validateBinarySearchTree);
	}

	public boolean validate(BinarySearchTree node, long small, long large) {

		if (node == null) {
			return true;
		}

		if (small >= node.val || node.val >= large) {
			return false;
		}

		boolean left = validate(node.left, small, node.val);
		boolean right = validate(node.right, node.val, large);
		return left && right;
	}

	public boolean validateBinarySearchTree(BinarySearchTree root) {
		return this.validate(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
	}

}
