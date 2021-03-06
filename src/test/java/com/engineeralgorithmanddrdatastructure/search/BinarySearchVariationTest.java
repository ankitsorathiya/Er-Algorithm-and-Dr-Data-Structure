package com.engineeralgorithmanddrdatastructure.search;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;

public class BinarySearchVariationTest {
	private BinarySearchVariation binarySearchVariation;

	@Before
	public void initialize() {
		this.binarySearchVariation = new BinarySearchVariation();
	}

	@Test
	public void testValidSearch() {
		assertEquals(0, binarySearchVariation.findIndexOfGivenNumber(new int[] { 1 }, 1));
		assertEquals(0, binarySearchVariation.findIndexOfGivenNumber(new int[] { 1, 2 }, 1));
		assertEquals(1, binarySearchVariation.findIndexOfGivenNumber(new int[] { 1, 2 }, 2));
		assertEquals(6, binarySearchVariation.findIndexOfGivenNumber(new int[] { 1, 2, 3, 4, 5, 8, 10, 9, 11 }, 10));
		assertEquals(-1, binarySearchVariation.findIndexOfGivenNumber(new int[] { 1, 2, 3, 4, 5, 8, 10, 9, 11 }, 15));
		assertEquals(1, binarySearchVariation.findIndexOfGivenNumber(new int[] { 1, 5, 2, 8, 3 }, 5));
		assertEquals(4, binarySearchVariation.findIndexOfGivenNumber(new int[] { 1, 5, 2, 8, 3 }, 3));
		assertEquals(1, binarySearchVariation.findIndexOfGivenNumber(new int[] { 1, 9, 10, 8, 25 }, 9));

	}

	@Test
	public void testInvalidSearch() {
		assertFalse(0 == binarySearchVariation.findIndexOfGivenNumber(new int[] { 1, 2 }, 2));
		assertFalse(1 == binarySearchVariation.findIndexOfGivenNumber(new int[] { 1, 2 }, -1));
		assertFalse(4 == binarySearchVariation.findIndexOfGivenNumber(new int[] { 1, 2, 3, 4, 5, 8, 10, 9, 11 }, -1));
		assertFalse(8 == binarySearchVariation.findIndexOfGivenNumber(new int[] { 1, 2, 3, 4, 5, 8, 10, 9, 11 }, 45));
		assertFalse(0 == binarySearchVariation.findIndexOfGivenNumber(new int[] { 1, 5, 2, 8, 3 }, 90));
		assertFalse(3 == binarySearchVariation.findIndexOfGivenNumber(new int[] { 1, 5, 2, 8, 3 }, 24));
		assertFalse(0 == binarySearchVariation.findIndexOfGivenNumber(new int[] { 1, 9, 10, 8, 25 }, 89));
	}
}
