package org.example;

public class Container<E> {
    private int mSize = 0;
    private final Node<E> mHead;
    private Node<E> mTail;

    public Container() {
        mHead = new Node<E>(null, null);
        mTail = mHead;
    }

    public Container(int size) {
        mSize = size;
        mHead = new Node<E>(null, null);
        mTail = mHead;

        for (int i = 0; i < mSize; ++i) {
            add(null);
        }
    }

    /**
     * Returns the number of elements in this list.  If this list contains
     * more than {@code Integer.MAX_VALUE} elements, returns
     * {@code Integer.MAX_VALUE}.
     *
     * @return the number of elements in this list
     */

    public int size() {
        return mSize;
    }

    /**
     * Returns {@code true} if this list contains no elements.
     *
     * @return {@code true} if this list contains no elements
     */
    public boolean isEmpty() {
        return mSize == 0;
    }

    /**
     * Returns {@code true} if this list contains the specified element.
     * More formally, returns {@code true} if and only if this list contains
     * at least one element {@code e} such that
     * {@code Objects.equals(o, e)}.
     *
     * @param o element whose presence in this list is to be tested
     * @return {@code true} if this list contains the specified element
     */
    public boolean contains(Object o) {
        Node<E> temp = mHead;

        if (mHead == o)
            return true;

        while (temp != mTail) {
            if (temp.getValue() == o) {
                return true;
            }
            temp = temp.getNext();
        }

        return false;
    }
    /**
     * Insert an element at the end of the list
     * @param e element to be inserted into this list, if present
     * @return {@code true} if this element inserted into this list
     */
    public boolean add(E e) {
        Node<E> node = new Node<E>(e, null);
        mTail.setNext(node);
        mTail = node;

        mSize +=1;

        return true;
    }

    /**
     * Removes the first occurrence of the specified element from this list,
     * if it is present (optional operation).  If this list does not contain
     * the element, it is unchanged.  More formally, removes the element with
     * the lowest index {@code i} such that
     * {@code Objects.equals(o, get(i))}
     * (if such an element exists).  Returns {@code true} if this list
     * contained the specified element (or equivalently, if this list changed
     * as a result of the call).
     *
     * @param o element to be removed from this list, if present
     * @return {@code true} if this list contained the specified element
     */
    public boolean remove(Object o) {

        Node<E> temp = mHead;

        while (temp.getNext() != mTail) {
            if (temp.getNext().getValue() == o) {
                temp.setNext(temp.getNext().getNext());
                mSize -=1;
                return true;
            }
            temp = temp.getNext();
        }

        return false;
    }

    /**
     * Removes all of the elements from this list (optional operation).
     * The list will be empty after this call returns.
     *
     * @throws UnsupportedOperationException if the {@code clear} operation
     *                                       is not supported by this list
     */
    public void clear() {
        while (!isEmpty()) {
            remove(0);
        }
    }

    /**
     * Returns the element at the specified position in this list.
     *
     * @param index index of the element to return
     * @return the element at the specified position in this list
     * @throws IndexOutOfBoundsException if the index is out of range
     *                                   ({@code index < 0 || index >= size()})
     */
    public E get(int index) {

        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        }

        Node<E> temp = mHead;

        for (int i = 0; i < index; ++i) {
            temp = temp.getNext();
        }

        return (E)temp.getNext().getValue();
    }

    /**
     * Replaces the element at the specified position in this list with the
     * specified element (optional operation).
     *
     * @param index   index of the element to replace
     * @param element element to be stored at the specified position
     * @return the element previously at the specified position

     * @throws IndexOutOfBoundsException     if the index is out of range
     *                                       ({@code index < 0 || index >= size()})
     */
    public E set(int index, E element) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        }

        Node<E> temp = mHead;

        for (int i = 0; i < index; ++i) {
            temp = temp.getNext();
        }

        E result = (E)temp.getNext().getValue();

        temp.getNext().setValue(element);

        return result;
    }

    /**
     * Inserts the specified element at the specified position in this list
     * (optional operation).  Shifts the element currently at that position
     * (if any) and any subsequent elements to the right (adds one to their
     * indices).
     *
     * @param index   index at which the specified element is to be inserted
     * @param element element to be inserted
     * @throws IndexOutOfBoundsException     if the index is out of range
     *                                       ({@code index < 0 || index > size()})
     */
    public void add(int index, E element) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        }

        Node<E> temp = mHead;

        for (int i = 0; i < index; ++i) {
            temp = temp.getNext();
        }

        Node<E> newNode = new Node<E>(element, temp.getNext());

        temp.setNext(newNode);

        mSize += 1;
    }

    /**
     * Removes the element at the specified position in this list (optional
     * operation).  Shifts any subsequent elements to the left (subtracts one
     * from their indices).  Returns the element that was removed from the
     * list.
     *
     * @param index the index of the element to be removed
     * @return the element previously at the specified position
     * @throws UnsupportedOperationException if the {@code remove} operation
     *                                       is not supported by this list
     * @throws IndexOutOfBoundsException     if the index is out of range
     *                                       ({@code index < 0 || index >= size()})
     */
    public E remove(int index) {
        Node<E> temp = mHead;

        for (int i = 0; i < index; ++i) {
            temp = temp.getNext();
        }

        E result = (E)temp.getNext().getValue();

        temp.setNext(temp.getNext().getNext());

        mSize -=1;

        return result;
    }

    /**
     * Returns a view of the portion of this list between the specified
     * {@code fromIndex}, inclusive, and {@code toIndex}, exclusive.  (If
     * {@code fromIndex} and {@code toIndex} are equal, the returned list is
     * empty.)  The returned list is backed by this list, so non-structural
     * changes in the returned list are reflected in this list, and vice-versa.
     * The returned list supports all of the optional list operations supported
     * by this list.<p>
     * <p>
     * This method eliminates the need for explicit range operations (of
     * the sort that commonly exist for arrays).  Any operation that expects
     * a list can be used as a range operation by passing a subList view
     * instead of a whole list.  For example, the following idiom
     * removes a range of elements from a list:
     * <pre>{@code
     *      list.subList(from, to).clear();
     * }</pre>
     * Similar idioms may be constructed for {@code indexOf} and
     * {@code lastIndexOf}, and all of the algorithms in the
     * {@code Collections} class can be applied to a subList.<p>
     * <p>
     * The semantics of the list returned by this method become undefined if
     * the backing list (i.e., this list) is <i>structurally modified</i> in
     * any way other than via the returned list.  (Structural modifications are
     * those that change the size of this list, or otherwise perturb it in such
     * a fashion that iterations in progress may yield incorrect results.)
     *
     * @param fromIndex low endpoint (inclusive) of the subList
     * @param toIndex   high endpoint (exclusive) of the subList
     * @return a view of the specified range within this list
     * @throws IndexOutOfBoundsException for an illegal endpoint index value
     *                                   ({@code fromIndex < 0 || toIndex > size ||
     *                                   fromIndex > toIndex})
     */
    public Container<E> subList(int fromIndex, int toIndex) {
        if (fromIndex < 0 || toIndex > size() || fromIndex > toIndex) {
            throw new IndexOutOfBoundsException();
        }

        Container<E> result = new Container<E>();

        Node<E> temp = mHead;

        for (int i = 0; i < fromIndex; ++i) {
            temp = temp.getNext();
        }

        for (int i = fromIndex; i < toIndex; ++i) {
            result.add((E)temp.getNext().getValue());
            temp = temp.getNext();
        }
        return result;
    }
}