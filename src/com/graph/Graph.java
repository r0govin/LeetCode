package com.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {

	public static void main(String[] args) {
		Graph graph = new Graph();
		int[][] edges = { { 0, 1 }, { 1, 2 }, { 2, 0 }, { 2, 3 } };
		Map<Integer, List<Integer>> buildGraph = graph.buildGraph(edges);
		System.out.println(buildGraph);
	}

	public Map<Integer, List<Integer>> buildGraph(int[][] edges) {
		Map<Integer, List<Integer>> graph = new HashMap<>();
		for (int[] edge : edges) {
			int x = edge[0], y = edge[1];
			if (!graph.containsKey(x)) {
				graph.put(x, new ArrayList<>());
			}
			graph.get(x).add(y);

			// if (!graph.containsKey(y)) {
			// graph.put(y, new ArrayList<>());
			// }
			// graph.get(y).add(x);

			// uncomment the above lines if the graph is undirected
		}

		return graph;
	}

}
