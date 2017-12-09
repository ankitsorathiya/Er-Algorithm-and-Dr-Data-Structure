package com.engineeralgorithmanddrdatastructure.combinactory;

/**
 * 
 * @author ankit.sorathiya
 * 
 *         Given n people and k floors where each floor contains infinite rooms
 *         of size floor[i].
 *
 *         find out number of possible unique way to accommodate all the people.
 * 
 *         Given a condition that room either must accommodate given capacity or
 *         be empty
 * 
 *         Example Accommodate 5 people on floor{1,2,3}
 * 
 *         output = 5
 * 
 *         explanation:
 * 
 *         (1,1,1,1,1) on floor 1 accommodate 5 person in 5 rooms
 * 
 *         (1,2,2) on floor 1 accommodate 1 in one room and on floor two use two
 *         rooms to accommodate 4
 * 
 *         (1,1,1,2) on floor 1 use 3 rooms to accommodate three person and use
 *         floor 2 to accommodate two person in one room
 * 
 *         (1,3) on floor 1 use one room to accommodate one person and on floor
 *         3 accommodate three person in one room of size 3
 * 
 *         (2,3) on floor two use one room of size 2 to accommodate two person
 *         and on floor three use one room of size 3 to accommodate three
 *         person.
 * 
 */
public class RoomArrangement {
	static long modSum = 1000000007l;

	public static long findOutPossibleArrangement(int n, int[] floors) {
		long[] result = new long[1];
		for (int index = floors.length - 1; index >= 0; index--) {
			findOutPossibleArrangement(floors, index, n, result);
		}
		return result[0];

	}

	private static void findOutPossibleArrangement(int[] floors, int index, int people, long[] result) {
		for (int currentPeople = floors[index]; currentPeople <= people; currentPeople = currentPeople
				+ floors[index]) {
			int remainingPeople = people - currentPeople;
			for (int newIndex = index - 1; newIndex >= 0; newIndex--) {
				findOutPossibleArrangement(floors, newIndex, remainingPeople, result);
			}
			if (remainingPeople == 0) {
				result[0] = (result[0] + 1) % modSum;
			}
		}
		return;
	}
}
