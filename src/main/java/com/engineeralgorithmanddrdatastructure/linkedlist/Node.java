package com.engineeralgorithmanddrdatastructure.linkedlist;

import java.util.Objects;

public class Node<T> {
    private T value;
    private Node<T> next;
    public int visitingCount = 0;
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
        while (current != null && current.next != this) {
            path.append(current.value).append("=>");
            current = current.next;
        }
        if (current != null) {
            path.append(current.value);
        }
        return path.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        return false;
    }

    @Override
    public int hashCode() {

        return Objects.hash(getValue(), getNext(), visitingCount);
    }
}
