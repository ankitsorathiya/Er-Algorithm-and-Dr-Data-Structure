package com.engineeralgorithmanddrdatastructure.linkedlist;

public class Node<T> {
    private T value;
    private Node<T> next;

    public Node(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public String printPath() {
        Node<T> current = this;
        StringBuilder path = new StringBuilder();
        while (current.next != this) {
            path.append(current.value).append("=>");
            current = current.next;
        }
        path.append(current.value);
        return path.toString();
    }
}
