package com.queue.monotonic;

import java.util.Stack;

public class Test {
	Stack<Integer> stack;
	
	public Test() {
		stack = new Stack<>();
		stack.push(1);
		stack.push(3);
		stack.push(5);
		stack.push(6);
		stack.push(8);
	}

	public static void main(String[] args) {

		Test test = new Test();
		System.out.println(test.stack);
		test.addToStack(4);
		System.out.println(test.stack);
		test.addToStack(1);
		System.out.println(test.stack);
		
	}

	public Stack<Integer> addToStack(Integer val) {
		Stack<Integer> s = this.stack;
		while (s.size() > 0 && s.peek() >= val) {
			s.pop();
		}
		s.push(val);
		return s;
	}
}
