package exercise;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

// BEGIN
class App {
    public static boolean scrabble(String symbols, String word) {
        boolean result = false;
        ArrayList<Character> symbolsChars = new ArrayList<>(symbols.length());
        for (char s : symbols.toLowerCase().toCharArray()) {
            symbolsChars.add(s);
        }
        ArrayList<Character> wordChars = new ArrayList<>(symbols.length());
        for (char w: word.toLowerCase().toCharArray()) {
            wordChars.add(w);
        }
        for (char c: wordChars) {
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
