package com.graph.apnaschool;

public class Edge {
	int src;
	int dest;
	int wt;

	public Edge(int src, int dest, int wt) {
		super();
		this.src = src;
		this.dest = dest;
		this.wt = wt;
	}

	public String toString() {
		return "Edge [src=" + src + ", dest=" + dest + ", wt=" + wt + "]";
	}
}
