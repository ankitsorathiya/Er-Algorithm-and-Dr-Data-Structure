package com.engineeralgorithmanddrdatastructure.array;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TreesAndMokeyTest {
	@Test
	public void testMonkeysDistance() {
		assertEquals(0, TreesAndMokeys.findMonkeysMaxUnitDistanceWithShortestPath(null));
		assertEquals(0, TreesAndMokeys.findMonkeysMaxUnitDistanceWithShortestPath(new int[] {}));
		assertEquals(8, TreesAndMokeys.findMonkeysMaxUnitDistanceWithShortestPath(new int[] { 1, 2, 3, 4 }));
		assertEquals(10, TreesAndMokeys.findMonkeysMaxUnitDistanceWithShortestPath(new int[] { 1, 2, 3, 4, 5 }));
		assertEquals(26, TreesAndMokeys.findMonkeysMaxUnitDistanceWithShortestPath(new int[] { 20, 2, 3, 4, 5 }));
	}
}
