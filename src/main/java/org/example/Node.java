package org.example;

public class Node<E> {
    private Node mNext;
    private Node mPrevious;
    private E mValue;

    public Node(E value) {
        mNext = null;
        mValue = value;
    }
    public Node(E value, Node next) {
        mNext = next;
        mValue = value;
    }

    public Node getNext() {
        return mNext;
    }

    public void setNext(Node next) {
        mNext = next;
    }

    public E getValue() {
        return mValue;
    }

    public void setValue(E value) {
        mValue = value;
    }
}