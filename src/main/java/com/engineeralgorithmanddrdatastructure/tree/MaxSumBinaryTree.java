package com.engineeralgorithmanddrdatastructure.tree;

public class MaxSumBinaryTree {
	public static int findMaxSumInBinaryTree(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int[] maxSum = new int[1];
		maxSum[0] = root.getIntValue();
		findMaxSum(root.getLeft(), root.getIntValue(), maxSum);
		findMaxSum(root.getRight(), root.getIntValue(), maxSum);
		return maxSum[0];
	}

	private static void findMaxSum(TreeNode root, int currentSum, int[] maxSum) {
		if (root == null) {
			return;
		}
		int newSum = Math.max(root.getIntValue() + currentSum, root.getIntValue());
		if (newSum > maxSum[0]) {
			maxSum[0] = newSum;
		}
		findMaxSum(root.getLeft(), newSum, maxSum);
		findMaxSum(root.getRight(), newSum, maxSum);
	}
}
