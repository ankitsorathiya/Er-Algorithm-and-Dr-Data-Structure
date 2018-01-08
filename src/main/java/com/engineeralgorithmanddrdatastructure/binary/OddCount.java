package com.engineeralgorithmanddrdatastructure.binary;

public class OddCount {

	public static int findOddDecimalSubStringInBinary(String binaryString) {
		int oddCount = 0;
		int previousCount = 0;
		for (int pow = 0; pow < binaryString.length(); pow++) {
			int currentCount = 0;
			if (binaryString.charAt(pow) == '1') {
				currentCount = previousCount + 1;
			} else {
				currentCount = previousCount;
			}
			oddCount += currentCount;
			previousCount = currentCount;
		}
		return oddCount;
	}

}
