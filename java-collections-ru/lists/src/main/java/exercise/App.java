package exercise;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

// BEGIN
class App {
    public static boolean scrabble(String symbols, String word) {
        boolean result = false;
        ArrayList<String> symbolsChars = new ArrayList<>(symbols.length());
        String[] symbolsArr = symbols.toLowerCase().split("");
        symbolsChars.addAll(Arrays.asList(symbolsArr));
        ArrayList<String> wordChars = new ArrayList<>(symbols.length());
        String[] wordArr = word.toLowerCase().split("");
        wordChars.addAll(Arrays.asList(wordArr));
        for (String c: wordChars) {
            int index = symbolsChars.indexOf(c);
            if (index == -1) {
                return false;
            } else {
                symbolsChars.remove(index);
                result = true;
            }
        }
        return result;
    }
}
//END
