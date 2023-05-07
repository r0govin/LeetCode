
/*
 * 
    PermutationString 4: 236. Lowest Common Ancestor of a Binary Tree

    Given the root of a binary tree and two nodes p and q that are in the tree, 
    return the lowest common ancestor (LCA) of the two nodes. 
    The LCA is the lowest node in the tree that has both p and q as descendants 
    (note: a node is a descendant of itself).

 * */

package com.binarytree.dfs;

public class LowestCommonAncestor {

	public static void main(String[] args) {

	}

	public BinaryTree lowestCommonAncestor(BinaryTree root, BinaryTree p, BinaryTree q) {
		if (root == null) {
			return null;
		}

		// first case
		if (root == p || root == q) {
			return root;
		}

		BinaryTree left = lowestCommonAncestor(root.left, p, q);
		BinaryTree right = lowestCommonAncestor(root.right, p, q);

		// second case
		if (left != null && right != null) {
			return root;
		}

		// third case
		if (left != null) {
			return left;
		}

		return right;
	}

}
