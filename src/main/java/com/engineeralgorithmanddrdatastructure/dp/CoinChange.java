package com.engineeralgorithmanddrdatastructure.dp;

import java.util.Arrays;

public class CoinChange {
	public static long findWaysToChange(int n, int coins[]) {
		long[] memo = new long[n + 1];
		Arrays.fill(memo, 0);
		memo[0] = 1;
		for (int i = 0; i < coins.length; i++)
			for (int j = coins[i]; j <= n; j++)
				memo[j] += memo[j - coins[i]];

		return memo[n];
	}
}