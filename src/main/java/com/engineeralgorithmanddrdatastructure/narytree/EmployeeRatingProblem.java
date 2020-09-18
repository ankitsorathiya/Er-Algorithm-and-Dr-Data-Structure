package com.engineeralgorithmanddrdatastructure.narytree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Housekeeping
 * The below problem is a first of its iteration that will need to and should evolve as engineers interview candidates and get feedback from the interview. Feel free to add your comments to the document below as we will continue improving and adding onto the question. Further, the below levels are not limiting and can be extended upon or new levels can be added to the document to get more flavors on a problem.
 * <p>
 * Also, please note that actual executable code is an evaluation criteria but not a necessary one. Interviewers have degrees of subjectivity in evaluating a candidate based on the below provided scoring mechanism and over time, while the degrees might reduce/converge, the idea is to keep room for subjectivity at all times.
 * <p>
 * Employee Performance Rating
 * <p>
 * Company xyz.com has an organizational structure such that each employee in the company can have at most one manager and may have many subordinates.  The company recently conducted their quarterly performance
 * review cycle and each employee has received a performance rating.
 * <p>
 * An example structure is as follows
 * A(5)
 * B(3)	C(2)
 * D(4)      E(10)
 * <p>
 * Where employee A has rating 5 and direct subordinates B, C. Employee B has rating 3 and no direct subordinates. Employee C has rating 2 and two direct subordinates D, E each with rating 4 and 10 respectively. Note that although employee D is also a subordinate of employee A, the relationship is not direct.
 * <p>
 * <p>
 * <p>
 * Now given the employee information of a company,  return the employee whose team has the highest performance rating average. A team is defined as a group consisting of an employee and all their subordinates (not just the direct ones).
 * Example:
 * <p>
 * Input: [[A, 5, [B, C]], [B, 3, []], [C, 2, [D, E]], [D, 4, []], [E, 10, []]
 */

public class EmployeeRatingProblem {
    public static void main(String[] args) {
        Employee d = new Employee("D", new ArrayList<>(), 4);
        Employee e = new Employee("E", new ArrayList<>(), 10);
        Employee c = new Employee("C", Arrays.asList(d, e), 2);
        Employee b = new Employee("B", new ArrayList<>(), 2);
        Employee a = new Employee("A", Arrays.asList(b, c), 5);
        EmployeeRating employeeRating = new EmployeeRatingProblem().findMaxRatting(a);
        System.out.println(employeeRating.averageRatting);
    }

    public EmployeeRating findMaxRatting(Employee head) {
        List<EmployeeRating> memo = new ArrayList<>(1);
        memo.add(null);
        findMaxRatting(head, memo);
        return memo.get(0);
    }

    private EmployeeRating findMaxRatting(Employee head, List<EmployeeRating> memo) {
        if (head == null) {
            return new EmployeeRating(null, 0, 0, 0);
        }

        int ratingSum = head.ratting;
        int noOfSubOrdinates = 1;
        for (Employee subOrdinate : head.subordinates) {
            EmployeeRating childRating = findMaxRatting(subOrdinate, memo);
            ratingSum += childRating.rattingSum;
            noOfSubOrdinates += childRating.noOfSubOrdinates;
        }
        int averageRating = ratingSum / noOfSubOrdinates;
        EmployeeRating employeeRating;
        employeeRating = new EmployeeRating(head.name, averageRating, ratingSum, noOfSubOrdinates);
        if (memo.get(0) == null || employeeRating.averageRatting > memo.get(0).averageRatting) {
            memo.set(0, employeeRating);
        }
        System.out.println("found new");
        System.out.println(employeeRating);
        return employeeRating;
    }

}

class Employee {
    String name;
    List<Employee> subordinates;
    int ratting;

    public Employee(String name, List<Employee> subordinates, int ratting) {
        this.name = name;
        this.subordinates = subordinates;
        this.ratting = ratting;
    }

}

class EmployeeRating {
    String name;
    int averageRatting;
    int rattingSum;
    int noOfSubOrdinates;

    public EmployeeRating(String name, int averageRatting, int rattingSum, int noOfSubOrdinates) {
        this.name = name;
        this.averageRatting = averageRatting;
        this.rattingSum = rattingSum;
        this.noOfSubOrdinates = noOfSubOrdinates;
    }

    @Override
    public String toString() {
        return "EmployeeRating{" +
                "name='" + name + '\'' +
                ", averageRatting=" + averageRatting +
                ", rattingSum=" + rattingSum +
                ", noOfSubOrdinates=" + noOfSubOrdinates +
                '}';
    }
}

