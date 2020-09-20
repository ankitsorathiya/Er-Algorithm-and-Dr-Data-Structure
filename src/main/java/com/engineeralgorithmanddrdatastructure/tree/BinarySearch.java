package com.engineeralgorithmanddrdatastructure.tree;

public class BinarySearch {
    public static void main(String[] args) {
        int[] values = new int[]{0, 1, 2, 50, 100};
        int indexIterative = new BinarySearch().findElementIndexRecursive(values, 0);
        int indexRecursive = new BinarySearch().findElementIndexIterative(values, 0);
        System.out.println(indexIterative == indexRecursive);

    }

    public int findElementIndexIterative(int[] values, int searchValue) {
        if (values == null || values.length == 0) {
            return -1;
        }
        int start = 0;
        int end = values.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (values[mid] > searchValue) {
                end = mid - 1;
            } else if (values[mid] < searchValue) {
                start = mid + 1;
            } else if (values[mid] == searchValue) {
                return mid;
            }
        }
        return -1;
    }

    public int findElementIndexRecursive(int[] values, int searchValue) {
        if (values == null || values.length == 0) {
            return -1;
        }
        return this.findElementIndexRecursive(values, searchValue, 0, values.length - 1);
    }

    private int findElementIndexRecursive(int[] values, int searchValue, int start, int end) {
        if (start >= end) {
            return -1;
        }
        int mid = (start + end) / 2;
        if (searchValue > values[mid]) {
            return findElementIndexRecursive(values, searchValue, mid + 1, end);
        } else if (searchValue < values[mid]) {
            return findElementIndexRecursive(values, searchValue, start, mid - 1);
        }
        return values[mid];


    }


}
