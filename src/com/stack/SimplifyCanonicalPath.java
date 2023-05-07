package com.stack;

import java.util.Stack;

public class SimplifyCanonicalPath {

	public static void main(String[] args) {
		SimplifyCanonicalPath canonial = new SimplifyCanonicalPath();
		String s1 = "/a/b/c/.././././//d";
		System.out.println(canonial.mySimplifyPath(s1));

	}

	public String simplifyPath(String path) {

		// Initialize a stack
		Stack<String> stack = new Stack<String>();
		String[] components = path.split("/");

		// Split the input string on "/" as the delimiter
		// and process each portion one by one
		for (String directory : components) {

			// A no-op for a "." or an empty string
			if (directory.equals(".") || directory.isEmpty()) {
				continue;
			} else if (directory.equals("..")) {

				// If the current component is a "..", then
				// we pop an entry from the stack if it's non-empty
				if (!stack.isEmpty()) {
					stack.pop();
				}
			} else {

				// Finally, a legitimate directory name, so we add it
				// to our stack
				stack.add(directory);
			}
		}
		System.out.println(stack.toString());
		// Stich together all the directory names together
		StringBuilder result = new StringBuilder();
		for (String dir : stack) {
			result.append("/");
			result.append(dir);
		}

		return result.length() > 0 ? result.toString() : "/";
	}

	public String mySimplifyPath(String path) {
		Stack<String> stack = new Stack<>();
		String[] split = path.split("/");
		for (String comp : split) {
			if (comp.equals(".") || comp.isEmpty()) {
				continue;
			} else {
				if (comp.equals("..") && !comp.isEmpty()) {
					stack.pop();
				} else {
					stack.push(comp);
				}
			}
		}
		StringBuilder result = new StringBuilder();
		for (String str : stack) {
			result.append("/");
			result.append(str);
		}
		return result.length() > 0 ? result.toString().trim() : "/";
	}
}
