package e09_StreamAPI_Lambda;

import java.util.HashMap;
import java.util.Map;

public class ex1 {
    // Generic function to convert List of
    // String to List of Integer

    //return

    public static void main(String args[]) {

        // Create a Map
        Map<String, Integer> map = new HashMap<>();

        // Add entries to the Map
        map.put(1, "Geeks");
        map.put(2, "forGeeks");
        map.put(3, "A computer Portal");

        // Print the Map
        System.out.println("Map: " + map);

        System.out.println(map.entrySet().stream().toString());

        // Convert the Map to Stream
// 		Stream<Map.Entry<Integer, String> > stream =convertMapToStream(map);

        // Print the TreeMap
// 		System.out.println("Stream: " + Arrays.toString(stream.toArray()));
    }
}

