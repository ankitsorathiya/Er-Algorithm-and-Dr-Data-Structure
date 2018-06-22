package com.engineeralgorithmanddrdatastructure.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class MagicNumber {
    public static void main(String args[]) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Node> nodes = new ArrayList<>();
        for (int index = 0; index < n; index++) {
            Node node = new Node(index, scanner.nextLong());
            nodes.add(node);
        }
        Collections.sort(nodes, (a, b) -> Long.compare(a.value, b.value));
        long diff = 0;
        for (int index = 0; index < nodes.size(); index++) {
            Node node = nodes.get(index);
            if (node.index == index) {
                diff += node.value;
            } else {
                diff -= node.value;
            }
        }
        System.out.println(diff);

    }
}

class Node {
    int index;
    long value;

    public Node(int index, long value) {
        this.value = value;
        this.index = index;
    }
}
