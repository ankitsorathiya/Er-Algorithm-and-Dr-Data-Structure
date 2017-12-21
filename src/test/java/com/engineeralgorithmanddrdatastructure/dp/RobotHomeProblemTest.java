package com.engineeralgorithmanddrdatastructure.dp;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class RobotHomeProblemTest {
	@Test
	public void testRobotHomeReachProblem() {
		assertEquals(2,
				RobotHomeProblem.howManyWaysRobotCanReachHome(new int[][] { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 } }));
		assertEquals(20, RobotHomeProblem.howManyWaysRobotCanReachHome(
				new int[][] { { 1, 1, 1, 1 }, { 1, 1, 1, 1 }, { 1, 1, 1, 1 }, { 1, 1, 1, 1 } }));
	}
}
