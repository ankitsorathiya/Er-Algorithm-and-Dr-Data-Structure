package com.engineeralgorithmanddrdatastructure.array;

import java.util.Stack;

public class WaterLevelHistogram {
	public static int findWaterArea(int[] histogram) {
		int waterVolume = 0;
		if (histogram == null || histogram.length <= 0) {
			return waterVolume;
		}

		int[] leftMax = new int[histogram.length];
		int lMax = leftMax[0];
		for (int lMaxIndex = 1; lMaxIndex < histogram.length; lMaxIndex++) {
			if (histogram[lMaxIndex] > lMax) {
				lMax = histogram[lMaxIndex];
			}
			leftMax[lMaxIndex] = lMax;
		}

		int rMax = histogram[histogram.length - 1];
		for (int rMaxIndex = histogram.length - 1; rMaxIndex >= 0; rMaxIndex--) {
			if (histogram[rMaxIndex] > rMax) {
				rMax = histogram[rMaxIndex];
			}
			int minWaterLevel = Math.min(rMax, leftMax[rMaxIndex]);
			if (minWaterLevel >= histogram[rMaxIndex]) {
				waterVolume += minWaterLevel - histogram[rMaxIndex];
			}
		}

		return waterVolume;

	}

	public static int findWaterAreaUsingStack(int[] histogram) {
		int waterLevel = 0;
		if (histogram == null || histogram.length <= 1) {
			return waterLevel;
		}
		Stack<Bar> bars = new Stack<>();
		for (int barIndex = 0; barIndex < histogram.length; barIndex++) {
			if (histogram[barIndex] == 0) {
				continue;
			}
			Bar current = new Bar(barIndex, histogram[barIndex]);
			if (bars.isEmpty()) {
				bars.add(current);
				continue;
			}
			if (current.isSmallerThan(bars.peek())) {
				int diff = current.position - bars.peek().position - 1;
				int minHeight = Math.min(current.height, bars.peek().height);
				waterLevel += minHeight * diff;
				bars.add(current);
				continue;
			}
			Bar mid = null;
			while (!bars.isEmpty() && bars.peek().isSmallerThan(current)) {
				Bar top = bars.pop();
				int diff = current.position - top.position - 1;
				int minHeight = 0;
				if (mid != null) {
					minHeight = top.height - mid.height;
				} else {
					minHeight = Math.min(current.height, top.height);
				}
				waterLevel += minHeight * diff;
				mid = top;
			}
			if (!bars.isEmpty() && mid != null) {
				int minHeight = Math.min(bars.peek().height, current.height);
				minHeight = minHeight - mid.height;
				int diff = current.position - bars.peek().position - 1;
				waterLevel += minHeight * diff;
			}
			bars.add(current);
		}
		return waterLevel;
	}

}

class Bar {
	int position;
	int height;

	public Bar(int position, int height) {
		this.position = position;
		this.height = height;
	}

	boolean isSmallerThan(Bar other) {
		return this.height <= other.height;
	}
}
