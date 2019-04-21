package Stack;

public class StackArrayApp {
    public static void main(String[] args) {
        StackArray stackArray = new StackArray(5);

        System.out.println(stackArray.isEmpty());
        stackArray.push(1);
        stackArray.push(2);
        stackArray.push(3);
        stackArray.push(4);
        stackArray.push(5);
        System.out.println(stackArray.top);
        System.out.println(stackArray.isEmpty());

        System.out.println(stackArray.pick());
        System.out.println(stackArray.pop());
        stackArray.pop();
        stackArray.pop();
        stackArray.pop();
        stackArray.pop();
        System.out.println(stackArray.top);
        System.out.println(stackArray.isEmpty());
        System.out.println(stackArray.pick());
    }
}
