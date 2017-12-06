package com.engineeralgorithmanddrdatastructure.npproblems.riskreductioninvestment;

import java.util.HashSet;
import java.util.Set;

public class InvestmentCompany {
	private final Set<InvestmentCompany> connectedCompanies;
	private final int investmentValue;
	private final String companyName;

	public int getInvestmentValue() {
		return investmentValue;
	}

	public InvestmentCompany(int investmentValue, String companyName) {
		this.investmentValue = investmentValue;
		this.connectedCompanies = new HashSet<>();
		this.companyName = companyName;
	}

	public void linkCompany(InvestmentCompany otherCompany) {
		this.connectedCompanies.add(otherCompany);
	}

	public boolean amIConnectedWith(InvestmentCompany otherCompany) {
		return this.connectedCompanies.contains(otherCompany);
	}

	public void unlinkCompany(InvestmentCompany otherCompany) {
		this.connectedCompanies.remove(otherCompany);
	}

	public String getCompanyName() {
		return companyName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((companyName == null) ? 0 : companyName.hashCode());
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
		InvestmentCompany other = (InvestmentCompany) obj;
		if (companyName == null) {
			if (other.companyName != null)
				return false;
		} else if (!companyName.equals(other.companyName))
			return false;
		return true;
	}

	public Set<InvestmentCompany> getConnectedCompanies() {
		return connectedCompanies;
	}

}
