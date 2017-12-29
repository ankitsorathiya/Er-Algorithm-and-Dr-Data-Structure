package com.engineeralgorithmanddrdatastructure.ds.heap;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ContiguousSeriesTest {
	@Test
	public void testContiguousSeries() {
		assertTrue(ContiguousSeries.isContigueousSeries(null));
		assertTrue(ContiguousSeries.isContigueousSeries(new int[] { 3 }));
		assertFalse(ContiguousSeries.isContigueousSeries(new int[] { 2, 20 }));
		assertTrue(ContiguousSeries.isContigueousSeries(new int[] { 3, 5, 2, 2, 4, 7, 6 }));
		assertFalse(ContiguousSeries.isContigueousSeries(new int[] { 20, 20, 2, 2, 4, 7, 6 }));
	}

	@Test
	public void testContiguousSeries_efficient() {
		assertTrue(ContiguousSeries.isContigueousSeries_efficient(null));
		assertTrue(ContiguousSeries.isContigueousSeries_efficient(new int[] { 3 }));
		assertFalse(ContiguousSeries.isContigueousSeries_efficient(new int[] { 2, 20 }));
		assertTrue(ContiguousSeries.isContigueousSeries_efficient(new int[] { 3, 5, 2, 2, 4, 7, 6 }));
		assertFalse(ContiguousSeries.isContigueousSeries_efficient(new int[] { 20, 20, 2, 2, 4, 7, 6 }));
	}
}
