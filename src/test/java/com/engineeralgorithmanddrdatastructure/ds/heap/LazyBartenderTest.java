package com.engineeralgorithmanddrdatastructure.ds.heap;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class LazyBartenderTest {
	private int expected;
	private int[][] customersFavoriteDrinks;

	public LazyBartenderTest(int expected, int[][] customersFavoriteDrinks) {
		super();
		this.expected = expected;
		this.customersFavoriteDrinks = customersFavoriteDrinks;
	}

	@Parameters
	public static Collection<Object[]> getData() {
		return Arrays.asList(new Object[][] { { 3, new int[][] { { 1, 2, 3, 5 }, { 3, 6 }, { 2, 4 }, { 5, 7 } } },
				{ 2, new int[][] { { 1, 2, 3, 5 }, { 1, 2, 3, 4, 5 }, { 2, 4 }, { 5, 7 } } }, { -1, null },
				{ 1, new int[][] { { 1, 2, 3, 5 }, { 1, 2, 3, 4, 5 } } },
				{ 5, new int[][] { { 1 }, { 2 }, { 3 }, { 4 }, { 5 } } } });

	}

	@Test
	public void testLazyBartenderDrinks() {
		assertEquals(expected, LazyBartender.findMinimumDrinks(customersFavoriteDrinks));
	}
}
