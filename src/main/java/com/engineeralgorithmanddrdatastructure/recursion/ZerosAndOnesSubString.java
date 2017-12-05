package com.engineeralgorithmanddrdatastructure.recursion;

import java.util.HashSet;
import java.util.Set;

/**
 * Given string with 0's and 1's find out how many consecutive substring exists.
 * Rules:
 * 
 * 1. substring should have equal numbers of 0's and 1's and that too be
 * consecutive. 10,01,0011,0101,1100,1010,0101,00110011 are valid substrings
 * 
 * 2. It must have equal numbers of consecutive 0's and 1's
 * 
 * 
 * Valid substrings = > 0011,0101
 * 
 * Invalid substrings= > 110011, 101001, although they are having equal numbers
 * of zeros and ones but doesn't follow the same pattern like above.
 * 
 * 
 * 
 * Eg1. 00011101 result=> 5
 * 
 * 1.000111
 * 
 * 2.0011
 *
 * 3.01
 * 
 * 4.10
 * 
 * 5.01
 * 
 * 
 * Eg2. 10101 =>6
 * 
 * 1.10
 * 
 * 2.1010
 *
 * 3.0101
 * 
 * 4.01
 * 
 * 5.10
 * 
 * 6.01
 * 
 * @author ankit.sorathiya
 *
 */
public class ZerosAndOnesSubString {

	public static int findConsecutiveCounting(String s) {
		Set<Character> lookingFor = new HashSet<>();
		int[] result = new int[1];
		for (int index = 0; index < s.length(); index++) {
			lookingFor.clear();
			lookingFor.add('0');
			lookingFor.add('1');
			String foundPattern = findFirstConsecutivePattern(s, index, index, result, 0, 0, lookingFor);
			matchMorePatterns(s, result, index, foundPattern);
		}
		return result[0];
	}

	private static void matchMorePatterns(String s, int[] result, int currentStartIndex, String pattern) {
		if (pattern == null) {
			return;
		}
		int currentPatternCount = 1;
		int lookFrom = currentStartIndex + pattern.length();
		int resultedIndex = s.indexOf(pattern, lookFrom);
		if (resultedIndex == lookFrom) {
			currentPatternCount++;
		}
		if (currentPatternCount > 1) {
			result[0] += 2;
		} else {
			result[0] += currentPatternCount;
		}
	}

	private static String findFirstConsecutivePattern(String s, int startIndex, int index, int[] result, int zeroCount,
			int oneCount, Set<Character> lookingFor) {
		if (index >= s.length()) {
			return null;
		}
		char current = s.charAt(index);
		if (!lookingFor.contains(current)) {
			return null;
		}
		if (current == '0') {
			zeroCount++;
			lookingFor.clear();
			lookingFor.add('0');
			if (oneCount <= zeroCount) {
				lookingFor.add('1');
			}
		} else if (current == '1') {
			oneCount++;
			lookingFor.add('1');
			if (oneCount >= zeroCount) {
				lookingFor.add('0');
			}
		}
		if (zeroCount == oneCount) {
			return s.substring(startIndex, index + 1);
		}
		return findFirstConsecutivePattern(s, startIndex, index + 1, result, zeroCount, oneCount, lookingFor);
	}

}
