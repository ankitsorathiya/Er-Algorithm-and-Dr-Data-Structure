package com.engineeralgorithmanddrdatastructure.dp;

public class MinCostPath {
	public static void main(String[] args) {
		int[][] cost = new int[][] { { 1, 1, 1, 1 }, { 2, 2, 2, 1 }, { 1, 1, 1, 1 }, { 3, 3, 3, 1 } };
		System.out.println(findMinCost(cost));
	}
	public static int findMinCost(int[][] cost) {
		int[][] costMatrix = new int[cost.length][cost.length];
		costMatrix[0][0]=cost[0][0];
		for(int row=1;row<cost.length;row++) {
			costMatrix[row][0] = costMatrix[row - 1][0] + cost[row][0];
		}
		for (int col = 1; col < cost.length; col++) {
			costMatrix[0][col] = costMatrix[0][col - 1] + cost[0][col];
		}
		for(int row=1;row<cost.length;row++) {
			for (int col = 1; col < cost.length; col++) {
				costMatrix[row][col] = Math.min(costMatrix[row][col - 1], costMatrix[row - 1][col]) + cost[row][col];
			}
		}
		return costMatrix[cost.length - 1][cost.length - 1];
	}
}
