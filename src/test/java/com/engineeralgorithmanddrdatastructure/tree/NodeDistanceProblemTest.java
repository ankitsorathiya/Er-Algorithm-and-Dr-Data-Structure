package com.engineeralgorithmanddrdatastructure.tree;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class NodeDistanceProblemTest {
	@Test
	public void testNodeDistance() {
		TreeNode a = new TreeNode("A");
		TreeNode b = new TreeNode("B");
		TreeNode c = new TreeNode("C");
		TreeNode d = new TreeNode("D");
		TreeNode e = new TreeNode("E");
		TreeNode f = new TreeNode("F");
		TreeNode g = new TreeNode("G");
		TreeNode h = new TreeNode("H");
		TreeNode i = new TreeNode("I");
		a.setLeft(b);
		a.setRight(e);
		b.setLeft(c);
		b.setRight(d);
		e.setLeft(f);
		e.setRight(g);
		f.setLeft(h);
		f.setRight(i);
		assertEquals(3, NodeDistanceProblem.findDistanceBetween(c, e, a));
		assertEquals(3, NodeDistanceProblem.findDistanceBetween(i, g, a));
		assertEquals(3, NodeDistanceProblem.findDistanceBetween(a, i, a));
		assertEquals(2, NodeDistanceProblem.findDistanceBetween(g, f, a));
		assertEquals(5, NodeDistanceProblem.findDistanceBetween(c, i, a));
	}
}
