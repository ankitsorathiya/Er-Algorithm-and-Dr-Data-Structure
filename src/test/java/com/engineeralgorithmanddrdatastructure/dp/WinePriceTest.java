package com.engineeralgorithmanddrdatastructure.dp;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class WinePriceTest {
	@Test
	public void testWinePrice() {
		assertEquals(50, WinePrice.findMaxWinePriceWithYear(new int[] { 2, 3, 5, 1, 4 }));
		assertEquals(47, WinePrice.findMaxWinePriceWithYear(new int[] { 2, 6, 1, 1, 4 }));
	}
}
