package com.binarysearchtree;

public class BinarySearchTree {

	int val;
	BinarySearchTree left;
	BinarySearchTree right;

	public BinarySearchTree() {

	}

	public BinarySearchTree(int value) {
		this.val = value;
	}

	public static boolean iterativeSearch(BinarySearchTree root, int item) {
		// Traverse until root reaches to dead end
		while (root != null) {
			// pass right subtree as new tree
			if (item > root.val)
				root = root.right;

			// pass left subtree as new tree
			else if (item < root.val)
				root = root.left;
			else
				return true; // if the key is found return 1
		}
		return false;
	}

	public static void main(String[] args) {
		BinarySearchTree search = new BinarySearchTree();
		BinarySearchTree root = search.getBinaryTreeRootNode();
		print(root);
//		int item = 4;
//		boolean iterativeSearch = search.iterativeSearch(binaryTreeRootNode, item);
//		String result = iterativeSearch ? "Item: " + item + " found " :
//		"Item: " + item + " not found ";
//		System.out.println(result);

	}

	public BinarySearchTree getBinaryTreeRootNode() {
		BinarySearchTree root = null;
		root = insert(root, 50);
		insert(root, 30);
		insert(root, 20);
		insert(root, 40);
		insert(root, 70);
		insert(root, 60);
		insert(root, 80);
		return root;
	}

	public BinarySearchTree insert(BinarySearchTree binarySearchTree, int element) {
		/* If the tree is empty, return a new Node */
		if (binarySearchTree == null)
			return new BinarySearchTree(element);

		/* Otherwise, recur down the tree */
		if (element < binarySearchTree.val)
			binarySearchTree.left = insert(binarySearchTree.left, element);
		else if (element > binarySearchTree.val)
			binarySearchTree.right = insert(binarySearchTree.right, element);

		/* return the (unchanged) Node pointer */
		return binarySearchTree;
	}

	public static void print(BinarySearchTree binarySearchTree) {
		if (binarySearchTree == null)
			return;
		System.out.print(binarySearchTree.val + " ");
		print(binarySearchTree.left);
		print(binarySearchTree.right);
		return;
	}

}
