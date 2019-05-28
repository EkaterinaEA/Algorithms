package Stack;

public class StackLinkedListApp<E> {

    public static void main(String[] args) {

        StackLinkedList<String> stackLinkedList = new StackLinkedList<String>();

        System.out.println(stackLinkedList.peek());
        System.out.println(stackLinkedList.isEmpty());
        System.out.println(stackLinkedList.size());

        stackLinkedList.push("1");
        stackLinkedList.push("2");
        stackLinkedList.push("3");
        stackLinkedList.push("4");

        System.out.println(stackLinkedList.isEmpty());
        System.out.println(stackLinkedList.pop());

        System.out.println(stackLinkedList.peek());

        System.out.println(stackLinkedList.pop());
        System.out.println(stackLinkedList.pop());

        System.out.println(stackLinkedList.size());

    }

}
