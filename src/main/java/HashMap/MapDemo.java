package HashMap;

import java.util.HashMap;
import java.util.Map;

public class MapDemo {
    public static void main(String[] args) {
        Map <String, String> map = new HashMap<String, String>();

        map.put("1", "2");
        map.put("1", "3");

        String s = map.get("a");
        System.out.println(s);

        System.out.println(map.containsKey("1"));
        System.out.println(map.containsValue("2"));
        System.out.println(map.size());

        map.remove("1");
        System.out.println(map.size());
        System.out.println(map.containsKey("1"));
    }
}
