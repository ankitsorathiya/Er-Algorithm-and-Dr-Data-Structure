package com.engineeralgorithmanddrdatastructure.search;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class BidirectionalGraphSearch {

	public Path bidirectionalSearch(String source, String destination, Map<String, List<String>> graphConnectivity) {
		Graph graph = GraphFactory.buildGraph(graphConnectivity);
		Node sourceNode = graph.getNode(source);
		Node destinationNode = graph.getNode(destination);
		return this.bidirectionalSearch(sourceNode, destinationNode, graph);
	}

	public Path bidirectionalSearch(Node source, Node destination, Graph graph) {
		Set<Node> sourceTraversed = new HashSet<>();
		sourceTraversed.add(source);
		Set<Node> destinationTraversed = new HashSet<>();
		destinationTraversed.add(destination);

		Map<Node, Node> sourcePath = new HashMap<>();
		sourcePath.put(source, null);// source has no parent

		Map<Node, Node> destinationPath = new HashMap<>();
		destinationPath.put(destination, null); // destination has no parent;

		Queue<Node> sourceQueue = new LinkedList<>();
		sourceQueue.add(source);

		Queue<Node> destinationQueue = new LinkedList<>();
		destinationQueue.add(destination);
		Node intersectinNode = null;
		while (!sourceQueue.isEmpty() && !destinationQueue.isEmpty()) {
			doBFS(sourceQueue, sourceTraversed, sourcePath);
			doBFS(destinationQueue, destinationTraversed, destinationPath);
			intersectinNode = getIntersectingNode(sourceTraversed, destinationTraversed);
			if (intersectinNode != null) {
				break;
			}
		}
		return getPathFrom(intersectinNode, source, destination, sourcePath, destinationPath);

	}

	private Path getPathFrom(Node intersectingNode, Node sourceNode, Node destinationNode, Map<Node, Node> sourcePath,
			Map<Node, Node> destinationPath) {
		if (intersectingNode == null) {
			return new Path(sourceNode, destinationNode, false);
		}

		Path path = new Path(sourceNode, destinationNode, true);
		path.addNodeFirst(intersectingNode);

		Node current = intersectingNode;
		while (!current.equals(sourceNode)) {
			path.addNodeFirst(sourcePath.get(current));
			current = sourcePath.get(current);
		}

		current = intersectingNode;
		while (!current.equals(destinationNode)) {
			path.addNodeLast(destinationPath.get(current));
			current = destinationPath.get(current);
		}
		return path;
	}

	private Node getIntersectingNode(Set<Node> sourceTraversed, Set<Node> destinationTraversed) {
		for (Node node : sourceTraversed) {
			if (destinationTraversed.contains(node)) {
				return node;
			}
		}
		return null;
	}

	private void doBFS(Queue<Node> traversing, Set<Node> traversed, Map<Node, Node> path) {
		Node current = traversing.poll();
		for (Node neighbour : current.getNeighbours()) {
			if (!traversed.contains(neighbour)) {
				traversed.add(neighbour);
				path.put(neighbour, current);
				traversing.add(neighbour);
			}
		}
	}

}

class Path {
	private final boolean isValidPath;
	private final Node sourceNode;
	private final Node destinationNode;
	private final LinkedList<Node> pathNodes;

	public Path(Node source, Node destination, boolean validPath) {
		this.sourceNode = source;
		this.destinationNode = destination;
		this.pathNodes = new LinkedList<>();
		this.isValidPath = validPath;
	}

	public Node getSourceNode() {
		return sourceNode;
	}

	public Node getDestinationNode() {
		return destinationNode;
	}

	public void addNodeFirst(Node node) {
		this.pathNodes.addFirst(node);
	}

	public void addNodeLast(Node node) {
		this.pathNodes.addLast(node);
	}

	public List<Node> getPathNodes() {
		return pathNodes;
	}

	public boolean isValidPath() {
		return isValidPath;
	}

	@Override
	public String toString() {
		StringBuffer path = new StringBuffer();
		if (this.isValidPath) {
			for (Node intermediate : pathNodes) {
				path.append(intermediate).append("=>");
			}
			return path.substring(0, path.length() - 2);
		} else {
			path.append(sourceNode).append("=> no path exists <=").append(destinationNode);
		}
		return path.toString();
	}
}

class GraphFactory {
	public static Graph buildGraph(Map<String, List<String>> connectivity) {
		Graph graph = new Graph();
		for (String key : connectivity.keySet()) {
			graph.addNode(key, connectivity.get(key));
		}
		return graph;
	}
}

class Graph {
	private final Map<String, Node> nodes;

	public Graph() {
		this.nodes = new HashMap<>();
	}

	public Node getNode(String nodeName) {
		return this.nodes.get(nodeName);
	}

	public void addNode(String nodeName, List<String> neighbours) {
		Node node = nodes.get(nodeName);
		if (node == null) {
			node = new Node(nodeName);
		}

		for (String neighbour : neighbours) {
			Node neighbourNode = nodes.get(neighbour);
			if (neighbourNode == null) {
				neighbourNode = new Node(neighbour);
			}
			node.linkWith(neighbourNode);
			nodes.put(neighbour, neighbourNode);
		}
		nodes.put(nodeName, node);
	}

	@Override
	public String toString() {
		return this.nodes.toString();
	}
}

class Node {
	private final String value;
	private final Set<Node> neighbours;

	public Set<Node> getNeighbours() {
		return neighbours;
	}

	public String getValue() {
		return value;
	}

	public void linkWith(Node other) {
		this.neighbours.add(other);
	}

	public Node(String value) {
		this.value = value;
		this.neighbours = new HashSet<>();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Node other = (Node) obj;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return this.value;
	}
}
