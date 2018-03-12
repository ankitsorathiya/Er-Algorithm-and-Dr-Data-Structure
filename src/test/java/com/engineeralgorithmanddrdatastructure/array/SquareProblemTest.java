package com.engineeralgorithmanddrdatastructure.array;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class SquareProblemTest {
	@Test
	public void testSquareProblem() {
		Integer[] result = SquareProblem.findSpecialSquare(100);
		assertArrayEquals(result, new Integer[] { 9, 10, 45, 55, 99 });
	}
}
