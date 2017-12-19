package com.engineeralgorithmanddrdatastructure.dp;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class CoinProblemTest {
	@Test
	public void testCoinChange() {
		List<Integer> denominations = new ArrayList<>();
		denominations.add(1);
		denominations.add(2);
		denominations.add(5);
		denominations.add(10);
		assertEquals(21, CoinProblem.findTotalWaysToGiveChangeOf(15, denominations));
		assertEquals(11, CoinProblem.findTotalWaysToGiveChangeOf(10, denominations));
		assertEquals(8, CoinProblem.findTotalWaysToGiveChangeOf(9, denominations));
		assertEquals(705, CoinProblem.findTotalWaysToGiveChangeOf(90, denominations));
	}
}
