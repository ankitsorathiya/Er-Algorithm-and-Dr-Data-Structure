package com.engineeralgorithmanddrdatastructure.ds.heap;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class LazyBartender {
	public static int findMinimumDrinks(int[][] customersFavoriteDrinks) {
		if (customersFavoriteDrinks == null || customersFavoriteDrinks.length == 0) {
			return -1;
		}
		Map<Integer, Set<Integer>> drinkToCustomers = buildMapping(customersFavoriteDrinks);
		Queue<Set<Integer>> maxHeap = new PriorityQueue<>((drinkA, drinkB) -> {
			if (drinkA.size() > drinkB.size()) {
				return -1;
			} else if (drinkA.size() < drinkB.size()) {
				return 1;
			} else {
				return 0;
			}
		});
		maxHeap.addAll(drinkToCustomers.values());
		int minRequiredDrinks = 0;
		Set<Integer> servedDrinksTo = new HashSet<>();
		while (servedDrinksTo.size() != customersFavoriteDrinks.length && !maxHeap.isEmpty()) {
			Set<Integer> customerServed = maxHeap.poll();
			servedDrinksTo.addAll(customerServed);
			for (Set<Integer> customers : maxHeap) {
				customers.removeAll(customerServed);
			}
			minRequiredDrinks++;
		}
		return minRequiredDrinks;
	}

	private static Map<Integer, Set<Integer>> buildMapping(int[][] customersFavoriteDrinks) {
		Map<Integer, Set<Integer>> customersFavorite = new HashMap<>();
		for (int customer = 0; customer < customersFavoriteDrinks.length; customer++) {
			for (int drink = 0; drink < customersFavoriteDrinks[customer].length; drink++) {
				int myFavoriteDrink = customersFavoriteDrinks[customer][drink];
				if (customersFavorite.containsKey(myFavoriteDrink)) {
					customersFavorite.get(myFavoriteDrink).add(customer);
				} else {
					Set<Integer> customersWhoLikeMe = new HashSet<>();
					customersWhoLikeMe.add(customer);
					customersFavorite.put(myFavoriteDrink, customersWhoLikeMe);
				}
			}
		}
		return customersFavorite;
	}
}
