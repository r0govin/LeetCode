
/*
 * 
	Given the root of a binary tree, return the length of the diameter of the tree.
	The diameter of a binary tree is the length of the longest path between any two 
	nodes in a tree. This path may or may not pass through the root.

	The length of a path between two nodes is represented by the number of edges 
	between them.
	
	Input: root = [1,2,3,4,5]
	Output: 3
	Explanation: 3 is the length of the path [4,2,1,3] or [5,2,1,3].
	
	Input: root = [1,2]
	Output: 1
	
	https://www.youtube.com/watch?v=Rezetez59Nk
	
 * */

package com.binarytree.dfs;

public class Diameter {

	int count = 0;

	public int diameterOfBinaryTree(BinaryTree root) {
		getDiameter(root);
		return count;
	}

	public int getDiameter(BinaryTree root) {
		if (root == null) {
			return 0;
		}

		int left = getDiameter(root.left);
		int right = getDiameter(root.right);

		count = Math.max(count, left + right);

		return Math.max(left, right) + 1;
	}
}
