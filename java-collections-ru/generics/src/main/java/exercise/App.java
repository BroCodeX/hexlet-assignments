package exercise;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;

// BEGIN
class App {
    public static List<Map<String, String>> findWhere(List<Map<String, String>> books, Map<String, String> where) {
        List<Map<String, String>> filteredBooks = new ArrayList<>();
        MatchesCount counter = ((map, key, value) -> map.get(key).equals(value) ? 1 : 0);
        books.forEach(x -> {
            int check = 0;
            for (Map.Entry<String, String> kv : where.entrySet()) {
                check += counter.apply(x, kv.getKey(), kv.getValue());
            }
            if (check == where.size()) filteredBooks.add(x);
        });
        return filteredBooks;
    }
}

@FunctionalInterface
interface MatchesCount {
    int apply (Map<String, String> x, String whereKey, String whereValue);
}
//END
