package com.engineeralgorithmanddrdatastructure.combinactory.graph;

import java.util.HashSet;
import java.util.Set;

public class Node {
	private final Set<Node> children;
	private final int value;
	private final String nodeName;

	public int getValue() {
		return value;
	}

	public Node(int value, String nodeName) {
		this.value = value;
		this.children = new HashSet<>();
		this.nodeName = nodeName;
	}

	public Node(String nodeName) {
		this.value = 0;
		this.children = new HashSet<>();
		this.nodeName = nodeName;
	}

	public void linkNode(Node otherNode) {
		this.children.add(otherNode);
	}

	public boolean amIConnectedWith(Node otherNode) {
		return this.children.contains(otherNode);
	}

	public void unlinkNode(Node otherNode) {
		this.children.remove(otherNode);
	}

	public String getNodeName() {
		return nodeName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nodeName == null) ? 0 : nodeName.hashCode());
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
		if (nodeName == null) {
			if (other.nodeName != null)
				return false;
		} else if (!nodeName.equals(other.nodeName))
			return false;
		return true;
	}

	public Set<Node> getChildren() {
		return this.children;
	}

	@Override
	public String toString() {
		return nodeName;
	}

}
