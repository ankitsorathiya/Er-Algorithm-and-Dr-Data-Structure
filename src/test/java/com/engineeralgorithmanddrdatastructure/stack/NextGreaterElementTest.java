package com.engineeralgorithmanddrdatastructure.stack;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class NextGreaterElementTest {
	@Test
	public void testNextGreaterElements() {
		assertArrayEquals(new int[] { 2, 3, 4, -1 },
				NextGreaterElement.findNextGreaterElements(new int[] { 1, 2, 3, 4 }));
		assertArrayEquals(new int[] { -1 }, NextGreaterElement.findNextGreaterElements(null));
		assertArrayEquals(new int[] { -1 }, NextGreaterElement.findNextGreaterElements(new int[] { 100 }));
		assertArrayEquals(new int[] { 5, 5, 5, 5, -1, -1 },
				NextGreaterElement.findNextGreaterElements(new int[] { 2, 2, 2, 1, 5, 2 }));
		assertArrayEquals(new int[] { 4, 4, 4, 4, 5, 3, 5, 5, 9, 9, -1 },
				NextGreaterElement.findNextGreaterElements(new int[] { 1, 0, 0, 0, 4, 1, 3, 1, 5, 2, 9 }));
	}

}