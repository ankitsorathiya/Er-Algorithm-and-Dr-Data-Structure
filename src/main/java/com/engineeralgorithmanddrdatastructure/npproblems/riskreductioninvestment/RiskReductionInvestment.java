package com.engineeralgorithmanddrdatastructure.npproblems.riskreductioninvestment;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class RiskReductionInvestment {
	private static void invertGraph(CompaniesGraph companiesGraph) {
		Collection<InvestmentCompany> companies = companiesGraph.getCompanies();
		for (InvestmentCompany firstCompany : companies) {
			for (InvestmentCompany secondCompany : companies) {
				if (firstCompany.equals(secondCompany)) {
					continue;
				}
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
		Collection<InvestmentCompany> companies = companiesGraph.getCompanies();
		for (InvestmentCompany currentCompany : companies) {
			Set<Set<InvestmentCompany>> possibleClique = new HashSet<>();
			for (InvestmentCompany connectedCompany : currentCompany.getConnectedCompanies()) {
				Set<InvestmentCompany> currentClique = new HashSet<>();
				currentClique.add(currentCompany);
				currentClique.add(connectedCompany);
				possibleClique.add(currentClique);
			}
			for (InvestmentCompany connectedCompany : currentCompany.getConnectedCompanies()) {
				for (Set<InvestmentCompany> clique : possibleClique) {
					if (companiesGraph.isConnectedWithAll(connectedCompany, clique)) {
						clique.add(connectedCompany);
						int currentInvestment = calcualteCurrentInvestment(clique);
						if (currentInvestment > maxInvestment) {
							maxInvestment = currentInvestment;
						}
					}
				}
			}
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
