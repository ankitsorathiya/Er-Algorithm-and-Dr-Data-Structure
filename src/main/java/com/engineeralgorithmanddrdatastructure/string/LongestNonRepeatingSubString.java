package com.engineeralgorithmanddrdatastructure.string;

import java.util.HashMap;
import java.util.Map;

public class LongestNonRepeatingSubString {
    public static void main(String[] args) {
        int length = new LongestNonRepeatingSubString().lengthOfLongestSubstring("abba");
        System.out.println(length);
    }

    public int lengthOfLongestSubstring(String s) {
        int longest = 0;
        Map<Character, Integer> memo = new HashMap<>();
        int jIndex = 0;
        for (int index = 0; index < s.length(); index++) {
            if (memo.containsKey(s.charAt(index))) {
                jIndex = Math.max(jIndex, memo.get(s.charAt(index)) + 1);
            }
            memo.put(s.charAt(index), index);
            longest = Math.max(longest, index - jIndex + 1);
        }
        return longest;
    }
}
