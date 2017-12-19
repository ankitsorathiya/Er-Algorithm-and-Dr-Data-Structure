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
		assertEquals(22, CoinProblem.findTotalWaysToGiveChangeOf_Inefficient(15, denominations));
		assertEquals(11, CoinProblem.findTotalWaysToGiveChangeOf_Inefficient(10, denominations));
		assertEquals(8, CoinProblem.findTotalWaysToGiveChangeOf_Inefficient(9, denominations));
		assertEquals(1615, CoinProblem.findTotalWaysToGiveChangeOf_Inefficient(90, denominations));
	}

	@Test
	public void testCoinChangeFaster() {
		int[] coins = new int[] { 10, 5, 2, 1 };
		assertEquals(22, CoinProblem.findTotalWaysToGiveChangeOf_efficient(15, coins));
		assertEquals(11, CoinProblem.findTotalWaysToGiveChangeOf_efficient(10, coins));
		assertEquals(8, CoinProblem.findTotalWaysToGiveChangeOf_efficient(9, coins));
		assertEquals(1615, CoinProblem.findTotalWaysToGiveChangeOf_efficient(90, coins));
	}
}
