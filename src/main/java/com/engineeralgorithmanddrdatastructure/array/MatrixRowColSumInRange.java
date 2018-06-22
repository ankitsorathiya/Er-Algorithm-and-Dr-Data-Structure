package com.engineeralgorithmanddrdatastructure.array;

import java.util.Arrays;
import java.util.Scanner;

public class MatrixRowColSumInRange {
    public static void main(String args[]) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        long[] cols = new long[m];
        long[] rows = new long[n];
        for (int row = 0; row < n; row++) {
            long rowSum = 0;
            for (int col = 0; col < m; col++) {
                long current = scanner.nextLong();
                cols[col] += current;
                rowSum += current;
            }
            rows[row] = rowSum;
        }
        int q = scanner.nextInt();
        long[][] queries = new long[q][2];
        for (int i = 0; i < q; i++) {
            long l = scanner.nextLong();
            long r = scanner.nextLong();
            queries[i][0] = l;
            queries[i][1] = r;
        }
        Arrays.sort(cols);
        Arrays.sort(rows);
        for (int i = 0; i < q; i++) {
            System.out.print(findSolutions(rows, cols, queries[i][0], queries[i][1]) + " ");
        }
    }

    private static long findSolutions(long[] rows, long[] cols, long l, long r) {
        long result = 0;
        int lIndex = findLeftIndex(rows, l);
        int rIndex = findRightIndex(rows, r);
        if (lIndex >= 0 && rIndex < rows.length) {
            result += (rIndex - lIndex) + 1;
        }

        lIndex = findLeftIndex(cols, l);
        rIndex = findRightIndex(cols, r);
        if (lIndex >= 0 && rIndex < rows.length) {
            result += (rIndex - lIndex) + 1;
        }
        return result;
    }

    private static int findLeftIndex(long[] data, long l) {
        int index = Arrays.binarySearch(data, l);
        if (index >= 0) {
            while (index >= 0) {
                if (data[index] >= l) {
                    index--;
                } else {
                    index++;
                    break;
                }
            }
            return index < 0 ? 0 : index;
        } else {
            index = (-(index) - 1);
            if (index < data.length) {
                return index;
            }
        }
        return -1;
    }

    private static int findRightIndex(long[] data, long r) {
        int index = Arrays.binarySearch(data, r);
        if (index >= 0) {
            while (index < data.length) {
                if (data[index] <= r) {
                    index++;
                } else {
                    index--;
                    break;
                }
            }
            return index >= data.length ? data.length - 1 : index;
        } else {
            index = (-(index) - 1);
            if (index >= data.length) {
                return data.length - 1;
            } else {
                return index - 1;
            }
        }
    }
}
