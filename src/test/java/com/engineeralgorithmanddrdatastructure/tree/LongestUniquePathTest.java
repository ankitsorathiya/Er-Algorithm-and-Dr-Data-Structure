package com.engineeralgorithmanddrdatastructure.tree;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LongestUniquePathTest {

	private TreeNode aRoot = new TreeNode("0");
	private TreeNode b = new TreeNode("1");
	private TreeNode c = new TreeNode("2");
	private TreeNode d = new TreeNode("3");
	private TreeNode e = new TreeNode("4");
	private TreeNode f = new TreeNode("5");
	private TreeNode g = new TreeNode("6");
	private TreeNode h = new TreeNode("7");
	private TreeNode i = new TreeNode("8");
	private TreeNode j = new TreeNode("2");
	private TreeNode k = new TreeNode("9");

	public LongestUniquePathTest() {
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
	public void testLongestUniquePath() {
		assertEquals(5, LongestUniquePath.findMaxUniqueNodeContineousPathSize(aRoot));
	}
}
