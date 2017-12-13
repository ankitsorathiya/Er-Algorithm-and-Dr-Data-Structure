package com.engineeralgorithmanddrdatastructure.combinactory;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class SumTripletTest {
	private int[] input;
	private List<Triplet> expected;

	public SumTripletTest(List<Triplet> expected, int[] input) {
		this.expected = expected;
		this.input = input;
	}

	@Parameters
	public static Collection<Object[]> getData() {

		Collection<Object[]> input = new ArrayList<>();
		List<Triplet> result1 = new ArrayList<>();
		result1.add(new Triplet(1, 2, 3));
		result1.add(new Triplet(1, 3, 4));
		input.add(new Object[] { result1, new int[] { 1, 2, 3, 4 } });

		List<Triplet> result2 = new ArrayList<>();
		result2.add(new Triplet(1, 3, 4));
		result2.add(new Triplet(1, 4, 5));
		result2.add(new Triplet(1, 5, 6));
		result2.add(new Triplet(3, 6, 9));
		result2.add(new Triplet(4, 5, 9));
		input.add(new Object[] { result2, new int[] { 1, 3, 4, 5, 6, 9 } });

		return input;
	}

	@Test
	public void testSumTriplets() {
		assertEquals(this.expected, SumTriplet.findSumTriplet(input));
	}
}
