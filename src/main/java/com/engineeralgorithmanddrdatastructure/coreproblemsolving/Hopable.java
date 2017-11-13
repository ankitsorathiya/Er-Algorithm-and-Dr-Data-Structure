package com.engineeralgorithmanddrdatastructure.coreproblemsolving;

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
