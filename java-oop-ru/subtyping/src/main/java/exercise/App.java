package exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

// BEGIN
public class App {
    public static void swapKeyValue(KeyValueStorage obj) {
        Map<String, String> map = new HashMap<>(obj.toMap());
        System.out.println(map);
        map.forEach((key, val) -> {
            obj.unset(key);
            obj.set(val, key);
        });
    }
}
// END
