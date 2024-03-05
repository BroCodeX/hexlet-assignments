package exercise;

import java.util.*;

// BEGIN
class App {
    public static <T> Map<String, String> genDiff(Map<String, T> data1, Map<String, T> data2) {
        Map<String, String> result = new LinkedHashMap<>();
        Set<String> keys = new TreeSet<>(data1.keySet());
        keys.addAll(data2.keySet());
        keys.forEach(word -> result.compute(word, (key, val) -> {
            String temp = "";
            if (!data1.containsKey(word) && data2.containsKey(word)) {
                temp = "added";
            } else if (data1.containsKey(word) && !data2.containsKey(word)) {
                temp = "deleted";
            } else if ((data1.containsKey(word) && data2.containsKey(word)) && !(data1.get(word)).equals(data2.get(word))) {
                temp = "changed";
            } else if ((data1.containsKey(word) && data2.containsKey(word)) && (data1.get(word)).equals(data2.get(word))) {
                temp = "unchanged";
            }
            return temp;
        }));
        return result;
    }
}
//END
