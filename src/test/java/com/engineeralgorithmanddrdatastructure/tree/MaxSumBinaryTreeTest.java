package com.engineeralgorithmanddrdatastructure.tree;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MaxSumBinaryTreeTest {
	private TreeNode aRoot = new TreeNode(50);
	private TreeNode b = new TreeNode(10);
	private TreeNode c = new TreeNode(20);
	private TreeNode d = new TreeNode(30);
	private TreeNode e = new TreeNode(-5);
	private TreeNode f = new TreeNode(-3);
	private TreeNode g = new TreeNode(80);
	private TreeNode h = new TreeNode(-10);
	private TreeNode i = new TreeNode(5);
	private TreeNode j = new TreeNode(-2);
	private TreeNode k = new TreeNode(10);

	public MaxSumBinaryTreeTest() {
		aRoot.setLeft(b);
		aRoot.setRight(c);
		b.setLeft(d);
		b.setRight(e);
		c.setLeft(f);
		c.setRight(g);
		f.setLeft(h);
		f.setRight(i);
		h.setLeft(j);
		h.setRight(k);
	}

	@Test
	public void testMaxSumBinaryTree() {
		assertEquals(150, MaxSumBinaryTree.findMaxSumInBinaryTree(aRoot));
	}
}
