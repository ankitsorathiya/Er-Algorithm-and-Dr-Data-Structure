package com.engineeralgorithmanddrdatastructure.mst;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Krushal {
	public static int findMinimumSpanningTree(List<Edge> graph) {
		graph.sort((a, b) -> a.getWeight() - b.getWeight());
		Set<Integer> seen = new HashSet<>();
		int mst=0;
		for (Edge edge : graph) {
			if (!seen.contains(edge.getFrom()) || !seen.contains(edge.getTo())) {
				seen.add(edge.getFrom());
				seen.add(edge.getTo());
				mst += edge.getWeight();
			}
		}
		return mst;
	}
}

class Edge {
	private final int from;
	private final int to;
	private final int weight;

	public Edge(int from, int to, int weight) {
		super();
		this.from = from;
		this.to = to;
		this.weight = weight;
	}

	public int getFrom() {
		return from;
	}

	public int getTo() {
		return to;
	}

	public int getWeight() {
		return weight;
	}

	@Override
	public String toString() {
		return "Edge [from=" + from + ", to=" + to + ", weight=" + weight + "]";
	}
}
