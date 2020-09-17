package com.engineeralgorithmanddrdatastructure.linkedlist;

import java.util.HashSet;
import java.util.Set;

public class LinkedListIntersectionProblem {
    public static void main(String[] args) {

    }


    //1->2->3->\
    //          4->5
    //      1->/
    //requires O(n)space complexity.
    public Node<Integer> findIntersectingNodeV1(Node<Integer> head1, Node<Integer> head2) {
        Set<Node<Integer>> nodes = addNodes(head1);
        while (head2 != null) {
            if (nodes.contains(head2)) {
                return head2;
            }
            head2 = head2.getNext();
        }
        return null;
    }

    private Set<Node<Integer>> addNodes(Node<Integer> head1) {
        Set<Node<Integer>> nodes = new HashSet<>();
        while (head1 != null) {
            nodes.add(head1);
            head1 = head1.getNext();
        }
        return nodes;
    }
}
