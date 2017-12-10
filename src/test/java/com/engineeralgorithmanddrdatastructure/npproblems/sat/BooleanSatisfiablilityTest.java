package com.engineeralgorithmanddrdatastructure.npproblems.sat;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.engineeralgorithmanddrdatastructure.npproblems.sat.BooleanSatisfiability;

public class BooleanSatisfiablilityTest {
	@Test
	public void testBooleanSatisfiablility() {
		assertTrue(BooleanSatisfiability.isBooleanExpressionSatisfiable(new int[][] { { 1, 2, -3 }, { -1, 2, -3 } },
				new boolean[] { false, true, false, false }));
		assertTrue(BooleanSatisfiability.isBooleanExpressionSatisfiable(
				new int[][] { { -1, -2, -3, -4 }, { -1, 2, -3 } }, new boolean[] { false, true, true, false, true }));
		assertFalse(BooleanSatisfiability.isBooleanExpressionSatisfiable(
				new int[][] { { -1, -2, -3, -4 }, { -1, -2, -3 } }, new boolean[] { false, true, true, true, false }));

	}
}
