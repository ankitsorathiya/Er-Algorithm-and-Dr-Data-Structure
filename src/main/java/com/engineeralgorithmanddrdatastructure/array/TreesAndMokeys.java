package com.engineeralgorithmanddrdatastructure.array;
/**
 * 
 * In a garden, trees are arranged in a circular fashion with an equal distance
 * between two adjacent trees. Height of trees may vary. Two monkeys live in
 * that garden and they were very close to each other. One day they quarreled
 * due to some misunderstanding. None of them were ready to leave the garden.
 * But each one of them want that if the other want to meet him, it should take
 * maximum possible time to reach him, given that they both live in the same
 * garden.
 * 
 * The conditions are that a monkey cannot directly jump from one tree to other.
 * There are n trees in the garden. If the height of a tree is H, a monkey can
 * live at any height from 0 to H. Lets say he lives at the height of K then it
 * would take him K unit of time to climb down to the ground level. Similarly if
 * a monkey wants to climb up to K height it would again take K unit of time.
 * Time to travel between two adjacent tree is 1 unit. A monkey can only travel
 * in circular fashion in the garden because there is a pond at the center of
 * the garden.
 * 
 * So the question is where should two monkeys live such that the traveling time
 * between them is maximum while choosing the shortest path between them in any
 * direction clockwise or anti-clockwise. You have to answer only the maximum
 * traveling time. Input Format You will be given an integer array representing
 * the height of trees in clock wise fashion.
 */
public class TreesAndMokeys {
	public static int findMonkeysMaxUnitDistanceWithShortestPath(int[] treeHeights) {
		if (treeHeights == null) {
			return 0;
		}
		if (treeHeights.length == 1) {
			return treeHeights[0];
		}
		int maxUnits = 0;
		for (int firstM = 0; firstM < treeHeights.length - 1; firstM++) {
			for (int secondM = 1; secondM < treeHeights.length; secondM++) {
				int heightSum = treeHeights[firstM] + treeHeights[secondM];
				int clockWiseDistance = secondM - firstM;
				int antiClockWiseDistance = (firstM - 0) + (treeHeights.length - secondM);
				int minUnits = Math.min(clockWiseDistance, antiClockWiseDistance);
				int reachedInUnits = minUnits + heightSum;
				maxUnits = Math.max(maxUnits, reachedInUnits);
			}
		}
		return maxUnits;
	}
}