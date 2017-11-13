package com.engineeralgorithmanddrdatastructure.coreproblemsolving;

import java.util.ArrayList;
import java.util.List;

/**
 * Let's assume you are getting married and you want invite your friends for the dinner party.
 * While at dinner party table has fixed size of N and you are not sure who all of your friends should sit together.
 * Given list of friends find out combination of N of table size.
 *  example 1.
 *  Friends => [1,2,3,4,5]  and Table size=> 5
 *  output=>[[1,2,3,4,5]] 
 *  example 2.
 *  Friends => [1,2,3,4] and Table size=> 3
 *  output =>[[1,2,3],[1,2,4],[1,3,4],[2,3,4]]
 */
/**
 * 
 * @author ankit.sorathiya
 *
 */
public class DinnerParty {
	public List<Table> getFriendsOnTable(int[] friends, int want) {
		List<Table> tables = new ArrayList<>();
		Table table = new Table();
		this.makeSittingArrangementForFriendsOnTable(friends, want, 0, table, tables);
		return tables;
	}

	private void makeSittingArrangementForFriendsOnTable(int[] friends, int want, int currentFriend, Table table,
			List<Table> tables) {
		if (table.getTableSize() == want) {
			tables.add(table);
			return;
		}
		if (currentFriend >= friends.length) {
			return;
		}
		for (int index = currentFriend; index < friends.length; index++) {
			int friend = friends[index];
			Table newTable = table.clone();
			newTable.addFriend(friend);
			makeSittingArrangementForFriendsOnTable(friends, want, index + 1, newTable, tables);
		}
	}
}

class Table implements Cloneable {
	private List<Integer> friends = new ArrayList<>();

	public void addFriend(int friend) {
		this.friends.add(friend);
	}

	public int getTableSize() {
		return friends.size();
	}

	@Override
	protected Table clone() {
		Table clonedTable = new Table();
		List<Integer> clonedFriends = new ArrayList<>();
		clonedFriends.addAll(this.friends);
		clonedTable.friends = clonedFriends;
		return clonedTable;
	}

	@Override
	public String toString() {
		return this.friends.toString();
	}
}