package exercise;

import java.util.*;

// BEGIN
class App {
    public static boolean scrabble(String symbols, String word) {
        if (symbols.isEmpty() || word.isEmpty()) {
            return false;
        }

        Map<String, Integer> symbolsMap = new HashMap<>();
        List<String> symbolsList = new ArrayList<>();
        String[] symbolsChars = symbols.toLowerCase().split("");
        symbolsList.addAll(Arrays.asList(symbolsChars));

        Map<String, Integer> wordMap = new HashMap<>();
        List<String> wordList = new ArrayList<>();
        String[] wordChars = word.toLowerCase().split("");
        wordList.addAll(Arrays.asList(wordChars));

        symbolsList.forEach(symbol -> symbolsMap.compute(symbol, (k, v) -> v == null ? 1 : v + 1));
        wordList.forEach(w -> wordMap.compute(w, (k, v) -> v == null ? 1 : v + 1));
//
//        System.out.println(wordMap);
//        System.out.println(symbolsMap);

        for (Map.Entry<String, Integer> item: wordMap.entrySet()) {
            String key = item.getKey();
            int value = item.getValue();
            if (!symbolsMap.containsKey(key) || symbolsMap.get(key) < value) {
                return false;
            }
        }
        return true;
    }
}
//END
