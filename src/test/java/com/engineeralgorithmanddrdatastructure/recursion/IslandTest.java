package com.engineeralgorithmanddrdatastructure.recursion;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class IslandTest {
	private int[][] ocean;
	private int expected;

	public IslandTest(int[][] ocean, int expectedResult) {
		this.ocean = ocean;
		this.expected = expectedResult;
	}

	@Parameters
	public static Collection<Object[]> getData() {
		return Arrays.asList(new Object[][] { { new int[][] { { 0, 0, 0, 0 }, { 0, 1, 1, 1 }, { 0, 1, 0, 0 } }, 1 },
				{ new int[][] { { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 } }, 0 },
				{ new int[][] { { 1, 0, 0, 0 }, { 0, 1, 0, 0 }, { 0, 0, 0, 1 } }, 3 },
				{ new int[][] { { 1, 1, 1, 0 }, { 0, 1, 0, 0 }, { 0, 0, 0, 1 } }, 2 },
				{ new int[][] { { 1, 1, 1, 1 }, { 1, 1, 1, 1 }, { 1, 1, 1, 1 } }, 1 },
				{ new int[][] { { 1 }, { 0, 0, 0, 1 }, { 0, 0, 1, 0 } }, 3 } });
	}

	@Test
	public void testConnectedIsland() {
		assertEquals(expected, Island.findConnectedIsland(ocean));
	}
}
