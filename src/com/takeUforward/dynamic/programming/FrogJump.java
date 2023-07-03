package com.takeUforward.dynamic.programming;

import java.util.Arrays;

public class FrogJump {

	public static void main(String[] args) {
		FrogJump frogJump = new FrogJump();
		int height[] = { 30, 10, 60, 10, 60, 50 };
		int n = height.length;
		int dp[] = new int[n];
		Arrays.fill(dp, -1);
//		System.out.println(frogJump.recurrsion(n - 1, height, dp));
//		System.out.println(frogJump.iterative(n, height, dp));
		System.out.println(frogJump.optimize(n, height));
	}

	public int optimize(int n, int[] height) {
		int prev = 0;
		int prev2 = 0;
		for (int i = 1; i < n; i++) {

			int jumpTwo = Integer.MAX_VALUE;
			int jumpOne = prev + Math.abs(height[i] - height[i - 1]);
			if (i > 1)
				jumpTwo = prev2 + Math.abs(height[i] - height[i - 2]);

			int cur_i = Math.min(jumpOne, jumpTwo);
			prev2 = prev;
			prev = cur_i;

		}
		return prev;
	}

	public int iterative(int n, int[] height, int[] dp) {
		dp[0] = 0;
		for (int ind = 1; ind < n; ind++) {
			int jumpTwo = Integer.MAX_VALUE;
			int jumpOne = dp[ind - 1] + Math.abs(height[ind] - height[ind - 1]);
			if (ind > 1)
				jumpTwo = dp[ind - 2] + Math.abs(height[ind] - height[ind - 2]);

			dp[ind] = Math.min(jumpOne, jumpTwo);
		}
		return dp[n - 1];
	}

	public int recurrsion(int ind, int[] height, int[] dp) {
		if (ind == 0)
			return 0;
		if (dp[ind] != -1)
			return dp[ind];
		int jumpTwo = Integer.MAX_VALUE;
		int jumpOne = recurrsion(ind - 1, height, dp) + Math.abs(height[ind] - height[ind - 1]);
		if (ind > 1)
			jumpTwo = recurrsion(ind - 2, height, dp) + Math.abs(height[ind] - height[ind - 2]);
		return dp[ind] = Math.min(jumpOne, jumpTwo);
	}
}
