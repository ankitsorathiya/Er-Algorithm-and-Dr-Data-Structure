package com.engineeralgorithmanddrdatastructure.tree;

public class MaxSumBinaryTree {
	public static int findMaxSumInBinaryTreePathFrom(TreeNode root) {
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

	public static int findMaxSumOfBinaryTree(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int[] maxSum = new int[1];
		int[] currentSum = new int[1];
		maxSum[0] = root.getIntValue();
		currentSum[0] = root.getIntValue();
		findMaxSumOfBinaryTree(root.getLeft(), currentSum, maxSum);
		findMaxSumOfBinaryTree(root.getRight(), currentSum, maxSum);
		return maxSum[0];

	}

	private static void findMaxSumOfBinaryTree(TreeNode root, int[] currentSum, int[] maxSum) {
		if (root == null) {
			return;
		}
		currentSum[0] = Math.max(currentSum[0], Math.max(root.getIntValue() + currentSum[0], root.getIntValue()));
		if (currentSum[0] > maxSum[0]) {
			maxSum[0] = currentSum[0];
		}
		findMaxSumOfBinaryTree(root.getLeft(), currentSum, maxSum);
		findMaxSumOfBinaryTree(root.getRight(), currentSum, maxSum);

	}
}
