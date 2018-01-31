package com.engineeralgorithmanddrdatastructure.graph;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class FloydWarshallsShortestPath {
	public static int[][] findShortestPathBetweenEveryPair(int[][] adjacancy) {
		assertNotNull(adjacancy);
		for (int row = 0; row < adjacancy.length; row++) {
			assertTrue(adjacancy.length == adjacancy[row].length);
		}
		int[][] shortestPath = initializeShortestPath(adjacancy);
		for (int k = 0; k < adjacancy.length; k++) {
			for (int nodeFrom = 0; nodeFrom < adjacancy.length; nodeFrom++) {
				for (int nodeTo = 0; nodeTo < adjacancy.length; nodeTo++) {
					if (nodeFrom == nodeTo) {
						continue;
					}
					int relaxedDistance = shortestPath[nodeFrom][k] + shortestPath[k][nodeTo];
					if (relaxedDistance < shortestPath[nodeFrom][nodeTo]) {
						shortestPath[nodeFrom][nodeTo] = relaxedDistance;
					}
				}
			}
		}

		return shortestPath;
	}

	private static int[][] initializeShortestPath(int[][] adjacancy) {
		int[][] shortestPath = new int[adjacancy.length][adjacancy.length];
		for (int nodeFrom = 0; nodeFrom < adjacancy.length; nodeFrom++) {
			for (int nodeTo = 0; nodeTo < adjacancy.length; nodeTo++) {
				if (nodeFrom == nodeTo) {
					continue;
				}
				if (adjacancy[nodeFrom][nodeTo] == 0) {
					shortestPath[nodeFrom][nodeTo] = Integer.MAX_VALUE;
				} else {
					shortestPath[nodeFrom][nodeTo] = adjacancy[nodeFrom][nodeTo];
				}
			}
		}
		return shortestPath;
	}

}
