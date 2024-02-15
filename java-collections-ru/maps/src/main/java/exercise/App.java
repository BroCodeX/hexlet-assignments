package exercise;

import java.util.*;
import java.util.stream.Collectors;

// BEGIN
class App {
    public static Map<String, Integer> getWordCount(String sentence) {
        String[] sentenceArr = sentence.split(" ");
        List<String> sentenceList = new ArrayList<>();
        sentenceList.addAll(Arrays.asList(sentenceArr));
        return sentenceList.stream()
                .filter(x -> !x.isEmpty())
                .collect(Collectors.groupingBy(word -> word, Collectors.summingInt(e -> 1)));
    }

    public static String toString(Map<String, Integer> mapa) {
        StringBuilder builder = new StringBuilder();
        mapa.forEach((x, y) -> {
            builder.append(String.format("  %s: %d\n", x, y));
        });
        if (!mapa.isEmpty()) {
            return "{\n" + builder.toString() + "}";
        } else {
            return "{}";
        }
    }
}
//END
