package com.engineeralgorithmanddrdatastructure.array;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

public class DiagonalNumbersTest {
	@Test
	public void testDiagonalNumbers() {
		assertEquals(Arrays.asList(1), DiagonalNumbers.getNumbersInDiagonalOrders(new int[][] { { 1 } }));
		assertEquals(Arrays.asList(1, 2, 3, 4),
				DiagonalNumbers.getNumbersInDiagonalOrders(new int[][] { { 1, 2 }, { 3, 4 } }));
		assertEquals(Arrays.asList(1, 2, 4, 7, 5, 3, 6, 8, 9),
				DiagonalNumbers.getNumbersInDiagonalOrders(new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } }));
		assertEquals(Arrays.asList(1, 2, 5, 9, 6, 3, 4, 7, 10, 13, 14, 11, 8, 12, 15, 16),
				DiagonalNumbers.getNumbersInDiagonalOrders(
						new int[][] { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } }));
	}
}
