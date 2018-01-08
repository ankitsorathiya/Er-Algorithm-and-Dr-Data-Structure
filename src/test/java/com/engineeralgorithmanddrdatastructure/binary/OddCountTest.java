package com.engineeralgorithmanddrdatastructure.binary;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class OddCountTest {
	@Test
	public void testBinaryOddCountSubString() {
		assertEquals(1, OddCount.findOddDecimalSubStringInBinary("1"));
		assertEquals(3, OddCount.findOddDecimalSubStringInBinary("11"));
		assertEquals(3, OddCount.findOddDecimalSubStringInBinary("011"));
		assertEquals(5, OddCount.findOddDecimalSubStringInBinary("110"));
		assertEquals(8, OddCount.findOddDecimalSubStringInBinary("1101"));
		assertEquals(11, OddCount.findOddDecimalSubStringInBinary("11010"));
	}
}
