package com.engineeralgorithmanddrdatastructure.npproblems.riskreductioninvestment;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CompaniesGraph {
	private final Map<String, InvestmentCompany> companies;

	public CompaniesGraph() {
		this.companies = new HashMap<>();
	}

	public void link(InvestmentCompany company1, InvestmentCompany company2) {
		company1.linkCompany(company2);
		company2.linkCompany(company1);
	}

	public boolean areTheseCompanyConnected(InvestmentCompany company1, InvestmentCompany company2) {
		return company1.amIConnectedWith(company2);
	}

	public void addCompany(InvestmentCompany company) {
		if (companies.containsKey(company.getCompanyName())) {
			return;
		}
		this.companies.put(company.getCompanyName(), company);
	}

	public Collection<InvestmentCompany> getCompanies() {
		return companies.values();
	}

	public void unlinkSecondCompanyFromFirst(InvestmentCompany company1, InvestmentCompany company2) {
		company1.unlinkCompany(company2);
	}

	public void linkSecondCompanyToFirst(InvestmentCompany company1, InvestmentCompany company2) {
		company1.linkCompany(company2);
	}

	public boolean isConnectedWithAll(InvestmentCompany connectedCompany, Set<InvestmentCompany> companies) {
		for (InvestmentCompany company : companies) {
			if (!connectedCompany.amIConnectedWith(company)) {
				return false;
			}
		}
		return true;
	}
}
