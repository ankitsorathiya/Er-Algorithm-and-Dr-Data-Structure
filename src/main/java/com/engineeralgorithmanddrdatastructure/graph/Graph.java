package com.engineeralgorithmanddrdatastructure.graph;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Graph {
	private final Map<String, Node> nodes;

	public Graph() {
		this.nodes = new HashMap<>();
	}

	public void link(Node node1, Node node2) {
		node1.linkNode(node2);
	}

	public boolean areTheseNodeConnected(Node node1, Node node2) {
		return node1.amIConnectedWith(node2);
	}

	public void addnode(Node node) {
		if (nodes.containsKey(node.getNodeName())) {
			return;
		}
		this.nodes.put(node.getNodeName(), node);
	}

	public Collection<Node> getNodes() {
		return nodes.values();
	}

	public void unlinkSecondNodeFromFirst(Node node1, Node node2) {
		node1.unlinkNode(node2);
	}

	public void linkSecondnodeToFirst(Node node1, Node node2) {
		node1.linkNode(node2);
	}

}
