package com.binarytree.dfs;

import java.util.Stack;

public class MaximumDepthBinarTree {

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
		two.setRight(five);
		five.setRight(six);
		MaximumDepthBinarTree maximum = new MaximumDepthBinarTree();
		System.out.println("Maximum Depth of Binary Tree: "+ maximum.maxDepthIterative(root));
	}

	public int maxDepth(BinaryTree root) {
		if (root == null) {
			return 0;
		}
		int left = maxDepth(root.getLeft());
		int right = maxDepth(root.getRight());
		// Dont forget to add plus one
		return Math.max(left, right)+1;
	}
	
	public int maxDepthIterative(BinaryTree root) {
        if (root == null) {
            return 0;
        }
        
        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(root, 1));
        int ans = 0;
        
        while (!stack.empty()) {
            Pair pair = stack.pop();
            BinaryTree node = pair.node;
            int depth = pair.depth;
            
            ans = Math.max(ans, depth);
            if (node.left != null) {
                stack.push(new Pair(node.left, depth + 1));
            }
            if (node.right != null) {
                stack.push(new Pair(node.right, depth + 1));
            }
        }

        return ans;
    }

}
