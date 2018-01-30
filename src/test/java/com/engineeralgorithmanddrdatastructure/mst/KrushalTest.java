package com.engineeralgorithmanddrdatastructure.mst;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class KrushalTest {
	@Test
	public void testKrushalMST() {
		List<Edge> graph = new ArrayList<>();
		graph.add(new Edge(1, 2, 1));
		graph.add(new Edge(2, 1, 1));
		graph.add(new Edge(1, 3, 4));
		graph.add(new Edge(3, 1, 4));
		graph.add(new Edge(1, 4, 3));
		graph.add(new Edge(4, 1, 3));
		graph.add(new Edge(3, 4, 5));
		graph.add(new Edge(4, 3, 5));
		graph.add(new Edge(4, 2, 2));
		graph.add(new Edge(2, 4, 2));
		assertEquals(7, Krushal.findMinimumSpanningTree(graph));
	}
}