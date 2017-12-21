package com.engineeralgorithmanddrdatastructure.tree;

public class TreeNode {
	private final String value;
	private TreeNode left;
	private TreeNode right;

	public TreeNode(String value) {
		super();
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public TreeNode getLeft() {
		return left;
	}

	public TreeNode getRight() {
		return right;
	}

	public void setLeft(TreeNode left) {
		this.left = left;
	}

	public void setRight(TreeNode right) {
		this.right = right;
	}

	@Override
	public String toString() {
		return value;
	}

}
