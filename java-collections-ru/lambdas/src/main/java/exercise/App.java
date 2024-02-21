package exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

// BEGIN
class App {
    public static String[][] enlargeArrayImage(String[][] arr) {
        return Stream.of(arr)
                .map(line -> Stream.of(line)
                        .map(x -> List.of(x, x))
                        .flatMap(List::stream)
                        .toArray(String[]::new))
                .map(line -> List.of(line, line))
                .flatMap(List::stream)
                .toArray(String[][]::new);
    }
}
// END
