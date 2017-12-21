package com.engineeralgorithmanddrdatastructure.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class NodeDistanceProblem {
	public static int findDistanceBetween(TreeNode node1, TreeNode node2, TreeNode root) {
		if (root == null || node1 == null || node2 == null) {
			return 0;
		}

		Map<TreeNode, ArrayList<TreeNode>> path = new HashMap<>();
		findPath(root, node1, node2, new ArrayList<>(), path);
		return findDistance(path.get(node1), path.get(node2));
	}

	private static int findDistance(ArrayList<TreeNode> path1, ArrayList<TreeNode> path2) {
		int pointer = 0;
		while (pointer < path1.size() && pointer < path2.size()) {
			if (path1.get(pointer) != path2.get(pointer)) {
				break;
			}
			pointer++;
		}
		int path1Distance = path1.size() - pointer;
		int path2Distance = path2.size() - pointer;

		return path1Distance + path2Distance;
	}

	@SuppressWarnings("unchecked")
	private static void findPath(TreeNode root, TreeNode node1, TreeNode node2, ArrayList<TreeNode> currentPath,
			Map<TreeNode, ArrayList<TreeNode>> path) {
		if (root == null) {
			return;
		}
		if (path.values().size() == 2) {
			return;
		}
		currentPath.add(root);
		if (root == node1 || root == node2) {
			path.put(root, currentPath);
		}
		findPath(root.getLeft(), node1, node2, (ArrayList<TreeNode>) currentPath.clone(), path);
		findPath(root.getRight(), node1, node2, (ArrayList<TreeNode>) currentPath.clone(), path);

	}

}
