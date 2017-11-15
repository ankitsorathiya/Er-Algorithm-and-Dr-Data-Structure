package com.engineeralgorithmanddrdatastructure.combinactory;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class DinnerPartyTest {
	private DinnerParty dinnerParty;

	@Before
	public void initialize() {
		dinnerParty = new DinnerParty();
	}

	@Test
	public void testWithValidCombinationOf5() {
		List<Table> tables = dinnerParty.getFriendsOnTable(new int[] { 1, 2, 3, 4, 5 }, 5);
		List<Table> result = new ArrayList<>();
		Table table = new Table();
		table.addFriends(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5)));
		result.add(table);
		assertTrue(result.equals(tables));
	}

	@Test
	public void testWithValidCombinationof4() {
		List<Table> tables = dinnerParty.getFriendsOnTable(new int[] { 1, 2, 3, 4, 5 }, 4);
		List<Table> result = new ArrayList<>();

		Table table1 = new Table();
		table1.addFriends(new ArrayList<>(Arrays.asList(1, 2, 3, 4)));
		result.add(table1);

		Table table2 = new Table();
		table2.addFriends(new ArrayList<>(Arrays.asList(1, 2, 3, 5)));
		result.add(table2);

		Table table3 = new Table();
		table3.addFriends(new ArrayList<>(Arrays.asList(1, 2, 4, 5)));
		result.add(table3);

		Table table4 = new Table();
		table4.addFriends(new ArrayList<>(Arrays.asList(1, 3, 4, 5)));
		result.add(table4);

		Table table5 = new Table();
		table5.addFriends(new ArrayList<>(Arrays.asList(2, 3, 4, 5)));
		result.add(table5);
		assertTrue(result.equals(tables));
	}

}
