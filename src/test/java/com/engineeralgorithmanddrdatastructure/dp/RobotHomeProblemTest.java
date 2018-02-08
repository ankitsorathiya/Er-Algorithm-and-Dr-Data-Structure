package com.engineeralgorithmanddrdatastructure.dp;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class RobotHomeProblemTest {
	@Test
	public void testRobotHomeReachProblem_homeToInitial() {
		assertEquals(2,
				RobotHomeProblem.howManyWaysRobotCanReachHome_homeToInitial(
						new int[][] { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 } }));
		assertEquals(20, RobotHomeProblem.howManyWaysRobotCanReachHome_homeToInitial(
				new int[][] { { 1, 1, 1, 1 }, { 1, 1, 1, 1 }, { 1, 1, 1, 1 }, { 1, 1, 1, 1 } }));
	}

	@Test
	public void testRobotHomeReachProblem_initialToHome() {
		assertEquals(2, RobotHomeProblem
				.howManyWaysRobotCanReachHome_initialToHome(new int[][] { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 } }));
		assertEquals(20, RobotHomeProblem.howManyWaysRobotCanReachHome_initialToHome(
				new int[][] { { 1, 1, 1, 1 }, { 1, 1, 1, 1 }, { 1, 1, 1, 1 }, { 1, 1, 1, 1 } }));
	}
}
