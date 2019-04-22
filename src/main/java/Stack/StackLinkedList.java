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
        public void push(E e) {
                Node<E> next = firstNode;
                next.setCurrentElement(e);
                firstNode = new Node<E>(null, next, null);
                next.setPrevElement(firstNode);
                size++;
        }

        public Node<E> pop(){
                if (isEmpty()) {
                        System.out.println("List is empty");
                }
                Node<E> lastFirst = firstNode;
                firstNode = firstNode.getNextElement();
                size --;
                return lastFirst.getNextElement();
        }

        public Node<E> peek(){
                return firstNode.getNextElement();
        }

        @Override
        public int size() {
                return size;
        }

        @Override
        public boolean isEmpty(){
                return size == 0;
        }

        @Override
        public Iterator<E> iterator() {
                return new Iterator<E>() {
                        int counter = 0;
                        @Override
                        public boolean hasNext() {
                                return counter < size;
                        }

                        @Override
                        public E next() {
                                return null;
                        }

                        @Override
                        public void remove() {

                        }
                };
        }

        @Override
        public Iterator<E> descendingIterator() {
                return new Iterator<E>() {
                        int counter = size - 1;

                        @Override
                        public boolean hasNext() {
                                return counter >= 0;
                        }

                        @Override
                        public E next() {
                                return null;
                        }

                        @Override
                        public void remove() {

                        }
                };
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
