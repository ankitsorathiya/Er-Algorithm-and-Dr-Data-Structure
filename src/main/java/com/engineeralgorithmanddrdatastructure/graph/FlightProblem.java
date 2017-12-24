package com.engineeralgorithmanddrdatastructure.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

class FlightProblem {
	public static void main(String args[]) throws Exception {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		int wt = scanner.nextInt();
		int tt = scanner.nextInt();
		boolean[][] connectivity = new boolean[n + 1][n + 1];
		int[] path = new int[n + 1];
		int[] minutes = new int[n + 1];
		for (int mIndex = 0; mIndex < m; mIndex++) {
			int u = scanner.nextInt();
			int v = scanner.nextInt();
			connectivity[u][v] = true;
		}
		int source = scanner.nextInt();
		int dest = scanner.nextInt();
		initialize(minutes, source);
		findPath(connectivity, source, dest, path, minutes, wt, tt);
		printResult(minutes, path, source, dest);
	}

	private static void printResult(int[] minutes, int[] path, int source, int dest) {
		int currentNode = path[dest];
		int cities = 1;
		Stack<Integer> stack = new Stack<>();
		stack.push(dest);
		while (currentNode != source) {
			cities++;
			stack.push(currentNode);
			currentNode = path[currentNode];
		}
		stack.push(source);
		cities++;
		System.out.println(cities);
		while (!stack.isEmpty()) {
			System.out.print(stack.pop() + " ");
		}

	}

	private static void initialize(int[] minutes, int source) {
		for (int index = 0; index < minutes.length; index++) {
			if (index == source) {
				minutes[index] = 0;
			} else {
				minutes[index] = -1;
			}
		}
	}

	private static void findPath(boolean[][] connectivity, int source, int dest, int[] path, int[] minutes,
			int waitingTime, int travellingTime) {
		int newWaitingTime = calculateNewWaitingTime(waitingTime, travellingTime);
		int time = newWaitingTime + travellingTime;
		Map<Integer, List<Integer>> memo = new HashMap<>();
		Queue<Integer> queue = new LinkedList<>();
		queue.add(source);
		while (!queue.isEmpty()) {
			int node = queue.poll();
			List<Integer> connectedCities = getConnected(memo, node, connectivity);
			for (int index = 0; index < connectedCities.size(); index++) {
				int other = connectedCities.get(index);
				if (minutes[other] == -1) {
					minutes[other] = time;
					queue.add(other);
					path[other] = node;
				} else if (node != source) {
					int toReachMe = minutes[node] + time;
					if (toReachMe < minutes[other]) {
						minutes[other] = toReachMe;
						path[other] = node;
						queue.add(other);
					}
				}

			}
		}
	}

	private static int calculateNewWaitingTime(int waitingTime, int travellingTime) {
		int newWaitingTime = 0;
		if (waitingTime == travellingTime) {
			newWaitingTime = waitingTime;
		} else if (waitingTime > travellingTime) {
			newWaitingTime = travellingTime - waitingTime;
		} else {
			int mod = travellingTime % waitingTime;
			newWaitingTime = waitingTime - mod;
		}
		return newWaitingTime;
	}

	private static List<Integer> getConnected(Map<Integer, List<Integer>> memo, int node, boolean[][] connectivity) {
		if (memo.containsKey(node)) {
			return memo.get(node);
		}
		List<Integer> connected = new ArrayList<>();
		for (int index = 0; index < connectivity[node].length; index++) {
			if (connectivity[node][index]) {
				connected.add(index);
			}
		}
		memo.put(node, connected);
		return connected;
	}
}
