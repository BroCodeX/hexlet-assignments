package exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// BEGIN
class App {
    public static String[][] enlargeArrayImage(String[][] arr) {
        var result = Arrays.stream(arr)
                .map(row -> List.of(row, row))
                .flatMap(List::stream)
//                .flatMap(Arrays::stream)
                .toArray(String[][]::new);
        return result;
    }
}
// END
