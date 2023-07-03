package com.takeUforward.dynamic.programming;

import java.util.Arrays;

public class Fibonacci {
	public static void main(String[] args) {
		Fibonacci fibonacci = new Fibonacci();
		int n = 6;
		int dp[] = new int[n + 1];
		Arrays.fill(dp, -1);
		System.out.println(fibonacci.iterative(n, dp));
	}

	public int iterative(int n, int[] dp) {
		int prev2 = 0;
		int prev1 = 1;

		for (int i = 2; i <= n; i++) {
			int cur_i = prev2 + prev1;
			prev2 = prev1;
			prev1 = cur_i;
		}
		return prev1;
	}

	public int recursion(int n, int[] dp) {
		if (n <= 1)
			return n;

		if (dp[n] == -1)
			return dp[n] = recursion(n - 1, dp) + recursion(n - 2, dp);
		return dp[n];
	}
}
