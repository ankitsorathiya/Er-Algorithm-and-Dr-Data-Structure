package com.engineeralgorithmanddrdatastructure.search;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class Max1ConnectedStringTest {
	@Test
	public void testWithSmallInput() {
		List<Integer> actual = Max1ConnectedString.executeFindMaxQueries(new char[] { '0', '0', '0' },
				new String[] { "1", "2 1", "1", "2 3", "1", "2 2", "1" });
		List<Integer> expected = new ArrayList<>();
		expected.add(0);
		expected.add(1);
		expected.add(1);
		expected.add(3);
		assertEquals(expected, actual);
	}

	@Test
	public void testWithBigInput() {
		List<Integer> actual = Max1ConnectedString.executeFindMaxQueries(new char[] { '0', '0', '0', '0', '1', '1' },
				new String[] { "1", "2 1", "1", "2 3", "1", "2 2", "1", "2 5", "1", "2 4", "1" });
		List<Integer> expected = new ArrayList<>();
		expected.add(2);
		expected.add(2);
		expected.add(2);
		expected.add(3);
		expected.add(3);
		expected.add(6);
		assertEquals(expected, actual);
	}
}
