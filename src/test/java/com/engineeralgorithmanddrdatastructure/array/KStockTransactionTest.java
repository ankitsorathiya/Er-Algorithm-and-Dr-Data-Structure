package com.engineeralgorithmanddrdatastructure.array;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class KStockTransactionTest {
	@Test
	public void testKTransactionProfit() {
		assertEquals(0, KStockTransaction.findMaxProfitWithKStockTransaction(null, 5));
		assertEquals(0, KStockTransaction.findMaxProfitWithKStockTransaction(new int[] {}, 5));
		assertEquals(0, KStockTransaction.findMaxProfitWithKStockTransaction(new int[] { 1, 2 }, 0));
		assertEquals(0, KStockTransaction.findMaxProfitWithKStockTransaction(new int[] { 9, 5, 10, 25, 30 }, 0));
		assertEquals(66, KStockTransaction.findMaxProfitWithKStockTransaction(new int[] { 9, 5, 10, 25, 30 }, 3));
		assertEquals(145, KStockTransaction.findMaxProfitWithKStockTransaction(
				new int[] { 1, 1, 1, 2, 1, 1, 1, 1, 9, 8, 8, 1, 1, 1, 1, 1, 1, 9, 5, 10, 25, 30 }, 5));
		assertEquals(2539,
				KStockTransaction.findMaxProfitWithKStockTransaction(new int[] { 30, 20, 33, 56, 89, 874 }, 3));
		assertEquals(0,
				KStockTransaction.findMaxProfitWithKStockTransaction(new int[] { 89, 20, 5, 4, 3, 2, 1 }, 3));
	}
}
