package com.engineeralgorithmanddrdatastructure.narytree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * For a company meeting, you are tasked with inviting employees such that the total sum of ratings of employees invited is maximum. You have only one constraint - You cannot invite immediate/direct manager or immediate/direct subordinates of an invited employee. Please return the total sum of ratings of the invited employees
 * <p>
 * Input: provided for ease of understanding as a tree structure below
 * (For the below example, all the employees have the same rating value of 1.)
 * <p>
 * A
 * B  C  D E
 * F            G  H
 * I     J              K L M N O
 * P Q   R S
 * <p>
 * Output:13
 * A sample invite list would look like this [B,C,D,E,  K,L,M,N,O,  P,Q,R,S]
 */
public class EmployeeMeetingMaxRattingProblem {
    //not working, going to fix later
    public static void main(String[] args) {
        Employee p = new Employee("P", new ArrayList<>(), 1);
        Employee q = new Employee("Q", new ArrayList<>(), 1);
        Employee r = new Employee("R", new ArrayList<>(), 1);
        Employee s = new Employee("S", new ArrayList<>(), 1);
        Employee k = new Employee("K", new ArrayList<>(), 1);
        Employee l = new Employee("L", new ArrayList<>(), 1);
        Employee m = new Employee("M", new ArrayList<>(), 1);
        Employee n = new Employee("N", new ArrayList<>(), 1);
        Employee o = new Employee("O", new ArrayList<>(), 1);
        Employee i = new Employee("I", Arrays.asList(p, q), 1);
        Employee j = new Employee("J", Arrays.asList(r, s), 1);
        Employee f = new Employee("F", Arrays.asList(i, j), 1);
        Employee g = new Employee("G", new ArrayList<>(), 1);
        Employee h = new Employee("H", Arrays.asList(k, l, m, n, o), 1);
        Employee b = new Employee("B", Arrays.asList(f), 1);
        Employee c = new Employee("C", new ArrayList<>(), 1);
        Employee d = new Employee("D", new ArrayList<>(), 1);
        Employee e = new Employee("E", Arrays.asList(g, h), 1);
        Employee a = new Employee("A", Arrays.asList(b, c, d, e), 1);
        EmployeeMeetingMaxRattingProblem employeeMeetingMaxRattingProblem = new EmployeeMeetingMaxRattingProblem();
        int maxRattingSum = employeeMeetingMaxRattingProblem.findMaxRattingSum(a);
        System.out.println(maxRattingSum);
    }

    public int findMaxRattingSum(Employee root) {
        Map<String, Integer[]> memo = new HashMap();
        int sumWithoutMe = findMax(0, root, false, memo);
        int sumWithMe = findMax(root.ratting, root, true, memo);
        System.out.println(sumWithMe);
        System.out.println(sumWithoutMe);
        return Math.max(sumWithoutMe, sumWithMe);
    }

    private int findMax(int totalSum, Employee root, boolean parentTaken, Map<String, Integer[]> memo) {
        if (memo.containsKey(root.name)) {
            if (parentTaken) {
                return memo.get(root.name)[0];
            } else {
                return memo.get(root.name)[1];
            }
        }
        int maxSumWithoutMe = 0;
        int maxSumWithMe = root.ratting;

        for (Employee current : root.subordinates) {
            maxSumWithoutMe += findMax(totalSum, current, false, memo);
            maxSumWithMe += findMax(maxSumWithMe + current.ratting, current, true, memo);
        }
        memo.put(root.name, new Integer[]{maxSumWithoutMe, maxSumWithMe});
        return parentTaken ? maxSumWithoutMe : maxSumWithMe;
    }

}
