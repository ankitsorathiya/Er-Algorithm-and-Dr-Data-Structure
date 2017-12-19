package com.engineeralgorithmanddrdatastructure.dp;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CoinProblem {
	public static int findTotalWaysToGiveChangeOf_Inefficient(int money, List<Integer> denominations) {
		if (money <= 0) {
			return 0;
		}
		Collections.reverse(denominations);
		return findWaysToChange(money, denominations);
	}

	private static int findWaysToChange(int money, List<Integer> denominations) {
		int[] result = new int[1];
		findWaysToChange(money, 0, 0, denominations, result);
		return result[0];

	}

	private static void findWaysToChange(int money, int denominationIndex, int noOfUsage, List<Integer> denominations,
			int[] result) {
		if (denominationIndex >= denominations.size()) {
			return;
		}

		int canUse = money / denominations.get(denominationIndex);
		for (int currentUsage = 0; currentUsage <= canUse; currentUsage++) {
			int remainingMoney = money - (denominations.get(denominationIndex) * currentUsage);
			if (remainingMoney == 0) {
				result[0]++;
				break;
			}
			if (remainingMoney < 0) {
				continue;
			}
			findWaysToChange(remainingMoney, denominationIndex + 1, currentUsage, denominations, result);
		}
	}

	public static long findTotalWaysToGiveChangeOf_efficient(int n, int coins[]) {
		long[] memo = new long[n + 1];
		Arrays.fill(memo, 0);
		memo[0] = 1;
		for (int i = 0; i < coins.length; i++)
			for (int j = coins[i]; j <= n; j++)
				memo[j] += memo[j - coins[i]];

		return memo[n];
	}
}
