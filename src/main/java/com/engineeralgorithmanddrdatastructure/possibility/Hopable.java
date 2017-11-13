package com.engineeralgorithmanddrdatastructure.possibility;

/**
 * You are given an integer tower[], for each element in tower represents max hops from current position to positive side.
 * You are at 0th position and you need to move out of towers.
 * Find out whether it is possible or not using given towers.
 * example
 *  -
 *  -
 *  -
 *  -     -
 *  - - - -  
 * [5,1,1,2,0,0,0,0]=>false. from first position  you can do 5,4,3,2 or 1. If you take 3 hop you will end up @3 array index and from there you will be stuck to @4 or @5 index and can't go out of the array.
 *    -
 *  - - -
 * [1,2,1]=> true. 
 *  
 */
/**
 * 
 * @author ankit.sorathiya
 *
 */
public class Hopable {
	public boolean isHopable(int[] towers) {
		return this.isHopable(towers, 0);
	}

	private boolean isHopable(int[] towers, int currentTower) {
		if (currentTower >= towers.length) {
			return true;
		}
		boolean valid = false;
		int canMakeHop = towers[currentTower];
		for (int hop = canMakeHop; hop > 0; hop--) {
			int newTowerPosition = currentTower + hop;
			valid = isHopable(towers, newTowerPosition);
			if (valid) {
				break;
			}
		}
		return valid;
	}
}
