package Stack;

import java.util.Stack;

public class StackView {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        System.out.println(stack.empty());
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        System.out.println(stack.empty());

        System.out.println(stack.peek());
        System.out.println(stack);

        System.out.println(stack.pop());
        System.out.println(stack.pop());

        System.out.println(stack);
    }
}