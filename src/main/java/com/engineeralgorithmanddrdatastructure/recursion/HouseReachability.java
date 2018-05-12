package com.engineeralgorithmanddrdatastructure.recursion;
import java.util.Arrays;
import java.util.Scanner;
/**
 *
 * chandler and villages
 * chandler is living in a village in which houses are arranged in NxM block.
 * The village is denoted by N strings having M characters such that '.' denotes house while '#' denotes forests.
 * chandler has to pay a certain amount LCost, RCost, UCost, DCost to move 1 step across left, right, up or down respectively.
 * chandler lives in a house having co-ordinates (Stx , Sty) (1-Based Indexing).
 * You are given Q tasks contains an integer X each. In each task, you have to find number of unique houses (including his house) can be travelled using the amount X.
 * INPUT
 * First line contains two space separated integers N and M, denoting number of rows and columns respectively.
 * Next N lines contain a string each containing M characters. (Note :- Top left corner will denote {1,1} )
 * Next line contains four space separated integers denoting LCost, RCost, UCost, DCost respectively.
 * Next line contains two space separated integers Stx and Sty, denoting position of chandler's house.
 * Next line contains an integer Q denoting number of tasks.
 * Next Q lines contain an integer X each, denoting the amount chandler have.
 * Output
 * For each task, output a single integer denoting the number of unique houses (including his house) chandler can visit using the amount X.
 * Constraint
 * 1 <= N, M <= 1000
 * 1 <= Stx <= N 
 * 1 <= Sty <= M
 * 1 <= LCost, RCost, UCost, DCost <= 109
 * 1 <= Q <= 105
 * 0  <= X <= 1018 
 *
 *
 * Sample Input
 *
 * 3 4
 * ..#.
 * #...
 * ..#.
 * 1 2 3 4
 * 2 3
 * 3
 * 2
 * 5
 * 10
 * Sample Output
 *
 * 3
 * 7
 * 9
 *
 * Explanation
 * As the starting point is {2, 3}.
 * In first query chandler has 2 units of money. The total number of unique houses that can be visited are (2,3), (2,2), (2,4). Therefore the answer is 3 .
 * Similarly we can check for other 2 queries.
 */

        import java.util.*;
public class HouseReachability {
    private static long leftCost = 0;
    private static long rightCost = 0;
    private static long upCost = 0;
    private static long downCost = 0;

    public static void main(String args[]) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        String[] houses = new String[N];
        for (int row = 0; row < N; row++) {
            houses[row] = scanner.next();
        }
        long[][] cost = new long[N][M];
        leftCost = scanner.nextLong();
        rightCost = scanner.nextLong();
        upCost = scanner.nextLong();
        downCost = scanner.nextLong();
        int chandlerX = scanner.nextInt() - 1;
        int chandlerY = scanner.nextInt() - 1;
        initializeCost(cost);
        cost[chandlerX][chandlerY] = 0l;
        minimizeCost(cost, chandlerX, chandlerY);
        long[] houseReachabilityCost = getHouseRechabilityCost(houses, cost);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            long x = scanner.nextLong();
            System.out.println(findResult(houseReachabilityCost, x));
        }
    }

    private static void minimizeCost(long[][] cost, int row, int col) {
        minimizeCost(cost, row, col + 1, rightCost);
        minimizeCost(cost, row, col - 1, leftCost);
        minimizeCost(cost, row + 1, col, upCost);
        minimizeCost(cost, row - 1, col, downCost);
    }

    private static void minimizeCost(long[][] cost, int row, int col, long currentCost) {
        if (row < 0 || row >= cost.length || col < 0 || col >= cost[row].length) {
            return;
        }
        if (currentCost >= cost[row][col]) {
            return;
        }
        cost[row][col] = currentCost;
        minimizeCost(cost, row, col + 1, currentCost + rightCost);
        minimizeCost(cost, row, col - 1, currentCost + leftCost);
        minimizeCost(cost, row + 1, col, currentCost + upCost);
        minimizeCost(cost, row - 1, col, currentCost + downCost);
    }

    private static long[] getHouseRechabilityCost(String[] houses, long[][] cost) {
        long[] result = new long[houses.length * houses[0].length()];
        int index = -1;
        for (int row = 0; row < houses.length; row++) {
            for (int col = 0; col < houses[row].length(); col++) {
                if (houses[row].charAt(col) == '.') {
                    result[++index] = cost[row][col];
                }
            }
        }
        result=Arrays.copyOfRange(result, 0, index + 1);
        Arrays.sort(result);
        return result;
    }
    private static long findResult(long[] houseReachabilityCost, long x) {
        int index = Arrays.binarySearch(houseReachabilityCost, x);
        if (index >= 0) {
            boolean incremented = false;
            while (index < houseReachabilityCost.length && houseReachabilityCost[index] <= x) {
                index++;
                incremented = true;
            }
            return incremented ? index : index + 1;
        }
        index = -index-1;
        return index;

    }

    private static void initializeCost(long[][] cost) {
        for (int row = 0; row < cost.length; row++) {
            for (int col = 0; col < cost[row].length; col++) {
                cost[row][col] = Long.MAX_VALUE;
            }
        }
    }
}
