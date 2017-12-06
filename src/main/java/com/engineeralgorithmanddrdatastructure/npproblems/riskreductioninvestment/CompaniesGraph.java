package com.engineeralgorithmanddrdatastructure.npproblems.riskreductioninvestment;

import java.util.HashMap;
import java.util.Map;

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

	public void unlink(InvestmentCompany company1, InvestmentCompany company2) {
		company1.unlinkCompany(company2);
		company2.unlinkCompany(company1);
	}

	public void addCompany(InvestmentCompany company) {
		if (companies.containsKey(company.getCompanyName())) {
			return;
		}
		this.companies.put(company.getCompanyName(), company);
	}

	public InvestmentCompany getCompany(String compnayName) {
		return companies.get(compnayName);
	}

	public boolean hasComapnyWithName(String compnayName) {
		return companies.containsKey(compnayName);
	}

	public Map<String, InvestmentCompany> getCompanies() {
		return companies;
	}

	public void unlinkSecondCompanyFromFirst(InvestmentCompany company1, InvestmentCompany company2) {
		company1.unlinkCompany(company2);
	}

	public void linkSecondCompanyToFirst(InvestmentCompany company1, InvestmentCompany company2) {
		company1.linkCompany(company2);
	}
}
