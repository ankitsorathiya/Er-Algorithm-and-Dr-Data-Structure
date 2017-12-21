package com.engineeralgorithmanddrdatastructure.graph;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Graph {
	private final Map<String, Node> nodes;

	public Graph() {
		this.nodes = new HashMap<>();
	}

	public void addNode(Node node) {
		if (nodes.containsKey(node.getNodeName())) {
			return;
		}
		this.nodes.put(node.getNodeName(), node);
	}

	public Collection<Node> getNodes() {
		return nodes.values();
	}

}
