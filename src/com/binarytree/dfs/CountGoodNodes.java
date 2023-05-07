/*
 * 
    PermutationString 3: 1448. Count Good Nodes in Binary Tree

    Given the root of a binary tree, find the number of nodes that are good. A node is good 
    if the path between the root and the node has no nodes with a greater value.

	Again, let's start by thinking about what information we need at each function call 
	(other than the node). At each node, we want to know if the node is good, 
	and to know if the node is good, we need to know the largest value between the 
	root and the node. Let's use an integer maxSoFar to store this.

	Then, we can have a function dfs(node, maxSoFar) that returns the number of good 
	nodes in the subtree rooted at node, where the maximum number seen so far is maxSoFar.

	What is the base case? If we have an empty tree, then the answer is 0 because 
	there are no nodes, so there are no good nodes.

	The total good nodes in a subtree is the number of good nodes in the left 
	subtree + the number of good nodes in the right subtree + 1 if the current
	node is a good node. If node.val >= maxSoFar, that means the current node 
	is a good node. Then we also need to find how many good nodes are in the left 
	and right subtrees, which we can do by making recursive calls while 
	updating maxSoFar.
	
 * */

package com.binarytree.dfs;

public class CountGoodNodes {

	public static void main(String[] args) {

	}

	public int goodNodes(BinaryTree root) {
		return dfs(root, Integer.MIN_VALUE);
	}

	public int dfs(BinaryTree node, int maxSoFar) {
		if (node == null) {
			return 0;
		}

		int left = dfs(node.left, Math.max(maxSoFar, node.val));
		int right = dfs(node.right, Math.max(maxSoFar, node.val));
		int ans = left + right;
		if (node.val >= maxSoFar) {
			ans += 1;
		}

		return ans;
	}

}
