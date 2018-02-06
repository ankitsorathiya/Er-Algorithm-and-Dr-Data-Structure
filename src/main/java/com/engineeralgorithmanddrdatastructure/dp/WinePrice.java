package com.engineeralgorithmanddrdatastructure.dp;

public class WinePrice {
	public static int findMaxWinePriceWithYear(int[] winePrice) {
		int[][] memo = new int[winePrice.length][winePrice.length];
		return findMaxWinePriceWithYear(winePrice, 0, winePrice.length - 1, memo);
	}

	private static int findMaxWinePriceWithYear(int[] winePrice, int start, int end, int[][] memo) {
		if (start > end) {
			return 0;
		}
		if (memo[start][end] > 0) {
			return memo[start][end];
		}
		int year = winePrice.length - (end - start + 1) + 1;
		int leftSell = year * winePrice[start] + findMaxWinePriceWithYear(winePrice, start + 1, end, memo);
		int rightSell = year * winePrice[end] + findMaxWinePriceWithYear(winePrice, start, end - 1, memo);
		return memo[start][end] = Math.max(leftSell, rightSell);
	}

}
