package com.engineeralgorithmanddrdatastructure.string;

import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// input: ab[cd[e]3]2fg @ i=7 (0-based)
// repr:  abcdeeecdeeefg
//        01234567890123
// return the i-th character in the expansion. 'c'
public class ExpressionResolution {
    public static void main(String[] args) {
        String resolveSubOptimal = new ExpressionResolution().resolveOptimal("ab[a[b[c]2]2]2de");
        Assert.assertEquals("ababccbccabccbccde", resolveSubOptimal);
    }

    public String resolveSubOptimal(String input) {
        Stack<Character> list = new Stack<>();
        for (int index = 0; index < input.length(); index++) {
            if (input.charAt(index) == ']') {
                StringBuilder subResult = new StringBuilder();
                Character popped = list.pop();
                while (popped != '[') {
                    subResult.append(popped);//
                    popped = list.pop();
                }
                char number = input.charAt(index + 1);
                int intValue = Integer.parseInt(number + "");
                subResult = subResult.reverse();
                StringBuilder allSubStrings = new StringBuilder();
                for (int time = 0; time < intValue; time++) {
                    allSubStrings.append(subResult);
                }
                for (int lIndex = 0; lIndex < allSubStrings.length(); lIndex++) {
                    list.add(allSubStrings.charAt(lIndex));
                }
                index = index + 1;//skip the number
            } else {
                list.add(input.charAt(index));
            }

        }
        StringBuilder result = new StringBuilder();
        for (Character character : list) {
            result.append(character);
        }
        return result.toString();
    }

    public String resolveOptimal(String input) {
        Stack<String> stack = new Stack<>();
        StringBuilder subString = new StringBuilder();
        for (int index = 0; index < input.length(); index++) {
            if (input.charAt(index) == '[') {
                String chunk = subString.toString();
                if (chunk.length() > 0) {
                    stack.push(chunk);
                    subString = new StringBuilder();
                }
                stack.push("[");
            } else if (input.charAt(index) == ']') {
                if (subString.length() > 0) {
                    stack.push(subString.toString());
                    subString = new StringBuilder();
                }
                String popped = stack.pop();
                StringBuilder res = multiply(input, index, popped);
                List<String> subResult = new ArrayList<>();
                subResult.add(res.toString());
                popped = stack.isEmpty() ? null : stack.pop();
                if (popped.equalsIgnoreCase("[")) {
                    popped = stack.isEmpty() ? null : stack.pop();
                }
                if (popped != null) {
                    subResult.add(popped);
                }
                res = new StringBuilder();
                for (int listIndex = subResult.size() - 1; listIndex >= 0; listIndex--) {
                    res.append(subResult.get(listIndex));
                }
                stack.push(res.toString());
                index = index + 1;
            } else {
                subString.append(input.charAt(index));
            }
        }
        String result = "";
        while (!stack.isEmpty()) {
            String res = stack.pop();
            result = res + result;
        }
        if (subString.length() > 0) {
            return result + subString.toString();
        }

        return result;

    }

    private StringBuilder multiply(String input, int index, String popped) {
        char number = input.charAt(index + 1);
        int value = Integer.parseInt(number + "");
        StringBuilder res = new StringBuilder();
        for (int time = 0; time < value; time++) {
            res.append(popped);
        }
        return res;
    }

}
