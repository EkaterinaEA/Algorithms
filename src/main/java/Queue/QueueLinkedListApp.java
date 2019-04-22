package Queue;

public class QueueLinkedListApp<E> {
    public static void main(String[] args) {
        QueueLinkedList<Integer> queueLinkedList = new QueueLinkedList<>();

        System.out.println(queueLinkedList.isEmpty());
        System.out.println(queueLinkedList.size());

        queueLinkedList.push(1);
        queueLinkedList.push(2);
        queueLinkedList.push(3);

        System.out.println(queueLinkedList.isEmpty());
        System.out.println(queueLinkedList.size());

        System.out.println(queueLinkedList.getFront());
        System.out.println(queueLinkedList.getRear());

        System.out.println(queueLinkedList.pop());
        System.out.println(queueLinkedList.pop());
        System.out.println(queueLinkedList.pop());

        System.out.println(queueLinkedList.isEmpty());
        System.out.println(queueLinkedList.size());

    }
}
