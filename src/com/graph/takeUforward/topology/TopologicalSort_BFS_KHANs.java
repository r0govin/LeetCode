package com.graph.takeUforward.topology;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class TopologicalSort_BFS_KHANs {

	public static void main(String[] args) {
		int V = 6;
		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
		for (int i = 0; i < V; i++) {
			adj.add(new ArrayList<>());
		}
		adj.get(2).add(3);
		adj.get(3).add(1);
		adj.get(4).add(0);
		adj.get(4).add(1);
		adj.get(5).add(0);
		adj.get(5).add(2);

		TopologicalSort_BFS_KHANs topoBfs = new TopologicalSort_BFS_KHANs();
		int[] ans = topoBfs.topoSort(V, adj);
		for (int node : ans) {
			System.out.print(node + " ");
		}
		System.out.println("");
	}

	// Function to return list containing vertices in Topological order.
	public int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
		int indegree[] = new int[V];
		for (int i = 0; i < V; i++) {
			for (int it : adj.get(i)) {
				indegree[it]++;
			}
		}

		Queue<Integer> q = new LinkedList<Integer>();
		for (int i = 0; i < V; i++) {
			if (indegree[i] == 0) {
				q.add(i);
			}
		}

		int topo[] = new int[V];
		int i = 0;
		while (!q.isEmpty()) {
			int node = q.peek();
			q.remove();
			topo[i++] = node;
			// node is in your topo sort
			// so please remove it from the indegree

			for (int it : adj.get(node)) {
				indegree[it]--;
				if (indegree[it] == 0) {
					q.add(it);
				}
			}
		}
		return topo;
	}
}
