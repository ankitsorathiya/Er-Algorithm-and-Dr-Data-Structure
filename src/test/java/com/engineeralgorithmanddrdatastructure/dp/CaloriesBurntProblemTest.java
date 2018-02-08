package com.engineeralgorithmanddrdatastructure.dp;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class CaloriesBurntProblemTest {
	private int expected;
	private int[][] calories;

	public CaloriesBurntProblemTest(int expected, int[][] calories) {
		this.expected = expected;
		this.calories = calories;
	}

	@Parameters
	public static Collection<Object[]> getData() {
		Collection<Object[]> input = new ArrayList<>();
		input.add(new Object[] { 0, null });
		input.add(new Object[] { 40, new int[][] { { 5, 5, 5 }, { 5, 1, 5 }, { 5, 5, 5 } } });
		input.add(new Object[] { 80, new int[][] { { 5, 5, 5, 5, 5 }, { 5, 5, 5, 1, 5 }, { 5, 5, 5, 5, 5 },
				{ 5, 5, 5, 5, 5 }, { 5, 5, 5, 5, 5 } } });
		return input;
	}

	@Test
	public void caloriesBurnProblemTest() {
		assertEquals(expected, CaloriesBurntProblem.findMaxCaloriesBurnt(calories));
	}
}
