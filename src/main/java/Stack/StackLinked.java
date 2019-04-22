package Stack;

import java.util.Iterator;

public interface StackLinked<E> {
    void push(E e);
    int size();
    boolean isEmpty();

    Iterator<E> descendingIterator();
}
