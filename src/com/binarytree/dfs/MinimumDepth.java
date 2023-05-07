/*
 * 

Given a binary tree, find its minimum depth.
The minimum depth is the number of nodes along the shortest path from the root node 
down to the nearest leaf node.

Note: A leaf is a node with no children.


 * */

package com.binarytree.dfs;

import java.util.LinkedList;

import javax.swing.tree.TreeNode;

public class MinimumDepth {

	public static void main(String[] args) {

	}

	public int minDepthMy(BinaryTree root) {
		if (root == null) {
			return 0;
		}
		if (root.left == null && root.right == null) {
			return 1;
		}

		int left = root.left != null ? minDepthMy(root.left) : Integer.MAX_VALUE;
		int right = root.right != null ? minDepthMy(root.right) : Integer.MAX_VALUE;

		return 1 + Math.min(left, right);
	}
	
	 public int minDepthLeetCode(BinaryTree root) {
		    if (root == null) {
		      return 0;
		    }

		    if ((root.left == null) && (root.right == null)) {
		      return 1;
		    }

		    int min_depth = Integer.MAX_VALUE;
		    if (root.left != null) {
		      min_depth = Math.min(minDepthLeetCode(root.left), min_depth);
		    }
		    if (root.right != null) {
		      min_depth = Math.min(minDepthLeetCode(root.right), min_depth);
		    }

		    return min_depth + 1;
		  }
}
	 
//	 public int minDepth(BinaryTree root) {
//		    LinkedList<Pair<BinaryTree, Integer>> queue = new LinkedList<>();
//		    if (root == null) {
//		      return 0;
//		    }
//		    else {
//		      queue.add(new Pair(root, 1));
//		    }
//
//		    int current_depth = 0;
//		    while (!queue.isEmpty()) {
//		      Pair<TreeNode, Integer> current = queue.poll();
//		      root = current.getKey();
//		      current_depth = current.getValue();
//		      if ((root.left == null) && (root.right == null)) {
//		        break;
//		      }
//		      if (root.left != null) {
//		        queue.add(new Pair(root.left, current_depth + 1));
//		      }
//		      if (root.right != null) {
//		        queue.add(new Pair(root.right, current_depth + 1));
//		      }
//		    }
//		    return current_depth;
//		  }
