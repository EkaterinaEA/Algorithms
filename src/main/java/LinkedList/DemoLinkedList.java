package LinkedList;

import java.util.LinkedList;
import java.util.List;

public class DemoLinkedList {
    public static void main(String[] args) {
        List<String> list = new LinkedList<String>();

        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");

        System.out.println(list.get(0));

        for (String s : list){
            System.out.println(s);
        }

        list.remove(0);
        System.out.println(list.size());

        System.out.println(list.get(0));

        for (String s : list){
            System.out.println(s);
        }

    }
}
