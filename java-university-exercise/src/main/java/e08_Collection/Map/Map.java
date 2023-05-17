package e08_Collection.Map;

import java.util.HashMap;

public class Map {
    public static void main(String[] args) {
        HashMap<String, Integer> empIds = new HashMap<>();

        empIds.put("John", 12345);
        empIds.put("Carl", 54321);
        empIds.put("Jerry",87654);
        System.out.println(empIds);

        System.out.println(empIds.get("Carl"));
        System.out.println(empIds.containsKey("Jerry"));
        System.out.println(empIds.containsValue(12345));

        empIds.put("John", 10000);
        System.out.println(empIds); //if you put already existing key -> it will override the value with the new one

        empIds.replace("John", 777); //it will check if the key exist -> if it doesn't, it won't add anything
        System.out.println(empIds);

        empIds.putIfAbsent("Steve", 99999);
        System.out.println(empIds);

        empIds.remove("Carl", 54321);
        System.out.println(empIds);
    }
}
