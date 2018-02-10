package com.engineeralgorithmanddrdatastructure.dp;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class EditDistanceTest {
	private int expected;
	private String source;
	private String target;

	public EditDistanceTest(int expected, String source, String target) {
		super();
		this.expected = expected;
		this.source = source;
		this.target = target;
	}

	@Parameters
	public static Collection<Object[]> getData() {
		return Arrays.asList(new Object[] { 0, null, null }, new Object[] { 0, null, "" }, new Object[] { 0, "", null },
				new Object[] { 0, "", "" }, new Object[] { 3, "sitting", "kitten" },
				new Object[] { 3, "machine learning", "xmachinexlearnigg" },
				new Object[] { 8, "machine gun", "gun machine" });
	}

	@Test
	public void testWordEditDistance() {
		assertEquals(expected, EditDistance.findEditDistance(source, target));
	}
}
