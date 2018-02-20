package com.engineeralgorithmanddrdatastructure.dp;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class KingdomDivision {
	private static int mod = 1000000007;

	@SuppressWarnings("unchecked")
	private static void findWays(boolean[][] adjacency, int node, HashSet<Integer> B, HashSet<Integer> R, int[] ways) {
		if (B.size() + R.size() == adjacency.length) {
			boolean bPeaceful = connected(adjacency, B);
			boolean rPeaceful = connected(adjacency, R);
			if (bPeaceful && rPeaceful) {
				ways[0] = (ways[0] + 1) % mod;
			}
			return;
		}
		if (node >= adjacency.length) {
			return;
		}

		HashSet<Integer> bCloned = (HashSet<Integer>) B.clone();
		bCloned.add(node);
		findWays(adjacency, node + 1, bCloned, R, ways);
		HashSet<Integer> rCloned = (HashSet<Integer>) R.clone();
		rCloned.add(node);
		findWays(adjacency, node + 1, B, rCloned, ways);

	}

	static int kingdomDivision(int n, int[][] roads) {
		boolean[][] adjacency = new boolean[n][n];
		for (int road = 0; road < roads.length; road++) {
			int u = roads[road][0] - 1;
			int v = roads[road][1] - 1;
			adjacency[u][v] = true;
			adjacency[v][u] = true;
		}
		int[] ways = new int[] { 0 };
		findWays(adjacency, 0, new HashSet<>(), new HashSet<>(), ways);
		return ways[0];
	}

	private static boolean connected(boolean[][] adjacency, Set<Integer> nodes) {
		for (Integer node : nodes) {
			boolean conExists = false;
			for (Integer other : nodes) {
				if (node.equals(other)) {
					continue;
				}
				if (adjacency[node][other] || adjacency[other][node]) {
					conExists = true;
					break;
				}
			}
			if (!conExists) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[][] roads = new int[n - 1][2];
		for (int roads_i = 0; roads_i < n - 1; roads_i++) {
			for (int roads_j = 0; roads_j < 2; roads_j++) {
				roads[roads_i][roads_j] = in.nextInt();
			}
		}
		int result = kingdomDivision(n, roads);
		System.out.println(result);
		in.close();
	}
}
