package com.engineeralgorithmanddrdatastructure.npproblems.riskreductioninvestment;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class RiskReductionInvestment {
	private static void invertGraph(CompaniesGraph companiesGraph) {
		Map<String, InvestmentCompany> companies = companiesGraph.getCompanies();
		for (String companyName : companies.keySet()) {
			InvestmentCompany firstCompany = companies.get(companyName);
			for (String otherCompanyName : companies.keySet()) {
				if (companyName.equals(otherCompanyName)) {
					continue;
				}
				InvestmentCompany secondCompany = companies.get(otherCompanyName);
				if (companiesGraph.areTheseCompanyConnected(firstCompany, secondCompany)) {
					companiesGraph.unlinkSecondCompanyFromFirst(firstCompany, secondCompany);
				} else {
					companiesGraph.linkSecondCompanyToFirst(firstCompany, secondCompany);
				}
			}
		}
	}

	private static int findMaximumInvestment(CompaniesGraph companiesGraph) {
		int maxInvestment = 0;
		Set<InvestmentCompany> seen = new HashSet<>();
		Map<String, InvestmentCompany> companies = companiesGraph.getCompanies();
		for (String comapanyName : companies.keySet()) {
			InvestmentCompany currentCompany = companies.get(comapanyName);
			if (seen.contains(currentCompany)) {
				continue;
			}
			Queue<InvestmentCompany> queue = new LinkedList<>();
			Set<InvestmentCompany> possibleClique = new HashSet<>();
			queue.add(currentCompany);
			possibleClique.add(currentCompany);
			while (!queue.isEmpty()) {
				InvestmentCompany currentlySeen = queue.poll();
				if (seen.contains(currentlySeen)) {
					continue;
				}
				Set<InvestmentCompany> companiesToRemove = new HashSet<>();
				for (InvestmentCompany otherCompany : possibleClique) {
					if (!currentlySeen.equals(otherCompany)) {
						if (!companiesGraph.areTheseCompanyConnected(currentCompany, otherCompany)) {
							companiesToRemove.add(otherCompany);
						}
					}
				}
				queue.addAll(currentlySeen.getConnectedCompanies());
				possibleClique.removeAll(companiesToRemove);
				possibleClique.add(currentlySeen);
				seen.add(currentlySeen);
				int currentInvestment = calcualteCurrentInvestment(possibleClique);
				if (currentInvestment > maxInvestment) {
					maxInvestment = currentInvestment;
				}
			}
			seen.add(currentCompany);
		}
		return maxInvestment;
	}

	private static int calcualteCurrentInvestment(Set<InvestmentCompany> companies) {
		return companies.stream().mapToInt(company -> company.getInvestmentValue()).sum();
	}

	public static int findMaximumPossibleInvestmentWithMinimumRisk(String serializedConnections) {
		CompaniesGraph companiesGraph = InvestmentGraphFactory.buildInvestmentGraph(serializedConnections);
		invertGraph(companiesGraph);
		return findMaximumInvestment(companiesGraph);
	}
}
