package com.engineeralgorithmanddrdatastructure.graph;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TopologicalSortingTest {
	private boolean[][] directedGraph;
	private List<Integer> expected;

	public TopologicalSortingTest(List<Integer> expected, boolean[][] directedGraph) {
		this.directedGraph = new boolean[][] { { false, true, true, true }, { false, false, false, true },
				{ false, false, false, true }, { false, false, false, false } };
		this.expected = expected;
	}

	@Parameters
	public static Collection<Object[]> getData() {
		return Arrays.asList(new Object[][] { { Arrays.asList(0, 1, 2, 3),
				new boolean[][] { { false, true, true, true }, { false, false, false, true },
						{ false, false, false, true }, { false, false, false, false } } } });
	}

	@Test
	public void testBFSTopologicalSorting() {
		assertEquals(expected, TopologicalSorting.sortTopologicallyWithBFS(directedGraph));
	}

	@Test
	public void testDFSTopologicalSorting() {
		assertEquals(expected, TopologicalSorting.sortTopologicallyWithBFS(directedGraph));
	}
}
