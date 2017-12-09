package com.engineeralgorithmanddrdatastructure.combinactory;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.engineeralgorithmanddrdatastructure.recursion.RoomArrangement;

public class RoomArrangementTest {
	@Test
	public void testRoomArrangement() {
		assertEquals(5, RoomArrangement.findOutPossibleArrangement(5, new int[] { 1, 2, 3 }));
		assertEquals(8, RoomArrangement.findOutPossibleArrangement(35, new int[] { 15, 10, 5 }));
		assertEquals(7, RoomArrangement.findOutPossibleArrangement(30, new int[] { 15, 10, 5 }));
	}
}
