package Queue;

public class QueueArray {

    public int[] queue;
    public int maxSize;
    public int nElem;
    public int front;
    public int rear;

    public QueueArray(int maxSize) {
        this.maxSize = maxSize;
        queue = new int[maxSize];
        front = 0;
        rear = -1;
        nElem = 0;
    }

    public void insert(int elem){
        if (rear == maxSize - 1){   // cyclic transfer (циклический перенос)
            rear = -1;
        }
        queue[++rear] = elem;       // increase rear and insert (увеличение rear и вставка)
        nElem++;
    }

    public int remove(){
        int temp = queue[front++];

        if (front == maxSize){
            front = 0;
        }

        nElem--;
        return temp;
    }

    public int getFront(){
        return queue[front];
    }

    public int getRear(){
        return queue[rear];
    }

    public boolean isFull(){
        return nElem == maxSize - 1;
    }

    public boolean isEmpty(){
        return nElem == 0;
    }

    public int size(){
        return nElem;
    }

}
