package com.engineeralgorithmanddrdatastructure.tree;

public class TreeNode {
	private String value;
	private TreeNode left;
	private TreeNode right;
	private int intValue;

	public TreeNode(String value) {
		super();
		this.value = value;
	}

	public TreeNode(int intValue) {
		this.intValue = intValue;
	}

	public String getValue() {
		return value;
	}

	public int getIntValue() {
		return this.intValue;
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
		return value + " " + intValue;
	}

}
