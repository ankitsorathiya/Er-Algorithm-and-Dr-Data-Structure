package com.engineeralgorithmanddrdatastructure.anagram;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class AnagramProblemTest {
	@Test
	public void testNeighbourAnagrams() {
		String[] words = new String[] { "cat", "dog", "tac", "god", "act" };
		String[] expected = new String[] { "cat", "tac", "act", "dog", "god" };
		assertArrayEquals(expected, AnagramProblem.neighbourAnagrams(words));
	}
}
