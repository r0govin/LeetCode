package com.graph.takeUforward;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.stream.IntStream;

/* https://leetcode.com/problems/course-schedule-ii/description/ */
public class CourseSchedule2 {

	public static void main(String[] args) {
		int numCourses = 4;
		int[][] prerequisites = { { 1, 0 }, { 2, 0 }, { 3, 1 }, { 3, 2 } };
		CourseSchedule2 course = new CourseSchedule2();
		int[] findOrder = course.findOrder(numCourses, prerequisites);
		IntStream.of(findOrder).forEach(a -> System.out.print(a + " "));
	}

	public int[] findOrder(int numCourses, int[][] prerequisites) {

		Map<Integer, List<Integer>> mp = new HashMap<>();
		int[] result = new int[numCourses];
		int[] indegree = new int[numCourses];
		for (int i = 0; i < prerequisites.length; i++) {
			int source = prerequisites[i][1];
			int destination = prerequisites[i][0];
			List<Integer> lst = mp.getOrDefault(source, new ArrayList<Integer>());
			lst.add(destination);
			mp.put(source, lst);
			indegree[destination] += 1;
		}

		Queue<Integer> queue = new LinkedList<>();
		for (int a = 0; a < indegree.length; a++) {
			if (indegree[a] == 0) {
				queue.add(a);
			}
		}
		int i = 0;

		while (!queue.isEmpty()) {
			int node = queue.remove();
			result[i++] = node;

			if (mp.containsKey(node)) {
				for (Integer neighbor : mp.get(node)) {
					indegree[neighbor]--;

					if (indegree[neighbor] == 0) {
						queue.add(neighbor);
					}
				}
			}
		}
		if (i == numCourses) {
			return result;
		}

		return new int[0];
	}
}
