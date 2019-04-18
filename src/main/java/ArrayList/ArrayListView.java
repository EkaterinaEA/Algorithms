package ArrayList;

import java.util.ArrayList;
import java.util.List;

public class ArrayListView {

    public static void main(String[] args) {
        List<String> strings = new ArrayList<String>();

        strings.add("0000");
        strings.add("111");
        strings.add("22222");

        for (String s: strings){
            System.out.println(s);
        }

        System.out.println(strings.get(0));

        System.out.println(strings.size());

        strings.remove(1);
        System.out.println(strings.size());
        System.out.println(strings.get(1));

        strings.clear();
        System.out.println(strings.size());

    }
}
