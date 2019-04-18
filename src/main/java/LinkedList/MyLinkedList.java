package LinkedList;


import java.util.Iterator;

public class MyLinkedList<E> implements Linked<E>, Iterable<E>, DescendingIterator<E>{

    private Node<E> firstNode;
    private Node<E> lastNode;
    private int size = 0;

    public MyLinkedList() {
        lastNode = new Node<E>(null, null, firstNode);
        firstNode = new Node<E>(null, lastNode, null);
    }

    public void addFirst(E e) {
        Node<E> next = firstNode;
        next.setCurrentElement(e);
        firstNode = new Node<E>(null, next, null);
        next.setPrevElement(firstNode);
        size++;
    }

    public void addLast(E e) {
        Node<E> prev = lastNode;
        prev.setCurrentElement(e);
        lastNode = new Node<E>(null, null, prev);
        prev.setNextElement(lastNode);
        size++;
    }

    public int size() {
        return size;
    }

    public E getElementByIndex(int counter) {
        Node<E> target = firstNode.getNextElement();
        for (int i = 0; i < counter; i++){
            target = getNextElement(target);
        }
        return target.getCurrentElement();
    }

    private Node<E> getNextElement(Node<E> current){
        return current.getNextElement();
    }

    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int counter = 0;

            @Override
            public boolean hasNext() {
                return counter < size;
            }

            @Override
            public E next() {
                return getElementByIndex(counter++);
            }

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
                return getElementByIndex(counter--);
            }

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

    public static void main(String[] args) {
        Linked<String> stringLinked = new MyLinkedList<String>();

        stringLinked.addFirst("a");
        stringLinked.addFirst("b");

        System.out.println(stringLinked.size());
        System.out.println(stringLinked.getElementByIndex(0));

        stringLinked.addLast("c");
        stringLinked.addLast("d");

        System.out.println(stringLinked.getElementByIndex(2));
        System.out.println(stringLinked.size());

        for (String s : (MyLinkedList<String>) stringLinked){
            System.out.println(s);
        }

        Iterator iterator = ((MyLinkedList<String>) stringLinked).descendingIterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }

}
