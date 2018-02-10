package com.engineeralgorithmanddrdatastructure.dp;

public class EditDistance {
	public static int findEditDistance(String source, String target) {
		if (source == null || target == null) {
			return 0;
		}
		int sourceLength = source.length();
		int targetLegth = target.length();
		int[][] memo = new int[sourceLength + 1][targetLegth + 1];
		for (int sIndex = 1; sIndex < memo.length; sIndex++) {
			memo[sIndex][0] = sIndex;
		}
		for (int tIndex = 1; tIndex < memo[0].length; tIndex++) {
			memo[0][tIndex] = tIndex;
		}
		for (int sIndex = 1; sIndex < memo.length; sIndex++) {
			for (int tIndex = 1; tIndex < memo[sIndex].length; tIndex++) {
				if (source.charAt(sIndex - 1) == target.charAt(tIndex - 1)) {
					memo[sIndex][tIndex] = memo[sIndex - 1][tIndex - 1];
				} else {
					memo[sIndex][tIndex] = Math.min(memo[sIndex - 1][tIndex - 1],
							Math.min(memo[sIndex][tIndex - 1], memo[sIndex - 1][tIndex])) + 1;
				}
			}
		}
		return memo[sourceLength][targetLegth];
	}
}
