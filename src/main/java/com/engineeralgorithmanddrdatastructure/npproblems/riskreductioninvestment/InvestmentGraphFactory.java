package com.engineeralgorithmanddrdatastructure.npproblems.riskreductioninvestment;

import java.util.LinkedList;
import java.util.Queue;

public class InvestmentGraphFactory {
	public static CompaniesGraph buildInvestmentGraph(String serializedConnections) {
		CompaniesGraph graph = new CompaniesGraph();
		if (serializedConnections == null || serializedConnections.isEmpty()) {
			return graph;
		}
		String[] nodes = serializedConnections.split(" ");
		Queue<InvestmentCompany> parents = new LinkedList<>();
		Queue<Integer> parentIndices = new LinkedList<>();
		InvestmentCompany root = new InvestmentCompany(Integer.parseInt(nodes[0]), String.valueOf(0));
		graph.addCompany(root);
		parents.add(root);
		parentIndices.add(0);
		while (true) {
			Queue<InvestmentCompany> goingToBeParents = new LinkedList<>();
			Queue<Integer> goingToBeParentsIndices = new LinkedList<>();
			while (!parents.isEmpty()) {
				InvestmentCompany parent = parents.poll();
				int currentIndex = parentIndices.poll();
				int leftIndex = (currentIndex * 2) + 1;
				int rightIndex = (currentIndex * 2) + 2;
				if (leftIndex >= nodes.length || rightIndex >= nodes.length) {
					break;
				}
				if (!nodes[leftIndex].equals("#")) {
					InvestmentCompany leftComapny = new InvestmentCompany(Integer.parseInt(nodes[leftIndex]),
							String.valueOf(leftIndex));
					graph.addCompany(leftComapny);
					goingToBeParents.add(leftComapny);
					goingToBeParentsIndices.add(leftIndex);
					graph.link(parent, leftComapny);
				}
				if (!nodes[rightIndex].equals("#")) {
					InvestmentCompany rightCompany = new InvestmentCompany(Integer.parseInt(nodes[rightIndex]),
							String.valueOf(rightIndex));
					graph.addCompany(rightCompany);
					graph.link(parent, rightCompany);
					goingToBeParents.add(rightCompany);
					goingToBeParentsIndices.add(rightIndex);
				}

			}
			if (goingToBeParents.isEmpty()) {
				break;
			}
			parents = goingToBeParents;
			parentIndices = goingToBeParentsIndices;
		}
		return graph;

	}
}
