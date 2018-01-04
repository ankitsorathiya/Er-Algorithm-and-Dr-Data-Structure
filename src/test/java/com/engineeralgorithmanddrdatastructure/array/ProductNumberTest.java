package com.engineeralgorithmanddrdatastructure.array;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class ProductNumberTest {
	@Test
	public void testProductNumbers() {
		assertArrayEquals(null, ProductNumber.findProduct(null));
		assertArrayEquals(null, ProductNumber.findProduct(new int[] { 0 }));
		assertArrayEquals(new int[] { 1, 0 }, ProductNumber.findProduct(new int[] { 0, 1 }));
		assertArrayEquals(new int[] { 0, 0, 0, 0 }, ProductNumber.findProduct(new int[] { 0, 2, 3, 0 }));
		assertArrayEquals(new int[] { 0, 0, 6 }, ProductNumber.findProduct(new int[] { 2, 3, 0 }));
		assertArrayEquals(new int[] { 18, 12, 6 }, ProductNumber.findProduct(new int[] { 2, 3, 6 }));
	}

	@Test
	public void testProductNumbersGreedy() {
		assertArrayEquals(null, ProductNumber.findProductGreedy(null));
		assertArrayEquals(null, ProductNumber.findProductGreedy(new int[] { 0 }));
		assertArrayEquals(new int[] { 1, 0 }, ProductNumber.findProductGreedy(new int[] { 0, 1 }));
		assertArrayEquals(new int[] { 0, 0, 0, 0 }, ProductNumber.findProductGreedy(new int[] { 0, 2, 3, 0 }));
		assertArrayEquals(new int[] { 0, 0, 6 }, ProductNumber.findProductGreedy(new int[] { 2, 3, 0 }));
		assertArrayEquals(new int[] { 18, 12, 6 }, ProductNumber.findProductGreedy(new int[] { 2, 3, 6 }));
	}
}
