package exercise;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;

// BEGIN
class App {
    public static <T extends Map<String, String>> List<T> findWhere(List<T> books, T where) {
        List<T> filteredBooks = new ArrayList<>();
        MatchesCount<String> counter = ((map, key, whereValue) -> map.get(key).equals(whereValue) ? 1 : 0);
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
interface MatchesCount <T> {
    int apply (Map<T, T> map, T whereKey, T whereValue);
}
//END
