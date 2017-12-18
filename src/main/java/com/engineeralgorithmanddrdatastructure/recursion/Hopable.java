package com.engineeralgorithmanddrdatastructure.recursion;

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

	public boolean isHopableLinearSolution(int[] towers) {
		if (towers == null || towers.length == 0) {
			return true;
		}
		if (towers[0] == 0) {
			return false;
		}
		int tower = findFirstPositionFromWhereOneCanJumpOut(towers);
		if (tower == -1) {
			return false;
		}
		int needJumps = canJumpOut(towers, tower);
		return needJumps == 1;
	}

	private int canJumpOut(int[] towers, int tower) {
		int needJumps = 1;
		for (int index = tower - 1; index >= 0; index--) {
			if (towers[index] >= needJumps) {
				needJumps = 1;
			} else {
				needJumps++;
			}
		}
		return needJumps;
	}

	private int findFirstPositionFromWhereOneCanJumpOut(int[] towers) {
		for (int index = 0; index < towers.length; index++) {
			if (towers[index] + index >= towers.length) {
				return index;
			}
		}
		return -1;
	}
}
