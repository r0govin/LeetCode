package com.backtracking;

public class Demo {
	public static void main(String[] args) {
		int[][] val = { 
				{ 11, 12, 13, 14 }, 
				{ 15, 16, 17, 18 }, 
				{ 19, 20, 21, 22 }, 
				{ 23, 24, 25, 26 } 
				};
		print(val);
		center(val);
	}

	public static void center(int[][] values) {
		int row = 3 - 1, col = 3 - 1;
		System.out.println("values[row-1][col-1]: " + values[row-1][col-1]);
		System.out.println("values[row-1][col]:" + values[row-1][col]);
		System.out.println("values[row-1][col]:" + values[row-1][col+1]);
		System.out.println("values[row][col-1]:" + values[row][col-1]);
		System.out.println("values[row][col+1]:" + values[row][col+1]);
	}

	public static void print(int[][] values) {

		for (int i = 0; i < values.length; i++) {
			for (int j = 0; j < values[i].length; j++) {
				// System.out.print("i: "+ i + " j: "+ j);
				System.out.print(values[i][j] + " ");
			}
			System.out.println();
		}
	}

}
