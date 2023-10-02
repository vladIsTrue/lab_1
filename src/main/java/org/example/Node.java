package org.example;

public class Node<E> {
    private Node mNext;
    private Node mPrevious;
    private E mValue;

    public Node(E value) {
        mNext = null;
        mPrevious = null;
        mValue = value;
    }
    public Node(E value, Node previous, Node next) {
        mNext = next;
        mPrevious = previous;
        mValue = value;
    }

    public Node getNext() {
        return mNext;
    }

    public void setNext(Node next) {
        mNext = next;
    }

    public Node getPrevious() {
        return mPrevious;
    }

    public void setPrevious(Node previous) {
        mPrevious = previous;
    }

    public E getValue() {
        return mValue;
    }

    public void setValue(E value) {
        mValue = value;
    }
}