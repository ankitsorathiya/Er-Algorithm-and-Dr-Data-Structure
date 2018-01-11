package com.engineeralgorithmanddrdatastructure.array;

import java.util.PriorityQueue;

public class KStockTransaction {
	public static int findMaxProfitWithKStockTransaction(int[] stockPrices, int k) {
		int maxProfit = 0;
		if (k <= 0 || stockPrices == null || stockPrices.length == 0 || stockPrices.length <= k) {
			return maxProfit;
		}
		PriorityQueue<Integer> maxProfitHeap = new PriorityQueue<>();
		for (int buyStockIndex = 0; buyStockIndex < stockPrices.length - 1; buyStockIndex++) {
			int currentMaxProfit = 0;
			for (int sellStockIndex = buyStockIndex + 1; sellStockIndex < stockPrices.length; sellStockIndex++) {
				int profit = stockPrices[sellStockIndex] - stockPrices[buyStockIndex];
				if (profit > currentMaxProfit) {
					currentMaxProfit = profit;
				}
			}
			if (currentMaxProfit != 0) {
				if (maxProfitHeap.size() < k) {
					maxProfitHeap.add(currentMaxProfit);
				} else if (maxProfitHeap.peek() < currentMaxProfit) {
					maxProfitHeap.poll();
					maxProfitHeap.add(currentMaxProfit);
				}
			}
		}
		for (Integer profit : maxProfitHeap) {
			maxProfit += profit;
		}

		return maxProfit;
	}

}
