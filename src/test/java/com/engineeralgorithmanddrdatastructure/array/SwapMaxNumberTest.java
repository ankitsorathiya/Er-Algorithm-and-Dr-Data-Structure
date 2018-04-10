package com.engineeralgorithmanddrdatastructure.array;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SwapMaxNumberTest {

	@Test
	public void testSwapMaxNumber() {
		assertEquals("4321", SwapMaxNumber.findMaxNumber("1234", 6));
		assertEquals("9220", SwapMaxNumber.findMaxNumber("9022", 2));
	}
}
