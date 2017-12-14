package com.engineeralgorithmanddrdatastructure.search;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class StockPurchaseTest {
	@Test
	public void testMaximumProfitForStockPurchase() {
		assertEquals(7, StockPurchase.findMaximumProfit(new int[] { 2, 1, 5, 8, 1 }));
		assertEquals(198, StockPurchase.findMaximumProfit(new int[] { 2, 100, 5, 200, 1 }));
		assertEquals(5, StockPurchase.findMaximumProfit(new int[] { 1, 2, 3, 4, 5, 6 }));
		assertEquals(0, StockPurchase.findMaximumProfit(new int[] { 9, 8, 7, 6, 5, 4, 3, 2, 1 }));
	}
}
