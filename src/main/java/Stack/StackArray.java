package Stack;

public class StackArray {

    int size;
    int [] array;
    int top;

    public StackArray(int s){
        size = s;
        array = new int[size];
        top = -1;
    }

    public boolean isEmpty(){
        return top == -1;
    }

    public void push(int a){
        try {
            if ((top++)>=size){
                System.out.println("Array is full");
            }
            int i = ++top;
            array[i] = a;
        } catch (IndexOutOfBoundsException e){
            e.printStackTrace();
        }
    }

    public int pop(){
        if (isEmpty()){
            System.out.println("Array is empty");
            return 0;
        }
        return array[top--];
    }

    public int pick(){
        if (isEmpty()){
            System.out.println("Array is empty");
            return 0;
        }
        return array[top];
    }
}
