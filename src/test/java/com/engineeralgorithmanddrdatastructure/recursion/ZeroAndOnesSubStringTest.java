package com.engineeralgorithmanddrdatastructure.recursion;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ZeroAndOnesSubStringTest {
	@Test
	public void testConsicutiveSubString() {
		assertEquals(6, ZerosAndOnesSubString.findConsecutiveCounting("10101"));
		assertEquals(3, ZerosAndOnesSubString.findConsecutiveCounting("00110"));
		assertEquals(5, ZerosAndOnesSubString.findConsecutiveCounting("00011101"));
	}
}
