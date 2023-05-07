package com.graph.apnaschool;

import java.util.ArrayList;
import java.util.List;

public class Graph {
	List<Edge>[] graphs;

	public Graph() {
		graphs = new ArrayList[4];
	}

	public List<Edge>[] create(List<Edge>[] graphs) {
		int size = graphs.length;
		for (int i = 0; i < size; i++) {
			graphs[i] = new ArrayList<>();
		}
		graphs[0].add(new Edge(0, 2, 2));

		graphs[1].add(new Edge(1, 2, 10));
		graphs[1].add(new Edge(1, 3, 0));

		graphs[2].add(new Edge(2, 0, 2));
		graphs[2].add(new Edge(2, 1, 10));
		graphs[2].add(new Edge(2, 3, -1));

		graphs[3].add(new Edge(3, 1, 0));
		graphs[3].add(new Edge(3, 2, -1));

		return graphs;

	}

	public static void main(String[] args) {
		Graph graphs = new Graph();
		List<Edge>[] create = graphs.create(graphs.graphs);
		for (List<Edge> list : create) {
			for (Edge e : list) {
				System.out.print("{" + "src " + e.src + ", dest " + e.dest +", wt "+ e.wt+ "}" + " ");
			}
			System.out.println();
		}

	}
}
