
/*
 * 	Given a directed acyclic graph (DAG) of n nodes labeled from 0 to n - 1, 
 * 	find all possible paths from node 0 to node n - 1 and return them in any order.
	The graph is given as follows: graph[i] is a list of all nodes you can visit 
	from node i (i.e., there is a directed edge from node i to node graph[i][j]).
	
	Input: graph = [[1,2],[3],[3],[]]
	Output: [[0,1,3],[0,2,3]]
	Explanation: There are two paths: 0 -> 1 -> 3 and 0 -> 2 -> 3.
	
	https://www.youtube.com/watch?v=9qWMS8GLvdI 

 * */
package com.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AllPathSrcToTargetIMP {

	private int target;
	private int[][] graph;
	private List<List<Integer>> results;

	public static void main(String[] args) {
		AllPathSrcToTargetIMP allPathSrcToTargetIMP = new AllPathSrcToTargetIMP();
		int[][] graph = { { 1, 2 }, { 3 }, { 3 }, {} };
		List<List<Integer>> allPathsSourceTarget = allPathSrcToTargetIMP.allPathsSourceTarget(graph);
		System.out.println(allPathsSourceTarget);
	}

	protected void backtrack(int currNode, LinkedList<Integer> path) {
		if (currNode == this.target) {
			// Note: one should make a deep copy of the path
			this.results.add(new ArrayList<Integer>(path));
			return;
		}
		// explore the neighbor nodes one after another.
		for (int nextNode : this.graph[currNode]) {
			// mark the choice, before backtracking.
			path.addLast(nextNode);
			this.backtrack(nextNode, path);
			// remove the previous choice, to try the next choice
			path.removeLast();
		}
	}

	public List<List<Integer>> allPathsSourceTarget(int[][] graph) {

		this.target = graph.length - 1;
		this.graph = graph;
 		this.results = new ArrayList<List<Integer>>();
		// adopt the LinkedList for fast access to the tail element.
		LinkedList<Integer> path = new LinkedList<Integer>();
		path.addLast(0);
		// kick of the backtracking, starting from the source (node 0)
		this.backtrack(0, path);
		return this.results;
	}

}

class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
      int n = graph.length;
      int currNode = 0;
      int target = n-1;
      List<List<Integer>> result = new ArrayList<>();
      LinkedList<Integer> temp = new LinkedList<>();
      temp.addLast(0);
      dfc(graph,currNode,target,result,temp);
      return result;
      
    }
    public void dfc(int[][] graph, int currNode, int target, List<List<Integer>> result,  
                    LinkedList<Integer> temp) {
     
        if (currNode == target) {
            List<Integer> list = new ArrayList<>(temp);
            result.add(list);
            return ;
        }
        
        for (int nextNode: graph[currNode]) {
            temp.addLast(nextNode);
            dfc(graph,nextNode,target,result,temp);
            temp.removeLast();
        }
       
    }
}
