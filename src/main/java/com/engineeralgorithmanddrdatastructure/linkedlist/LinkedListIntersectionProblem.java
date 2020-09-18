package com.engineeralgorithmanddrdatastructure.linkedlist;

import java.util.HashSet;
import java.util.Set;

public class LinkedListIntersectionProblem {
    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        Node<Integer> head = new Node<>(1);
        Node<Integer> second = new Node<>(2);
        Node<Integer> third = new Node<>(3);
        Node<Integer> fifth = new Node<>(5);
        head.setNext(second);
        second.setNext(third);
        third.setNext(fifth);

        Node<Integer> head2 = new Node<>(4);
        head2.setNext(fifth);
        Node<Integer> intersectingNode = solution1.findIntersectingNodeV1(head, head2);
        System.out.println(intersectingNode.getValue());

    }


    //1->2->3->\
    //          4->5
    //      1->/
    //requires O(n)space complexity.
    static class Solution1 {

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

    //requires O(m+n) time complexity
    class Solution2 {
        public Node<Integer> findIntersectingNodeV1(Node<Integer> head1, Node<Integer> head2) {
            if (head1 == null || head2 == null) {
                return null;
            }
            int head1Length = findLength(head1);
            int head2Length = findLength(head2);
            int delta = Math.abs(head1Length - head2Length);
            Node<Integer> longHead = head1Length > head2Length ? head1 : head2;
            Node<Integer> shortHead = head1 == longHead ? head2 : head1;

            while (delta > 0) {
                longHead = longHead.getNext();
                delta--;
            }
            while (longHead != shortHead) {
                longHead = longHead.getNext();
                shortHead = shortHead.getNext();
            }
            return longHead;
        }

        private int findLength(Node<Integer> node) {
            int length = 0;
            while (node != null) {
                node = node.getNext();
                length++;
            }
            return length;
        }
    }
}
