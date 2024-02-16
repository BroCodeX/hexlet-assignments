package exercise;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;

// BEGIN
class App {
    public static List<Map<String, String>> findWhere(List<Map<String, String>> books, Map<String, String> where) {
        List<Map<String, String>> filteredBooks = new ArrayList<>();
        books.forEach(x -> {
            int check = 0;
            for (Map.Entry<String, String> kv : where.entrySet()) {
                check += matchesCount(x, kv.getKey(), kv.getValue());
            }
            if (check == where.size()) filteredBooks.add(x);
        });
        return filteredBooks;
    }

    public static int matchesCount(Map<String, String> x, String whereKey, String whereValue) {
        return x.get(whereKey).equals(whereValue) ? 1 : 0;
    }


}
//END
