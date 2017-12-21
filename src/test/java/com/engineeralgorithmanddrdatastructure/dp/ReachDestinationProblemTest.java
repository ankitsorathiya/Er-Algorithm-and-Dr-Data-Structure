package com.engineeralgorithmanddrdatastructure.dp;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ReachDestinationProblemTest {
	@Test
	public void testReachDestionation() {
		assertEquals(0, ReachDestinationProblem.findWaysToReachDestination(1));
		assertEquals(1, ReachDestinationProblem.findWaysToReachDestination(2));
		assertEquals(2, ReachDestinationProblem.findWaysToReachDestination(3));
		assertEquals(4, ReachDestinationProblem.findWaysToReachDestination(4));
		assertEquals(7, ReachDestinationProblem.findWaysToReachDestination(5));
		assertEquals(149, ReachDestinationProblem.findWaysToReachDestination(10));
	}
}
