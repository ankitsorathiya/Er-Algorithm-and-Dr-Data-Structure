package com.engineeralgorithmanddrdatastructure.mst;

import java.util.PriorityQueue;
import java.util.Queue;

public class Prims {
	public static int findMSTWithPrims(int[][] adjacancey) {
		int mst = 0;
		NodeEdge current = new NodeEdge(0, 0);
		Queue<NodeEdge> priority = new PriorityQueue<>((edge1, edge2) -> edge1.getWeight() - edge2.getWeight());
		priority.add(current);
		boolean[] seen = new boolean[adjacancey.length];
		while (!priority.isEmpty()) {
			NodeEdge edge = priority.poll();
			if (seen[edge.getTo()]) {
				continue;
			}
			seen[edge.getTo()] = true;
			mst += edge.getWeight();
			for (int nIndex = 0; nIndex < adjacancey[edge.getTo()].length; nIndex++) {
				if (!seen[nIndex] && adjacancey[edge.getTo()][nIndex] > 0) {
					priority.add(new NodeEdge(nIndex, adjacancey[edge.getTo()][nIndex]));
				}
			}
		}

		return mst;
	}
}

class NodeEdge {
	private final int to;
	private final int weight;

	public NodeEdge(int to, int weight) {
		super();
		this.to = to;
		this.weight = weight;
	}

	public int getTo() {
		return to;
	}

	public int getWeight() {
		return weight;
	}

}
