package com.engineeralgorithmanddrdatastructure.mst;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PrimsTest {
	@Test
	public void testPrimsMST() {
		int[][] adjacancey = new int[][] { { 0, 1, 4, 3 }, { 1, 0, 0, 2 }, { 4, 0, 0, 5 }, { 3, 4, 5, 0 } };
		assertEquals(7, Prims.findMSTWithPrims(adjacancey));
	}
}
