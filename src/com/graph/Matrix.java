package com.graph;

public class Matrix {

	public static void main(String[] args) {
		Matrix matrix = new Matrix();
		int[][] one = new int[2][2];
		one[0][0] = 0;
		one[0][1] = 1;
		one[1][0] = 1;
		one[1][1] = 0;
		matrix.print(one);
      
	}

	public void print(int[][] val) {
		for (int i = 0; i < val.length; i++) {
			for (int j = 0; j < val[i].length; j++) {
				System.out.print(val[i][j] + " ");
			}
			System.out.println();
		}
	}
}
