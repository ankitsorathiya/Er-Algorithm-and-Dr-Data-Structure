package com.engineeralgorithmanddrdatastructure.dp;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CoinProblem {
	public static int findTotalWaysToGiveChangeOf(int money, List<Integer> denominations) {
		if (money <= 0) {
			return 0;
		}
		Collections.reverse(denominations);
		return findWaysToChange(money, denominations);
	}

	private static int findWaysToChange(int money, List<Integer> denominations) {
		Map<Integer, Map<String, Boolean>> memo = new HashMap<>();
		int[] result = new int[1];
		findWaysToChange(money, 0, 0, denominations, memo, result);
		return result[0];

	}

	private static void findWaysToChange(int money, int denominationIndex, int noOfUsage, List<Integer> denominations,
			Map<Integer, Map<String, Boolean>> memo, int[] result) {
		if (denominationIndex >= denominations.size()) {
			return;
		}

		int canUse = money / denominations.get(denominationIndex);
		for (int currentUsage = 0; currentUsage <= canUse; currentUsage++) {
			int remainingMoney = money - (denominations.get(denominationIndex) * currentUsage);
			String currentKey = denominations.get(denominationIndex) + "-" + currentUsage;
			if (!memo.containsKey(remainingMoney)) {
				memo.put(remainingMoney, new HashMap<>());
			}
			if ((memo.get(remainingMoney).containsKey(currentKey))) {
				if (memo.get(remainingMoney).get(currentKey)) {
					result[0]++;
					break;
				}
				continue;
			}
			if (remainingMoney == 0) {
				memo.get(money).put(currentKey, true);
				result[0]++;
				break;
			} else {
				memo.get(money).put(currentKey, false);
			}
			if (remainingMoney < 0) {
				break;
			}
			findWaysToChange(remainingMoney, denominationIndex + 1, currentUsage, denominations, memo, result);
		}
	}

}
