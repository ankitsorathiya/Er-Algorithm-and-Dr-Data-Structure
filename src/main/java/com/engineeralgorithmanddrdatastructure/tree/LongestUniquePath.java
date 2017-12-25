package com.engineeralgorithmanddrdatastructure.tree;

import java.util.HashSet;

public class LongestUniquePath {
	public static int findMaxUniqueNodeContineousPathSize(TreeNode node) {
		int[] maxPath = new int[1];
		findMaxPath(node, maxPath, new HashSet<>());
		return maxPath[0];

	}

	@SuppressWarnings("unchecked")
	private static void findMaxPath(TreeNode node, int[] maxPath, HashSet<String> memo) {
		if (node == null) {
			return;
		}
		if (memo.contains(node.getValue())) {
			return;
		}
		memo.add(node.getValue());
		if (memo.size() > maxPath[0]) {
			maxPath[0] = memo.size();
		}
		findMaxPath(node.getLeft(), maxPath, (HashSet<String>) memo.clone());
		findMaxPath(node.getRight(), maxPath, (HashSet<String>) memo.clone());
	}
}
