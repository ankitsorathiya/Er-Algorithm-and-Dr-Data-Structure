package com.engineeralgorithmanddrdatastructure.npproblems.sat;

/**
 * 
 * @author ankit.sorathiya
 *
 *         Given variables and their assigned values find out whether given
 *         expression satisfies to true or not?
 * 
 *         expression is conjunction of clauses
 * 
 *         eg. clauses[0] && clauses[1]..... &&clauses[n-1]
 * 
 *         each variable is assigned initial values which could either be true
 *         of false.
 * 
 *         Expression: { { 1, 2, -3 }, { -1, 2, -3 } }
 * 
 *         Assignment : { false,true, false, false }, 0th index is fake since we
 *         can not represent -0:)
 * 
 *         output=> true
 * 
 *         Explanation:
 * 
 *         first clause can be true using 1 or -3 hence result into true
 * 
 * 
 *         second clause can be true using -3 hence result into true
 * 
 *         since both clauses return true and the expression is conjunction of
 *         clauses it returns true. If any of the clause returns false your
 *         expression can never satisfy.
 * 
 * 
 */
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
