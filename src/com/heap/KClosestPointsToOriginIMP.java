package com.heap;

import java.util.PriorityQueue;

public class KClosestPointsToOriginIMP {

	public static void main(String[] args) {
		KClosestPointsToOriginIMP origin = new KClosestPointsToOriginIMP();
		int[][] points = { { 1, 3 }, { -2, 2 } };
		origin.kClosest(points, 1);
	}

	public int[][] kClosest(int[][] points, int k) {
		PriorityQueue<int[]> pq = new PriorityQueue<int[]>(
				(p1, p2) -> p2[0] * p2[0] + p2[1] * p2[1] - p1[0] * p1[0] - p1[1] * p1[1]);
		for (int[] p : points) {
			pq.offer(p);
			if (pq.size() > k) {
				pq.poll();
			}
		}
		int[][] res = new int[k][2];
		while (k > 0) {
			res[--k] = pq.poll();
		}
		return res;

	}
}
