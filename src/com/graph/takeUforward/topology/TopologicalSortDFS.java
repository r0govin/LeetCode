package com.graph.takeUforward.topology;

import java.util.ArrayList;
import java.util.Stack;

public class TopologicalSortDFS {

	private void dfs(int node, int vis[], Stack<Integer> st, ArrayList<ArrayList<Integer>> adj) {
		vis[node] = 1;
		for (int it : adj.get(node)) {
			if (vis[it] == 0)
				dfs(it, vis, st, adj);
		}
		st.push(node);
	}

	// Function to return list containing vertices in Topological order.
	public int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
		int vis[] = new int[V];
		Stack<Integer> st = new Stack<Integer>();
		for (int i = 0; i < V; i++) {
			if (vis[i] == 0) {
				dfs(i, vis, st, adj);
			}
		}

		int ans[] = new int[V];
		int i = 0;
		
		while (!st.isEmpty()) {
			ans[i++] = st.peek();
			st.pop();
		}
		return ans;
	}

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

		TopologicalSortDFS topoSort = new TopologicalSortDFS();
		int[] ans = topoSort.topoSort(V, adj);
		System.out.println();
		for (int node : ans) {
			System.out.print(node + " ");
		}
		System.out.println("");
	}
}
