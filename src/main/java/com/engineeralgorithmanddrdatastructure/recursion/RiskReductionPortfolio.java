package com.engineeralgorithmanddrdatastructure.recursion;

import java.util.LinkedList;
import java.util.Queue;

public class RiskReductionPortfolio {
	public static int findMaxInvestmentFromGivenConnections(String serializedBinaryTree) {
		FolioNode rootFolio = buildTree(serializedBinaryTree);
		if (rootFolio.getValue() == -1) {
			return 0;
		}
		return findMaximizedInvestment(rootFolio);
	}

	private static int findMaximizedInvestment(FolioNode rootFolio) {
		FolioSum folioSum = new FolioSum();
		findMaximizedInvestment(rootFolio, folioSum, true);
		return Math.max(folioSum.getSumFromParent(), folioSum.getSumFromFirstChild());
	}

	private static void findMaximizedInvestment(FolioNode rootFolio, FolioSum folioSum, boolean shouldAddValue) {
		if (rootFolio == null) {
			return;
		}
		if (shouldAddValue) {
			folioSum.addSumFromParent(rootFolio.getValue());
		} else {
			folioSum.addSumFromFirstChild(rootFolio.getValue());
		}
		findMaximizedInvestment(rootFolio.getLeft(), folioSum, !shouldAddValue);
		findMaximizedInvestment(rootFolio.getRight(), folioSum, !shouldAddValue);
	}

	private static FolioNode buildTree(String serializedBinaryTree) {
		if (serializedBinaryTree == null || serializedBinaryTree.isEmpty()) {
			return new FolioNode(-1); // return special node
		}
		String[] binaryTree = serializedBinaryTree.split(" ");
		Queue<FolioNode> parents = new LinkedList<>();
		FolioNode root = new FolioNode(binaryTree[0]);
		parents.add(root);
		int startIndex = 1;
		while (startIndex < binaryTree.length - 1) {
			Queue<FolioNode> goingToBeParents = new LinkedList<>();
			while (!parents.isEmpty()) {
				FolioNode currentRoot = parents.poll();
				if (!binaryTree[startIndex].equals("#")) {
					FolioNode leftFolio = new FolioNode(binaryTree[startIndex]);
					currentRoot.setLeft(leftFolio);
					goingToBeParents.add(leftFolio);
				}
				if (!binaryTree[startIndex + 1].equals("#")) {
					FolioNode rightFolio = new FolioNode(binaryTree[startIndex + 1]);
					currentRoot.setRight(rightFolio);
					goingToBeParents.add(rightFolio);
				}
				startIndex += 2;
			}
			parents = goingToBeParents;
		}
		return root;
	}

}

class FolioSum {
	private int sumFromParent;
	private int sumFromFirstChild;

	public int getSumFromParent() {
		return sumFromParent;
	}

	public int getSumFromFirstChild() {
		return sumFromFirstChild;
	}

	public void addSumFromParent(int sumFromParent) {
		this.sumFromParent += sumFromParent;
	}

	public void addSumFromFirstChild(int sumFromFirstChild) {
		this.sumFromFirstChild += sumFromFirstChild;
	}

}

class FolioNode {
	private final int value;
	private FolioNode left;
	private FolioNode right;

	public FolioNode(String value) {
		this.value = Integer.parseInt(value);
	}

	public FolioNode(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public FolioNode getLeft() {
		return left;
	}

	public FolioNode getRight() {
		return right;
	}

	public void setLeft(FolioNode left) {
		this.left = left;
	}

	public void setRight(FolioNode right) {
		this.right = right;
	}

}
