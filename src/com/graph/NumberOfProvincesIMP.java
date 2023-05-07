/*
 * 
	There are n cities. Some of them are connected, while some are not. 
	If city a is connected directly with city b, and city b is connected directly 
	with city c, then city a is connected indirectly with city c.
	
	A province is a group of directly or indirectly connected cities and no 
	other cities outside of the group.
	
	You are given an n x n matrix isConnected where isConnected[i][j] = 1 
	if the ith city and the jth city are directly connected, and isConnected[i][j] = 0 
	otherwise.
	
	Return the total number of provinces.
	
	Input: isConnected = [[1,1,0],[1,1,0],[0,0,1]]
	Output: 2
	
	Input: isConnected = [[1,0,0],[0,1,0],[0,0,1]]
	Output: 3
	
 * */

package com.graph;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfProvincesIMP {

	public static void main(String[] args) {

	}

	public int findCircleNum(int[][] isConnected) {
		int size = isConnected.length;
		int[] visited = new int[size];
		int count = 0;
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 0; i < size; i++) {
			if (visited[i] == 0) {
				queue.add(i);
				while (!queue.isEmpty()) {
					int s = queue.remove();
					visited[s] = 1;
					for (int j = 0; j < size; j++) {
						if (isConnected[s][j] == 1 && visited[j] == 0)
							queue.add(j);
					}
				}
				count++;
			}
		}
		return count;
	}

}
