package Stack;

import java.util.Iterator;

public interface StackLinked<E> {
    void addFirst(E e);
    void addLast(E e);
    int size();

    Iterator<E> descendingIterator();
}
