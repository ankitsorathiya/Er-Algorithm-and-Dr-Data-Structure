package com.engineeralgorithmanddrdatastructure.search;

public class StockPurchase {
	public static int findMaximumProfit(int[] stockPrices) {
		if (stockPrices == null || stockPrices.length == 0) {
			return 0;
		}
		int profit = 0;
		int minStockPrice = stockPrices[0];
		for (int index = 1; index < stockPrices.length; index++) {
			if (stockPrices[index] > minStockPrice) {
				profit = Math.max(profit, stockPrices[index] - minStockPrice);
			} else {
				minStockPrice = stockPrices[index];
			}
		}
		return profit;
	}
}
