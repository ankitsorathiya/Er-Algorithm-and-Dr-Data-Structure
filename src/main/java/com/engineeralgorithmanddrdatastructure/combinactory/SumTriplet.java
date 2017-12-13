package com.engineeralgorithmanddrdatastructure.combinactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author ankit.sorathiya
 * 
 * 
 *         Given integer array, find a+b=c pairs.
 */
public class SumTriplet {
	public static List<Triplet> findSumTriplet(int[] input) {
		List<Triplet> triplets = new ArrayList<>();
		Map<Integer, List<Pair>> sumPairs = constrctPairs(input);
		for (int cIndex = 0; cIndex < input.length; cIndex++) {
			if (sumPairs.containsKey(input[cIndex])) {
				for (Pair pair : sumPairs.get(input[cIndex])) {
					triplets.add(new Triplet(pair.getA(), pair.getB(), input[cIndex]));
				}
			}
		}
		return triplets;

	}

	private static Map<Integer, List<Pair>> constrctPairs(int[] input) {
		Map<Integer, List<Pair>> result = new HashMap<>();
		for (int aIndex = 0; aIndex < input.length - 1; aIndex++) {
			for (int bIndex = aIndex + 1; bIndex < input.length; bIndex++) {
				int sum = input[aIndex] + input[bIndex];
				Pair pair = new Pair(input[aIndex], input[bIndex]);
				if (result.containsKey(sum)) {
					result.get(sum).add(pair);
				} else {
					List<Pair> pairs = new ArrayList<>();
					pairs.add(pair);
					result.put(sum, pairs);
				}
			}
		}
		return result;
	}
}

class Triplet {
	private final int a;
	private final int b;
	private final int c;

	public Triplet(int a, int b, int c) {
		super();
		this.a = a;
		this.b = b;
		this.c = c;
	}

	public int getA() {
		return a;
	}

	public int getB() {
		return b;
	}

	public int getC() {
		return c;
	}

	@Override
	public String toString() {
		return "Triplet [a=" + a + ", b=" + b + ", c=" + c + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + a;
		result = prime * result + b;
		result = prime * result + c;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Triplet other = (Triplet) obj;
		if (a != other.a)
			return false;
		if (b != other.b)
			return false;
		if (c != other.c)
			return false;
		return true;
	}

}

class Pair {
	private final int a;
	private final int b;

	public Pair(int a, int b) {
		super();
		this.a = a;
		this.b = b;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + a;
		result = prime * result + b;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pair other = (Pair) obj;
		if (a != other.a)
			return false;
		if (b != other.b)
			return false;
		return true;
	}

	public int getA() {
		return a;
	}

	public int getB() {
		return b;
	}

	@Override
	public String toString() {
		return "Pair [a=" + a + ", b=" + b + "]";
	}

}
