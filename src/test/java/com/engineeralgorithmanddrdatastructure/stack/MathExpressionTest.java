package com.engineeralgorithmanddrdatastructure.stack;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MathExpressionTest {
	@Test
	public void testMathExpression() {
		assertEquals(23.5d, MathExpression.solveExpression("2*3+5/6*3+15"), 0d);
	}
}