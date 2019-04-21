package Queue;

public class QueueArrayApp {

    public static void main(String[] args) {
        QueueArray queueArray = new QueueArray(5);

        System.out.println(queueArray.isEmpty());
        System.out.println(queueArray.size());

        queueArray.insert(1);
        queueArray.insert(2);
        queueArray.insert(3);
        queueArray.insert(4);

        System.out.println(queueArray.size());
        System.out.println(queueArray.isEmpty());

        System.out.println(queueArray.getRear());
        System.out.println(queueArray.getFront());

        System.out.println(queueArray.remove());
        System.out.println(queueArray.remove());
        System.out.println(queueArray.remove());
        System.out.println(queueArray.remove());

        System.out.println(queueArray.getFront());
        System.out.println(queueArray.size());
    }
}
