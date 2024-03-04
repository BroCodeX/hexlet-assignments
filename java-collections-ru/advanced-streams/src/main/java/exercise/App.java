package exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Arrays;
import java.util.stream.Stream;

// BEGIN
class App {
    public static String getForwardedVariables(String content) {
        String[] splitContent = content.trim().split("\n");
        List<String> listContent = Arrays.asList(splitContent);
        return listContent.stream()
                .filter(line -> !line.isEmpty())
                .filter(line -> line.startsWith("environment=") && line.contains("X_FORWARDED_"))
                .map(line -> line.replaceAll("environment=", ""))
                .map(line -> line.replaceAll("\"", ""))
                .map(line -> line.split(","))
                .flatMap(Arrays::stream)
                .filter(kv -> kv.startsWith("X_FORWARDED_"))
                .map(kv -> kv.replaceAll("X_FORWARDED_", ""))
                .collect(Collectors.joining(","));
    }
}
//END
