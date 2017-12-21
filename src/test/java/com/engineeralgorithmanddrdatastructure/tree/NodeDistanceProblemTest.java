package com.engineeralgorithmanddrdatastructure.tree;

import static org.junit.Assert.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class NodeDistanceProblemTest {

	private TreeNode aRoot = new TreeNode("A");
	private TreeNode b = new TreeNode("B");
	private TreeNode c = new TreeNode("C");
	private TreeNode d = new TreeNode("D");
	private TreeNode e = new TreeNode("E");
	private TreeNode f = new TreeNode("F");
	private TreeNode g = new TreeNode("G");
	private TreeNode h = new TreeNode("H");
	private TreeNode i = new TreeNode("I");

	public NodeDistanceProblemTest() {
		aRoot.setLeft(b);
		aRoot.setRight(e);
		b.setLeft(c);
		b.setRight(d);
		e.setLeft(f);
		e.setRight(g);
		f.setLeft(h);
		f.setRight(i);
	}

	@Test
	public void testNodeDistaceBetweenTwoNodes() {
		assertEquals(3, NodeDistanceProblem.findDistanceBetween(c, e, aRoot));
		assertEquals(3, NodeDistanceProblem.findDistanceBetween(i, g, aRoot));
		assertEquals(3, NodeDistanceProblem.findDistanceBetween(aRoot, i, aRoot));
		assertEquals(2, NodeDistanceProblem.findDistanceBetween(g, f, aRoot));
		assertEquals(5, NodeDistanceProblem.findDistanceBetween(c, i, aRoot));
	}

	@Test
	public void testKDistanceNodesFromGivenNode() {
		Set<TreeNode> expected = new HashSet<>();
		expected.add(b);
		expected.add(h);
		expected.add(i);
		Set<TreeNode> actual = NodeDistanceProblem.findAllNodesWithKDistanceFrom(e, aRoot, 2);
		assertEquals(expected, actual);

		expected.clear();
		expected.add(h);
		expected.add(i);
		expected.add(e);
		actual = NodeDistanceProblem.findAllNodesWithKDistanceFrom(f, aRoot, 1);
		assertEquals(expected, actual);

	}
}