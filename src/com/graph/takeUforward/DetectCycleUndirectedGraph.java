package com.graph.takeUforward;

//DetectCycleUndirectedGraph
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class DetectCycleUndirectedGraph {

	public boolean detectCycle(ArrayList<ArrayList<Integer>> adj, int s, boolean visited[]) {
		Queue<Integer> nodes = new LinkedList<>();
		// Queue<Integer> sources = new LinkedList<>();
		nodes.add(s);
		// sources.add(-1);
		while (!nodes.isEmpty()) {
			int node = nodes.poll();
			// int source = sources.poll();
			/* below is the condition important for cyclic are there or not
			 * it make a note of all visited node at level wise*/
			if (visited[node])
				return true;
			visited[node] = true;
			for (int child : adj.get(node)) {
				if (visited[child])
					continue;
				nodes.offer(child);
				// sources.offer(node);
			}
		}
		return false;
	}

	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
		for (int i = 0; i < 4; i++) {
			adj.add(new ArrayList<>());
		}
		adj.get(0).add(1);
		adj.get(1).add(0);
		adj.get(0).add(2);
		adj.get(2).add(0);
		adj.get(2).add(3);
		adj.get(3).add(2);
//		adj.get(3).add(1);
//		adj.get(1).add(3);

		DetectCycleUndirectedGraph detect = new DetectCycleUndirectedGraph();
		boolean detectCycle = detect.detectCycle(adj, 0, new boolean[4]);
		if (detectCycle)
			System.out.println("1");
		else
			System.out.println("0");
	}
}
