package com.engineeralgorithmanddrdatastructure.array;

import java.util.ArrayList;
import java.util.List;

public class DiagonalNumbers {

	public static List<Integer> getNumbersInDiagonalOrders(int[][] matrix) {
		List<Integer> result = new ArrayList<>();
		if (matrix == null) {
			return result;
		}
		Diagonal diagonal = new Diagonal(0, 0, true);
		int limit = matrix.length * 2 - 1;
		for (int goTill = 0; goTill < limit; goTill++) {
			addNumber(result, diagonal, matrix);
		}
		return result;
	}

	private static void addNumber(List<Integer> result, Diagonal diagonal, int[][] matrix) {
		result.add(matrix[diagonal.row][diagonal.col]);
		if (diagonal.upward) {
			diagonal.row--;
			diagonal.col++;
		} else {
			diagonal.row++;
			diagonal.col--;
		}

		if (diagonal.row >= matrix.length && diagonal.col < 0) {
			diagonal.row = diagonal.row - 1;
			diagonal.col = diagonal.col + 2;
			diagonal.upward = !diagonal.upward;
			return;
		} else if (diagonal.col >= matrix.length && diagonal.row < 0) {
			diagonal.row = diagonal.row + 2;
			diagonal.col = diagonal.col - 1;
			diagonal.upward = !diagonal.upward;
			return;
		} else if (diagonal.col >= 0 && diagonal.col < matrix.length) {
			if (diagonal.row < 0) {
				diagonal.row = diagonal.row + 1;
				diagonal.upward = !diagonal.upward;
				return;
			} else if (diagonal.row >= matrix.length) {
				diagonal.row = diagonal.row - 1;
				diagonal.col = diagonal.col + 2;
				diagonal.upward = !diagonal.upward;
				return;
			}
		} else if (diagonal.row >= 0 && diagonal.row < matrix.length) {
			if (diagonal.col < 0) {
				diagonal.col = diagonal.col + 1;
				diagonal.upward = !diagonal.upward;
				return;
			} else if (diagonal.col >= matrix.length) {
				diagonal.col = diagonal.col - 1;
				diagonal.row = diagonal.row + 2;
				diagonal.upward = !diagonal.upward;
				return;
			}
		}
		addNumber(result, diagonal, matrix);
	}

}

class Diagonal {
	int row;
	int col;
	boolean upward;

	public Diagonal(int row, int col, boolean upward) {
		this.row = row;
		this.col = col;
		this.upward = upward;
	}

}
