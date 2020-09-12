/*

A company organizes two foreign trips for its employees yearly. Aim of the trip is to increase interaction among the employees of the company and hence company wants each of his employee to see new people on the trip and not even a single person with whom he has worked in past. Therefore it is a rule in company that in any of the trips, all the employees should be new to each other and no two of them should have worked together in past.†
Given the work history of each employee (which people he has worked with sometimes in past), you have to tell whether all of the employees can be accommodated within trips without violating the above rule or not. Each employee is given a unique integer ID by which they are recognized. You can also assume that each employee has worked with at least one other employee in past.

*/

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TeamCollaborationProblem {

    private static boolean isTeamBuildingPossible(List<Pair<Integer>> workHistory, int numEmployees) {
        Set<Integer> trip1 = new HashSet<>();
        Set<Integer> trip2 = new HashSet<>();
        for (Pair<Integer> pair : workHistory) {
            if (trip1.contains(pair.first) && trip1.contains(pair.second)) {
                return false;
            }
            if (trip2.contains(pair.first) && trip2.contains(pair.second)) {
                return false;
            }

            if (trip1.contains(pair.first)) {
                trip2.add(pair.second);
            } else if (trip1.contains(pair.second)) {
                trip1.add(pair.first);
            } else {
                trip1.add(pair.first);
                trip2.add(pair.second);
            }
        }

        return true;
    }

    private static void checkPass(String testName, boolean resultValue, boolean expectedValue) {
        String result = (resultValue == expectedValue) ? "passed" : "failed";
        System.out.println(String.format("Test %s Result : %s", testName, result));
    }

    public static void main(String[] args) {

        //Test 1
        ArrayList<Pair<Integer>> workHistoryTest1 = new ArrayList<>();
        workHistoryTest1.add(new Pair<Integer>(0, 1));
        workHistoryTest1.add(new Pair<Integer>(1, 2));
        workHistoryTest1.add(new Pair<Integer>(2, 3));
        workHistoryTest1.add(new Pair<Integer>(3, 0));

        checkPass("Test1", isTeamBuildingPossible(workHistoryTest1, 4), true);

        //Test 2
        ArrayList<Pair<Integer>> workHistoryTest2 = new ArrayList<>();
        workHistoryTest2.add(new Pair<Integer>(0, 1));
        workHistoryTest2.add(new Pair<Integer>(1, 2));
        workHistoryTest2.add(new Pair<Integer>(2, 3));
        workHistoryTest2.add(new Pair<Integer>(3, 1));

        checkPass("Test2", isTeamBuildingPossible(workHistoryTest2, 4), false);

    }

    private static class Pair<T> {
        public T first;
        public T second;

        public Pair(T first, T second) {
            this.first = first;
            this.second = second;
        }
    }
}


