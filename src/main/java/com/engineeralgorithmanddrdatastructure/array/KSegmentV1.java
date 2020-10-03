package com.engineeralgorithmanddrdatastructure.array;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class KSegmentV1 {
    public static void main(String args[]) throws Exception {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int k = s.nextInt();
        int[] values = new int[n];
        for (int index = 0; index < n; index++) {
            values[index] = s.nextInt();
        }
        System.out.println(findMaxInAllSegments(values, k));
    }

    //max of all segments
    private static String findMaxInAllSegments(int[] values, int k) {
        PriorityQueue<Element> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int index = 0; index < k; index++) {
            pq.add(new Element(index, values[index]));
        }
        StringBuilder out = new StringBuilder();
        out.append(pq.peek().value);
        for (int index = k; index < values.length; index++) {
            while (true) {
                if (pq.peek().index <= index - k) {
                    pq.poll();
                } else {
                    break;
                }
            }

            pq.add(new Element(index, values[index]));
            out.append(" " + pq.peek().value);
        }

        return out.toString();
    }

}

class Element implements Comparable<Element> {
    int value;
    int index;

    Element(int index, int value) {
        this.value = value;
        this.index = index;
    }

    @Override
    public int compareTo(Element other) {
        if (this.value > other.value) {
            return 1;
        }
        if (this.value < other.value) {
            return -1;
        }
        return 0;
    }
}
