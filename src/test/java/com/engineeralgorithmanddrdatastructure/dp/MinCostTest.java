package com.engineeralgorithmanddrdatastructure.dp;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MinCostTest {
	@Test
	public void testMinCostPath() {
		assertEquals(7, MinCostPath
				.findMinCost(new int[][] { { 1, 1, 1, 1 }, { 2, 2, 2, 1 }, { 1, 1, 1, 1 }, { 3, 3, 3, 1 } }));
		assertEquals(11, MinCostPath
				.findMinCost(new int[][] { { 4, 1, 1, 1 }, { 2, 2, 2, 2 }, { 1, 1, 1, 1 }, { 3, 3, 3, 1 } }));
	}
}
