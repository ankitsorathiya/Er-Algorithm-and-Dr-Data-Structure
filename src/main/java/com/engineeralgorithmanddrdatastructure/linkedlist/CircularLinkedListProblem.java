package com.engineeralgorithmanddrdatastructure.linkedlist;

import org.junit.Assert;

public class CircularLinkedListProblem {
    public static void main(String[] args) {
        Node<Integer> head = new Node<>(1);
        Node<Integer> second = new Node<>(2);
        head.setNext(second);
        second.setNext(head);
        CircularLinkedListProblem problem = new CircularLinkedListProblem();
        Node<Integer> newHead = problem.removeNext(head);
        System.out.println(newHead.printPath());
        Assert.assertTrue(newHead.printPath().equals("1"));

    }

    public Node<Integer> removeNext(Node<Integer> head) {
        if (head == null || head.getNext() == head) {
            return head;
        }
        Node current = head;
        while (head != current.getNext()) {
            current.setNext(current.getNext().getNext());
            current = current.getNext();
            if (current == head) {
                return head;
            }
        }
        return head;
    }

}
