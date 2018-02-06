package com.engineeralgorithmanddrdatastructure.graph;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TopologicalSorting {
	public static List<Integer> sortTopologicallyWithDFS(boolean[][] directedAdjacancy) {
		validateInput(directedAdjacancy);
		LinkedList<Integer> topological = new LinkedList<>();
		boolean[] seen = new boolean[directedAdjacancy.length];
		for (int currentNode = 0; currentNode < directedAdjacancy.length; currentNode++) {
			sortTopologicallyWithDFS(directedAdjacancy, topological, seen, currentNode);
		}
		return topological;
	}

	private static void sortTopologicallyWithDFS(boolean[][] directedAdjacancy, LinkedList<Integer> topological,
			boolean[] seen, int currentNode) {
		if (seen[currentNode]) {
			return;
		}
		seen[currentNode] = true;
		for (int neighbour = 0; neighbour < directedAdjacancy[currentNode].length; neighbour++) {
			sortTopologicallyWithDFS(directedAdjacancy, topological, seen, neighbour);
		}
		topological.addFirst(currentNode);
	}

	public static List<Integer> sortTopologicallyWithBFS(boolean[][] directedAdjacancy) {
		validateInput(directedAdjacancy);
		List<Integer> topological = new ArrayList<>();
		int[] indegree = findInDegree(directedAdjacancy);
		boolean[] seen = new boolean[directedAdjacancy.length];
		Queue<Integer> queue = fillQueueWithZeroInDegree(indegree, seen);
		while (!queue.isEmpty()) {
			int currentNode = queue.poll();
			topological.add(currentNode);
			for (int nodeTo = 0; nodeTo < directedAdjacancy.length; nodeTo++) {
				if (directedAdjacancy[currentNode][nodeTo] && !seen[nodeTo]) {
					indegree[nodeTo]--;
					if (indegree[nodeTo] == 0) {
						seen[nodeTo] = true;
						queue.add(nodeTo);
					}
				}
			}
		}
		return topological;
	}

	private static void validateInput(boolean[][] directedAdjacancy) {
		assertNotNull(directedAdjacancy);
		for (int row = 0; row < directedAdjacancy.length; row++) {
			assertTrue(directedAdjacancy.length == directedAdjacancy[row].length);
		}
	}

	private static Queue<Integer> fillQueueWithZeroInDegree(int[] indegree, boolean[] seen) {
		Queue<Integer> queue = new LinkedList<>();
		for (int node = 0; node < indegree.length; node++) {
			if (indegree[node] == 0) {
				queue.add(node);
				seen[node] = true;
			}
		}
		return queue;
	}

	private static int[] findInDegree(boolean[][] directedAdjacancy) {
		int[] indegree = new int[directedAdjacancy.length];
		for (int nodeFrom = 0; nodeFrom < directedAdjacancy.length; nodeFrom++) {
			for (int nodeTo = 0; nodeTo < directedAdjacancy.length; nodeTo++) {
				if (nodeFrom != nodeTo && directedAdjacancy[nodeFrom][nodeTo]) {
					indegree[nodeTo]++;
				}
			}
		}
		return indegree;
	}
}
