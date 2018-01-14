package com.engineeralgorithmanddrdatastructure.array;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class WaterLevelHistogramTest {
	@Test
	public void testWaterLevel() {
		assertEquals(0, WaterLevelHistogram.findWaterArea(null));
		assertEquals(0, WaterLevelHistogram.findWaterArea(new int[] {}));
		assertEquals(0, WaterLevelHistogram.findWaterArea(new int[] { 1 }));
		assertEquals(26,
				WaterLevelHistogram.findWaterArea(new int[] { 0, 0, 4, 0, 0, 6, 0, 0, 3, 0, 5, 0, 1, 0, 0, 0 }));
		assertEquals(46, WaterLevelHistogram
				.findWaterArea(new int[] { 0, 0, 4, 0, 0, 6, 0, 0, 3, 0, 8, 0, 2, 0, 5, 2, 0, 3, 0, 0 }));
	}
}
