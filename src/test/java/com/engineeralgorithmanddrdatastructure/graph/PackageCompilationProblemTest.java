package com.engineeralgorithmanddrdatastructure.graph;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.engineeralgorithmanddrdatastructure.graph.Graph;
import com.engineeralgorithmanddrdatastructure.graph.Node;
import com.engineeralgorithmanddrdatastructure.graph.PackageCompilationProblem;

public class PackageCompilationProblemTest {
	@Test
	public void testPackageCompilation() {
		Graph g = new Graph();
		Node a = new Node("A");
		Node b = new Node("B");
		Node c = new Node("C");
		Node d = new Node("D");
		Node e = new Node("E");
		Node f = new Node("F");
		a.linkNode(b);
		b.linkNode(c);
		b.linkNode(d);
		c.linkNode(d);
		g.addnode(a);
		g.addnode(b);
		g.addnode(c);
		g.addnode(d);
		g.addnode(e);
		g.addnode(f);
		List<List<Node>> result = PackageCompilationProblem.getCompilationOrder(g);
		List<List<Node>> expected = new ArrayList<>();
		expected.add(Arrays.asList(d, c, b, a));
		expected.add(Arrays.asList(e));
		expected.add(Arrays.asList(f));
		assertEquals(expected, result);
	}
}
