package Stack;

import LinkedList.DescendingIterator;
import LinkedList.Linked;

import javax.xml.soap.Node;
import java.util.Iterator;

public class StackLinkedList<E> implements StackLinked<E>, Iterable<E>, DescendingIterator<E> {

        private Node<E> firstNode;
        private Node<E> lastNode;
        private int size = 0;

        public StackLinkedList(){
                lastNode = new Node<>(null, null, firstNode);
                firstNode = new Node<>(null, lastNode, null);
        }

        @Override
        public void addFirst(E e) {
                Node<E> next = firstNode;
                next.setCurrentElement(e);
                firstNode = new Node<E>(null, next, null);
                next.setPrevElement(firstNode);
                size++;
        }

        @Override
        public void addLast(E e) {
                Node<E> prev = lastNode;
                prev.setCurrentElement(e);
                lastNode = new Node<E>(null, null, prev);
                prev.setNextElement(prev);
                size++;
        }

        @Override
        public int size() {
                return size;
        }

        @Override
        public Iterator<E> descendingIterator() {
                return null;
        }

        @Override
        public Iterator<E> iterator() {
                return null;
        }

        private class Node<E>{

                private E currentElement;
                private Node<E> nextElement;
                private Node<E> prevElement;

                public Node(E currentElement, Node<E> nextElement, Node<E> prevElement) {
                        this.currentElement = currentElement;
                        this.nextElement = nextElement;
                        this.prevElement = prevElement;
                }

                public E getCurrentElement() {
                        return currentElement;
                }

                public void setCurrentElement(E currentElement) {
                        this.currentElement = currentElement;
                }

                public Node<E> getNextElement() {
                        return nextElement;
                }

                public void setNextElement(Node<E> nextElement) {
                        this.nextElement = nextElement;
                }

                public Node<E> getPrevElement() {
                        return prevElement;
                }

                public void setPrevElement(Node<E> prevElement) {
                        this.prevElement = prevElement;
                }
        }



}
