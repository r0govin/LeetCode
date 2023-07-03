package com.takeUforward.dynamic.programming;

import java.util.Arrays;
import java.util.stream.IntStream;

public class MaximumSumNonAdjacentElements {

	public static void main(String args[]) {
		int arr[] = { 2, 1, 4, 9 };
		int n = arr.length;
		System.out.println(new MaximumSumNonAdjacentElements().solve(n, arr));
	}

	public int solve(int n, int[] arr) {
		int dp[] = new int[n];
		Arrays.fill(dp, -1);
//		return recursion(n - 1, arr, dp);
//		return iterative(n - 1, arr, dp);
		return efficient(n, arr);
	}

	private int recursion(int ind, int[] arr, int[] dp) {
		if (ind < 0)
			return 0;
		if (ind == 0)
			return arr[ind];
		if (dp[ind] != -1)
			return dp[ind];
		int pick = arr[ind] + recursion(ind - 2, arr, dp);
		int nonPick = 0 + recursion(ind - 1, arr, dp);

		return dp[ind] = Math.max(pick, nonPick);
	}

	public int iterative(int ind, int[] arr, int[] dp) {
		dp[0] = arr[0];
		int pick = 0, dontPick = 0;
		for (int i = 1; i < arr.length; i++) {
			pick = arr[i];
			if (i > 1) {
				pick += dp[i - 2];
			}
			dontPick = 0 + dp[i - 1];
			dp[i] = Math.max(pick, dontPick);
		}
		IntStream.of(dp).forEach(a -> System.out.print(a + " "));
		System.out.println();
		return dp[arr.length - 1];
	}

	public int efficient(int n, int[] arr) {

		int prev = arr[0];
		int prev2 = 0;

		for (int i = 1; i < n; i++) {
			int pick = arr[i];
			if (i > 1)
				pick += prev2;
			int nonPick = 0 + prev;

			int cur_i = Math.max(pick, nonPick);
			prev2 = prev;
			prev = cur_i;

		}
		return prev;
	}
}
