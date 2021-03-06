package com.engineeralgorithmanddrdatastructure.npproblems.riskreductioninvestment;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.engineeralgorithmanddrdatastructure.npproblems.riskreductioninvestment.RiskReductionInvestment;

@RunWith(Parameterized.class)
public class RiskReductionInvestmentTest {
	private int expected;
	private String serializedData;

	public RiskReductionInvestmentTest(int expected, String serializedData) {
		this.serializedData = serializedData;
		this.expected = expected;
	}

	@Parameters
	public static Collection<Object[]> getData() {
		Collection<Object[]> input = new ArrayList<>();
		input.add(new Object[] { 9, "3 4 5 1 3 # 1" });
		input.add(new Object[] { 0, "" });
		input.add(new Object[] { 0, null });
		input.add(new Object[] { 70, "10 10 10 10 10 10 10 10 10 10 10 10 # # #" });
		input.add(new Object[] { 309, "30 40 90 80 12 45 78 10 12 56 20 14 # # #" });
		return input;
	}

	@Test
	public void testMaximizedInvestmentFolio() {
		assertEquals(expected,
				RiskReductionInvestment.findMaximumPossibleInvestmentWithMinimumRisk(this.serializedData));
	}
}
