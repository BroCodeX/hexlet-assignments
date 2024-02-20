package exercise;

import java.util.Arrays;

// BEGIN
class App {
    public static String[][] enlargeArrayImage(String[][] arr) {
        var result = Arrays.stream(arr)
                .flatMap(Arrays::stream)
                .map(symbol -> {
                    String[][] temp = new String[][] {{symbol, symbol},{symbol, symbol}};
                    return temp;
                })
                .flatMap(Arrays::stream)
                .toArray(String[][]::new);
        return result;
    }
}
// END
