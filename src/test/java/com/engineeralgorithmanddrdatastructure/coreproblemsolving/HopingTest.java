package com.engineeralgorithmanddrdatastructure.coreproblemsolving;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

public class HopingTest {
	private Hopable hopable;

	@Before
	public void initialize() {
		hopable = new Hopable();
	}

	@Test(expected = NullPointerException.class)
	public void testWithNull() {
		hopable.isHopable(null);
		fail("should trow null pointer exception");
	}

	@Test
	public void testWithInvalidHopes() {
		assertFalse(hopable.isHopable(new int[] { 0, 0 }));
		assertFalse(hopable.isHopable(new int[] { 1, 0 }));
		assertFalse(hopable.isHopable(new int[] { 2, 0, 0 }));
		assertFalse(hopable.isHopable(new int[] { 2, 1, 0 }));
	}

	@Test
	public void testWithValidHopes() {
		assertTrue(hopable.isHopable(new int[] { 1, 1 }));
		assertTrue(hopable.isHopable(new int[] { 4, 0, 0, 0 }));
		assertTrue(hopable.isHopable(new int[] { 2, 0, 6, 0, 0 }));
	}
}
