package com.engineeralgorithmanddrdatastructure.recursion;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.engineeralgorithmanddrdatastructure.search.RoundTableProblem;

public class RoundTableProblemTest {
	@Test
	public void testWithSmallInput() {
		List<Integer> actual = RoundTableProblem.findMeetingPointForTwoUniversities(
				new int[] { 7, 1, 4, 3, 1, 6, 4, 2, 5, 1 }, new int[][] { { 7, 1 }, { 1, 1 }, { 7, 6 } });
		List<Integer> expected = new ArrayList<>();
		expected.add(0);
		expected.add(1);
		expected.add(2);
		assertEquals(expected, actual);
	}

	@Test
	public void testWithBigInput() {
		List<Integer> actual = RoundTableProblem.findMeetingPointForTwoUniversities(
				new int[] { 0, 0, 0, 1, 1, 5, 9, 8, 7, 1, 4, 3, 1, 6, 4, 2, 5, 1 },
				new int[][] { { 8, 1 }, { 7, 1 }, { 0, 0 }, { 9, 1 }, { 8, 4 }, { 0, 2 } });
		List<Integer> expected = new ArrayList<>();
		expected.add(1);
		expected.add(0);
		expected.add(0);
		expected.add(1);
		expected.add(1);
		expected.add(1);
		assertEquals(expected, actual);
	}
}
