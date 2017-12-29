package com.engineeralgorithmanddrdatastructure.ds.heap;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ContiguousSeriesTest {
	@Test
	public void testContiguousSeries() {
		assertTrue(ContiguousSeries.isContigueousSerise(null));
		assertTrue(ContiguousSeries.isContigueousSerise(new int[] { 3 }));
		assertFalse(ContiguousSeries.isContigueousSerise(new int[] { 2, 20 }));
		assertTrue(ContiguousSeries.isContigueousSerise(new int[] { 3, 5, 2, 2, 4, 7, 6 }));
		assertFalse(ContiguousSeries.isContigueousSerise(new int[] { 20, 20, 2, 2, 4, 7, 6 }));
	}
}
