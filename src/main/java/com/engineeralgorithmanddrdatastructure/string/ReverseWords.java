package com.engineeralgorithmanddrdatastructure.string;

public class ReverseWords {
    public static void main(String[] args) {
        String the_sky_is_blue = new ReverseWords().reverseWords("the sky is blue");
        System.out.println(the_sky_is_blue);
    }

    public String reverseWords(String s) {
        //1. find non whitespace character as start from the end
        //2. find non whitespace character as end from the start
        //3. go until you find the whitespace and append to the string.
        StringBuilder result = new StringBuilder();
        int end = findStartIndex(s);
        int start = findEndIndex(s);
        while (start <= end) {
            int wordEnd = end;
            //reduce till you find whitespace
            while (end >= start && s.charAt(end) != ' ') {
                end--;
            }
            int wordStart = end < 0 ? 0 : end + 1;
            result.append(" ").append(s, wordStart, wordEnd + 1);
            //skip all the whitespaces
            while (end >= start && s.charAt(end) == ' ') {
                end--;
            }
        }

        return result.length() == 0 ? "" : result.substring(1, result.length());


    }

    private int findStartIndex(String s) {
        int startIndex = s.length() - 1;
        while (s.charAt(startIndex) == ' ') {
            startIndex--;
        }
        return startIndex;
    }

    private int findEndIndex(String s) {
        int endIndex = 0;
        while (s.charAt(endIndex) == ' ') {
            endIndex++;
        }
        return endIndex;
    }
}
