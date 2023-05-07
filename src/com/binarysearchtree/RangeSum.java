/*
 * 
    PermutationString 1: 938. Range Sum of BST
    Given the root node of a binary search tree and two integers low and high, 
    return the sum of values of all nodes with a value in the inclusive range [low, high].

 * */

package com.binarysearchtree;

import java.util.Stack;

public class RangeSum {

	public static void main(String[] args) {
	}
	
	public int rangeSumBSTIterative(BinarySearchTree root, int low, int high) {
        Stack<BinarySearchTree> stack = new Stack<>();
        stack.push(root);
        int ans = 0;
        
        while (!stack.empty()) {
        	BinarySearchTree node = stack.pop();
            if (low <= node.val && node.val <= high) {
                ans += node.val;
            }
            if (node.left != null && low < node.val) {
                stack.push(node.left);
            }
            if (node.right != null && node.val < high) {
                stack.push(node.right);
            }
        }
        
        return ans;
    }

	public int rangeSumBST(BinarySearchTree root, int low, int high) {
		if (root == null) {
			return 0;
		}

		int ans = 0;
		if (low <= root.val && root.val <= high) {
			ans += root.val;
		}
		if (low < root.val) {
			ans += rangeSumBST(root.left, low, high);
		}
		if (root.val < high) {
			ans += rangeSumBST(root.right, low, high);
		}

		return ans;
	}

}
