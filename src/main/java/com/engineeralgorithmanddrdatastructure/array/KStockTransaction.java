package com.engineeralgorithmanddrdatastructure.array;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

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

	public static int findMaxProfitWithKStockTransaction_Kadem(int[] stockPrices, int k) {
		int maxProfit = 0;
		if (k <= 0 || stockPrices == null || stockPrices.length == 0 || stockPrices.length <= k) {
			return maxProfit;
		}
		Set<Integer> BestBuyIndexes = new HashSet<>();
		for (int kThTransaction = 1; kThTransaction <= k; kThTransaction++) {
			int currentBuyIndex = findBestBuyIndex(BestBuyIndexes, stockPrices);
			int bestBuy = stockPrices[currentBuyIndex];
			int currentProfit = 0;
			for (int stockTime = currentBuyIndex + 1; stockTime < stockPrices.length; stockTime++) {
				if (stockPrices[stockTime] > bestBuy) {
					currentProfit = Math.max(currentProfit, stockPrices[stockTime] - bestBuy);
				} else if (!BestBuyIndexes.contains(stockTime)) {
					bestBuy = stockPrices[stockTime];
					currentBuyIndex = stockTime;
				}
			}
			BestBuyIndexes.add(currentBuyIndex);
			maxProfit += currentProfit;

		}

		return maxProfit;
	}

	private static int findBestBuyIndex(Set<Integer> bestBuyIndexes, int[] stockPrices) {
		for (int stockTime = 0; stockTime < stockPrices.length; stockTime++) {
			if (!bestBuyIndexes.contains(stockTime)) {
				return stockTime;
			}
		}
		return 0;
	}

}
