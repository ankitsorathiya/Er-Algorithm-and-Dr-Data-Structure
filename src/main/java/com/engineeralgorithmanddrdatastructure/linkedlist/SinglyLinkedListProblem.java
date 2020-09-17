package com.engineeralgorithmanddrdatastructure.linkedlist;

public class SinglyLinkedListProblem {

    public static void main(String[] args) {
        Node<Integer> head = new Node<>(1);
        Node<Integer> second = new Node<>(2);
        Node<Integer> third = new Node<>(3);
        head.setNext(second);
        second.setNext(third);
        Node<Integer> newHead = new SinglyLinkedListProblem().reverse(head);
        System.out.println(newHead.printPath());
    }

    public Node<Integer> reverse(Node<Integer> head) {
        if (head == null) {
            return null;
        }
        Node previous = head;
        Node current = head.getNext();
        previous.setNext(null);
        while (current != null) {
            Node next = current.getNext();
            current.setNext(previous);
            previous = current;
            current = next;
        }
        return previous;
    }

}
