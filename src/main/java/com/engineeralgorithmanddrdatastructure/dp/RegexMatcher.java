package com.engineeralgorithmanddrdatastructure.dp;

public class RegexMatcher {
	public static boolean doesMatch(String regex, String input) {
		if (input == null && regex == null) {
			return true;
		}
		if (input == null || regex == null) {
			return false;
		}
		boolean[][] pathMemo = new boolean[regex.length()][input.length()];
		boolean[][] seen = new boolean[regex.length()][input.length()];
		fillPathMemo(pathMemo);
		return doesStringMatchPattern(pathMemo, seen, regex, input, 0, 0);
	}

	private static void fillPathMemo(boolean[][] pathMemo) {
		for (int row = 0; row < pathMemo.length; row++) {
			for (int col = 0; col < pathMemo[row].length; col++) {
				pathMemo[row][col] = true;
			}
		}
	}

	private static boolean doesStringMatchPattern(boolean[][] pathMemo, boolean[][] seen, String regex, String input,
			int regexPointer, int inputPointer) {
		if (regexPointer < 0) {
			return false;
		}
		if (regexPointer == regex.length() && inputPointer == input.length()) {
			return true;
		}
		if (regexPointer >= regex.length() || inputPointer >= input.length()) {
			return false;
		}
		if (!pathMemo[regexPointer][inputPointer]) {
			return false;
		}
		if (seen[regexPointer][inputPointer]) {
			return false;
		}
		seen[regexPointer][inputPointer] = true;
		boolean matched = false;
		if (regex.charAt(regexPointer) == '_' || regex.charAt(regexPointer) == '*'
				|| regex.charAt(regexPointer) == input.charAt(inputPointer)) {
			// go diagonal
			matched = doesStringMatchPattern(pathMemo, seen, regex, input, regexPointer + 1, inputPointer + 1);
			if (!matched && regex.charAt(regexPointer) == '*') {
				// go down
				matched = doesStringMatchPattern(pathMemo, seen, regex, input, regexPointer + 1, inputPointer);
				if (!matched) {
					// go right
					matched = doesStringMatchPattern(pathMemo, seen, regex, input, regexPointer, inputPointer + 1);
				}
			}

		} else {
			matched = doesStringMatchPattern(pathMemo, seen, regex, input, regexPointer - 1, inputPointer);
		}
		pathMemo[regexPointer][inputPointer] = matched;
		return matched;
	}

}
