package com.engineeralgorithmanddrdatastructure.array;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MaxChocolateProblemTest {
	@Test
	public void findMaxChocolateForEachStudents() {
		assertEquals(0, MaxChocolateProblem.findMaxChocolateForEachStudents(null, 3));
		assertEquals(0, MaxChocolateProblem.findMaxChocolateForEachStudents(new int[] {}, 3));
		assertEquals(0, MaxChocolateProblem.findMaxChocolateForEachStudents(new int[] { 5 }, 3));
		assertEquals(1, MaxChocolateProblem.findMaxChocolateForEachStudents(new int[] { 3 }, 3));
		assertEquals(6, MaxChocolateProblem.findMaxChocolateForEachStudents(new int[] { 2, 7, 6, 1, 4, 5 }, 3));
	}

	@Test
	public void findMaxChocolateForEachStudents_efficient() {
		assertEquals(0, MaxChocolateProblem.findMaxChocolateForEachStudents_efficient(null, 3));
		assertEquals(0, MaxChocolateProblem.findMaxChocolateForEachStudents_efficient(new int[] {}, 3));
		assertEquals(0, MaxChocolateProblem.findMaxChocolateForEachStudents_efficient(new int[] { 5 }, 3));
		assertEquals(1, MaxChocolateProblem.findMaxChocolateForEachStudents_efficient(new int[] { 3 }, 3));
		assertEquals(6,
				MaxChocolateProblem.findMaxChocolateForEachStudents_efficient(new int[] { 2, 7, 6, 1, 4, 5 }, 3));
	}
}
