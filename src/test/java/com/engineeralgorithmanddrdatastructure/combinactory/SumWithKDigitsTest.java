package com.engineeralgorithmanddrdatastructure.combinactory;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class SumWithKDigitsTest {
	private int[] input;
	List<ArrayList<Integer>> expected;
	private int k;
	private int sum;

	public SumWithKDigitsTest(List<ArrayList<Integer>> expected, int[] input, int k, int sum) {
		this.expected = expected;
		this.input = input;
		this.k = k;
		this.sum = sum;
	}

	@Parameters
	public static Collection<Object[]> getData() {
		Collection<Object[]> input = new ArrayList<>();
		List<ArrayList<Integer>> result = new ArrayList<>();
		result.add((ArrayList<Integer>) Arrays.asList(1, 3, 6, 9));
		result.add((ArrayList<Integer>) Arrays.asList(1, 3, 7, 8));
		result.add((ArrayList<Integer>) Arrays.asList(1, 4, 5, 9));
		result.add((ArrayList<Integer>) Arrays.asList(1, 4, 6, 8));
		result.add((ArrayList<Integer>) Arrays.asList(1, 5, 6, 7));
		result.add((ArrayList<Integer>) Arrays.asList(2, 3, 5, 9));
		result.add((ArrayList<Integer>) Arrays.asList(2, 3, 6, 8));
		result.add((ArrayList<Integer>) Arrays.asList(2, 4, 5, 8));
		result.add((ArrayList<Integer>) Arrays.asList(2, 4, 6, 7));
		result.add((ArrayList<Integer>) Arrays.asList(3, 4, 5, 7));
		input.add(new Object[] { result, new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 }, 4, 19 });
		return input;
	}

	@Test
	public void testMaximizedInvestmentFolio() {
		assertEquals(this.expected, SumWithKDigits.findKDigitsWhoSum(input, k, sum));
	}
}
