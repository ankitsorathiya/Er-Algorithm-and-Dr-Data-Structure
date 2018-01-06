package com.engineeralgorithmanddrdatastructure.dp;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class WordProblemTest {
	@Test
	public void testWordCount() {
		assertEquals(0, MagicalStringProblem.countMagicalStringOfLength(0));
		assertEquals(5, MagicalStringProblem.countMagicalStringOfLength(1));
		assertEquals(10, MagicalStringProblem.countMagicalStringOfLength(2));
		assertEquals(19, MagicalStringProblem.countMagicalStringOfLength(3));
		assertEquals(30, MagicalStringProblem.countMagicalStringOfLength(4));
	}
}
