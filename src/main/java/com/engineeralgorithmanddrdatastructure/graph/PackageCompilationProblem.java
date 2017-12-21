package com.engineeralgorithmanddrdatastructure.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 
 * @author ankit.sorathiya
 *
 *         Given a dependency of package , find out whether it can compile or
 *         not?
 * 		   eg.
 * 			
 * 			A <-----|
 *         / \      |
 *        \/  \/    |
 *         B->C-----
 *         
 *         result- No, It can not compile
 *         
 *         
 *        eg.2 
			A 
 *         / \      
 *        \/  \/      D-->E
 *         B->C
 *         
 *         result [[C,B,A] [E,D]] 
 *         
 *         
 */
public class PackageCompilationProblem {

	public static List<List<Node>> getCompilationOrder(Graph graph) {
		List<List<Node>> result = new ArrayList<>();
		if (graph == null) {
			return result;
		}
		Set<Node> memo = new HashSet<>();
		HashSet<Node> seenNodes = new HashSet<>();
		for (Node node : graph.getNodes()) {
			if (!memo.contains(node)) {
				List<Node> dependencies = new ArrayList<>();
				boolean compilable = isCompilable(node, graph, memo, seenNodes, dependencies);
				if (!compilable) {
					return new ArrayList<>();
				}
				result.add(dependencies);
			}
		}

		return result;
	}

	private static boolean isCompilable(Node currentNode, Graph graph, Set<Node> memo, HashSet<Node> seenNodes,
			List<Node> dependencies) {
		if (currentNode == null) {
			return true;
		}
		if (seenNodes.contains(currentNode)) {
			return false;
		}
		if (memo.contains(currentNode)) {
			return true;
		}
		seenNodes.add(currentNode);
		for (Node node : currentNode.getChildren()) {
			@SuppressWarnings("unchecked")
			boolean compilable = isCompilable(node, graph, memo, (HashSet<Node>) seenNodes.clone(), dependencies);
			if (!compilable) {
				return false;
			}
		}
		memo.add(currentNode);
		dependencies.add(currentNode);
		return true;
	}

}
