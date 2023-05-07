/*
 *
 *

    PermutationString 2: 530. Minimum Absolute Difference in BST
    Given the root of a BST, return the minimum absolute difference between the values of 
    any two different nodes in the tree.

 * 
 * */

package com.binarysearchtree;

import java.util.ArrayList;
import java.util.List;

public class MinimumAbsoluteDifference {

	public static void main(String[] args) {

	}

	public int getMinimumDifference(BinarySearchTree root) {
		List<Integer> values = dfs(root);
		int ans = Integer.MAX_VALUE;
		for (int i = 1; i < values.size(); i++) {
			ans = Math.min(ans, values.get(i) - values.get(i - 1));
		}
		return ans;
	}

	public List<Integer> dfs(BinarySearchTree node) {
		if (node == null) {
			return new ArrayList<>();
		}
		List<Integer> left = dfs(node.left);
		List<Integer> right = dfs(node.right);
		left.add(node.val);
		left.addAll(right);
		return left;
	}

}
