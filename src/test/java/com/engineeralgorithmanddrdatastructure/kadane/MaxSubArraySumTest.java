package com.engineeralgorithmanddrdatastructure.kadane;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MaxSubArraySumTest {
	@Test
	public void testMaxSubArraySum() {
		assertEquals(0, MaxSubArraySum.calculateMaxSumSubArray(null));
		assertEquals(0, MaxSubArraySum.calculateMaxSumSubArray(new int[] {}));
		assertEquals(25, MaxSubArraySum.calculateMaxSumSubArray(new int[] { 10, -5, 20 }));
		assertEquals(0, MaxSubArraySum.calculateMaxSumSubArray(new int[] { -5, -5, 0 }));
		assertEquals(-5, MaxSubArraySum.calculateMaxSumSubArray(new int[] { -10, -5, -20 }));
	}

}
