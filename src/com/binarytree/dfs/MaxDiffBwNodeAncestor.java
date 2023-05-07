
/*
	Given the root of a binary tree, find the maximum value v for which there exist 
	different nodes a and b where v = |a.val - b.val| and a is an ancestor of b.

	A node a is an ancestor of b if either: any child of a is equal to b or any child 
	of a is an ancestor of b.
	
	Input: root = [8,3,10,1,6,null,14,null,null,4,7,13]
	Output: 7
	Explanation: We have various ancestor-node differences, some of which are given below:
	|8 - 3| = 5
	|3 - 7| = 4
	|8 - 1| = 7
	|10 - 13| = 3
	Among all possible differences, the maximum value of 7 is obtained by |8 - 1| = 7.
	
	
	
 * */

package com.binarytree.dfs;

public class MaxDiffBwNodeAncestor {

	public int maxAncestorDiff(BinaryTree root) {
		if (root == null) {
			return 0;
		}
		return helper(root, root.val, root.val);
	}

	public int helper(BinaryTree node, int curMax, int curMin) {

		if (node == null) {
			return curMax - curMin;
		}

		curMax = Math.max(curMax, node.val);
		curMin = Math.min(curMin, node.val);
		int left = helper(node.left, curMax, curMin);
		int right = helper(node.right, curMax, curMin);
		return Math.max(left, right);
	}

}
