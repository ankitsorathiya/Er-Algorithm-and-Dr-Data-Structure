package com.engineeralgorithmanddrdatastructure.graph;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

import org.junit.Test;

public class FloydWarshallsShortestPathTest {
	@Test
	public void testFloydWarshallsShortestPath() {
		int[][] shortestPath = FloydWarshallsShortestPath.findShortestPathBetweenEveryPair(
				new int[][] { { 0, 10, 2, 10 }, { 10, 0, 0, 3 }, { 2, 0, 0, 1 }, { 10, 3, 1, 0 } });
		int[][] expectedShortestPath = new int[][] { { 0, 6, 2, 3 }, { 6, 0, 4, 3 }, { 2, 4, 0, 1 }, { 3, 3, 1, 0 } };
		assertArrayEquals(expectedShortestPath, shortestPath);
	}

	@Test(expected = AssertionError.class)
	public void testFloydWarshallsSanity() {
		assertNull(FloydWarshallsShortestPath.findShortestPathBetweenEveryPair(null));
		fail("should throw expception");
	}

	public void testFloydWarshallsBadData() {
		assertNull(FloydWarshallsShortestPath.findShortestPathBetweenEveryPair(new int[][] { { 0 }, { 0, 2, 2, 2 } }));
		fail("should throw expception");
	}
}
