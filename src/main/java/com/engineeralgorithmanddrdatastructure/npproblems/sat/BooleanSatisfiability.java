package com.engineeralgorithmanddrdatastructure.npproblems.sat;

public class BooleanSatisfiability {
	public static boolean isBooleanExpressionSatisfiable(int[][] clauses, boolean[] variableAssignments) {
		for (int index = 0; index < clauses.length; index++) {
			int[] clause = clauses[index];
			boolean clauseSatisfied = false;
			for (int i = 0; i < clause.length; i++) {
				if (clause[i] > 0) {
					if (variableAssignments[clause[i]]) {
						clauseSatisfied = true;
						break;
					}
				} else {
					if (!variableAssignments[-clause[i]]) {
						clauseSatisfied = true;
						break;
					}
				}
			}
			if (!clauseSatisfied) {
				return false;
			}
		}
		return true;
	}
}
