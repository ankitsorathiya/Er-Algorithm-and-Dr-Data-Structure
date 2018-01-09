package com.engineeralgorithmanddrdatastructure.ds.heap;

/**
 * 
 * @author ankit.sorathiya
 *
 *         There are N boxes all contains gems with given condition.
 * 
 *         P boxes of size A
 * 
 *         Q boxes of size B
 * 
 *         Where P+Q=N
 * 
 *         find how may ways you can give at least X gems
 * 
 */
public class XGemsProblem {

	public static int findWaysToGiveAtLeastXGems(int N, int P, int A, int Q, int B, int X) {
		if (N <= 0) {
			return 0;
		}

		int maxBGems = Q * B;
		int maxAGems = P * A;
		int[] gemsA = new int[maxAGems + 1];
		int[] gemsB = new int[maxBGems + 1];
		findWays(A, P, X, gemsA);
		findWays(B, Q, X, gemsB);
		return findCount(gemsA, gemsB, maxAGems);
	}

	private static int findCount(int[] gemsA, int[] gemsB, int X) {
		int total = 0;
		for (int aGem = gemsA.length - 1; aGem >= 0; aGem--) {
			boolean shouldBreak = false;
			for (int bGem = gemsB.length - 1; bGem >= 0; bGem--) {
				if (aGem + bGem >= X) {
					if (gemsA[aGem] > 0 && gemsB[bGem] > 0) {
						total += gemsA[aGem] * gemsB[bGem];
					} else {
						total += gemsA[aGem] + gemsB[bGem];
					}
				} else {
					shouldBreak = true;
					break;
				}
			}
			if (shouldBreak && aGem < X) {
				break;
			}
		}
		return total;

	}

	private static void findWays(int maxBoxSize, int howManyBoxes, int howManyGems, int[] memo) {
		for (int gems = maxBoxSize; gems >= 0; gems--) {
			findWays(gems, memo, maxBoxSize, howManyBoxes, howManyGems, 1);
		}
	}

	private static void findWays(int currentGems, int[] memo, int maxBoxSize, int howManyBoxes, int totalGems,
			int currentBox) {
		if (currentBox > howManyBoxes) {
			return;
		}
		if (currentBox == howManyBoxes) {
			memo[currentGems]++;
			return;
		}
		for (int gems = maxBoxSize; gems >= 0; gems--) {
			findWays(currentGems += gems, memo, maxBoxSize, howManyBoxes, totalGems, currentBox + 1);
		}
	}

}
