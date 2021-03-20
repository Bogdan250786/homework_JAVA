package com.paramud.homeworkLinkedList;

public class Node<E> {
    E value;
    Node<E> next;

    public Node (E value) {
        this.value = value;
    }

    @Override
    public String toString() {
        ///if (next !=null ) return value + ", " + next;
         return "" + value;
    }
}
