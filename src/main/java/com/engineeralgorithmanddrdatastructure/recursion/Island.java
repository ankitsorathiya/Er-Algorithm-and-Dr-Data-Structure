package com.engineeralgorithmanddrdatastructure.recursion;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author ankit.sorathiya
 * 
 *         find connected island in ocean.
 * 
 *         Island is said to be connected if adjacent island contains 1
 *         horizontally or vertically but not diagonally
 * 
 *         [[1,1,1,0]
 * 
 *         [0,0,0,1]
 * 
 *         [1,0,0,1]]
 * 
 *         Answer=3
 * 
 *         explanation:
 * 
 *         in first row first three column are connected hence it forms 1 Island
 * 
 *         in second row last column and last row last column forms 1 Island, As
 *         they are connected vertically.
 * 
 *         in last row, first column forms 1 Island hence the answer is 3.
 */
public class Island {

	public static int findConnectedIsland(int[][] ocean) {
		Set<String> seen = new HashSet<>();
		int islandCount = 0;
		for (int row = 0; row < ocean.length; row++) {
			for (int column = 0; column < ocean[row].length; column++) {
				if (ocean[row][column] == 1) {
					String island = row + "" + column;
					if (!seen.contains(island)) {
						islandCount++;
						markConnectedOceans(ocean, row, column, seen);
					}
				}
			}
		}
		return islandCount;
	}

	private static void markConnectedOceans(int[][] ocean, int row, int column, Set<String> seen) {
		if (row < 0 || row >= ocean.length || column < 0 || column >= ocean[row].length) {
			return;
		}
		if (ocean[row][column] == 0) {
			return;
		}
		String island = row + "" + column;
		if (seen.contains(island)) {
			return;
		}
		seen.add(island);
		markConnectedOceans(ocean, row, column + 1, seen);
		markConnectedOceans(ocean, row + 1, column, seen);
		markConnectedOceans(ocean, row, column - 1, seen);
		markConnectedOceans(ocean, row - 1, column, seen);
	}

}
