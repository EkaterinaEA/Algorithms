package LinkedList;

import java.util.Iterator;

public interface Linked<E> {

    void addFirst(E e);
    void addLast(E e);
    int size();
    E getElementByIndex(int counter);

    Iterator<E> descendingIterator();
}
