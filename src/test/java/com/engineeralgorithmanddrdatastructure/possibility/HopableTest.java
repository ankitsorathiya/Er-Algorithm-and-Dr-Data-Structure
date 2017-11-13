package com.engineeralgorithmanddrdatastructure.possibility;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class HopableTest {
	private Hopable hopable;

	@Before
	public void initialize() {
		this.hopable = new Hopable();
	}

	@Test
	public void testValidJumps() {
		assertTrue(hopable.isHopable(new int[] { 1, 2, 3 }));
		assertTrue(hopable.isHopable(new int[] { 5, 0, 0, 0, 0, 1, 2 }));
		assertTrue(hopable.isHopable(new int[] { 1, 7, 0, 0, 0, 1, 0 }));
		assertTrue(hopable.isHopable(new int[] { 1, 1, 1, 2, 1, 1 }));
		assertTrue(hopable.isHopable(new int[] { 1, 2, 1 }));
	}

	@Test
	public void testInvalidJumps() {
		assertFalse(hopable.isHopable(new int[] { 1, 0, 0 }));
		assertFalse(hopable.isHopable(new int[] { 5, 0, 0, 0, 0, 0, 1 }));
		assertFalse(hopable.isHopable(new int[] { 2, 9, 0, 0, 0, 1, 0, 0, 1, 1, 0, 1, 1, 1, 1, 0 }));
	}

}
