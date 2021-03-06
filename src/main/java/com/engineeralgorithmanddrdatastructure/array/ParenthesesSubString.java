package com.engineeralgorithmanddrdatastructure.array;

import java.util.ArrayList;
import java.util.List;

/**
 *  find longest valid parentheses substring
 */
public class ParenthesesSubString {
    public static void main(String[] args) throws Exception {
        ParenthesesSubString parenthsesSubString = new ParenthesesSubString();
        System.out.println(parenthsesSubString.findLongestValidParenthesesString("(((())))((()))"));//14
    }

    public int findLongestValidParenthesesString(String input) {
        char opening = '(';
        char closing = ')';
        List<Parentheses> invalidValues = new ArrayList<>();
        for (int index = 0; index < input.length(); index++) {
            if (input.charAt(index) == opening) {
                Parentheses parentheses = new Parentheses(input.charAt(index), index);
                invalidValues.add(parentheses);
            } else if (!invalidValues.isEmpty() && input.charAt(index) == closing) {
                Parentheses parentheses = invalidValues.get(invalidValues.size() - 1);
                if (parentheses.value == opening) {
                    invalidValues.remove(invalidValues.size() - 1);
                } else {
                    Parentheses currentParentheses = new Parentheses(input.charAt(index), index);
                    invalidValues.add(currentParentheses);
                }
            } else {
                Parentheses currentParentheses = new Parentheses(input.charAt(index), index);
                invalidValues.add(currentParentheses);
            }
        }
        return findMaxLength(input, invalidValues);
    }

    public int findMaxLength(String input, List<Parentheses> invalidParentheses) {
        if (invalidParentheses.isEmpty()) {
            return input.length();
        }
        if (invalidParentheses.size() == 1) {
            Parentheses parentheses = invalidParentheses.get(0);
            return Math.max(parentheses.index, input.length() - (parentheses.index + 1));
        }
        Parentheses lastParentheses = invalidParentheses.get(invalidParentheses.size() - 1);
        Parentheses firstParentheses = invalidParentheses.get(0);
        int max = Math.max(firstParentheses.index, input.length() - (lastParentheses.index + 1));
        for (int index = invalidParentheses.size() - 2; index >= 0; index--) {
            Parentheses current = invalidParentheses.get(index);
            Parentheses previous = invalidParentheses.get(index + 1);
            max = Math.max(max, current.index - previous.index);
        }
        return max;
    }
}

class Parentheses {
    char value;
    int index;

    Parentheses(char value, int index) {
        this.value = value;
        this.index = index;
    }
}
