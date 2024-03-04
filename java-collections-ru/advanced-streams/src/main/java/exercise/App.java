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
                .filter(line -> line.startsWith("environment") && line.contains("X_FORWARDED_"))
                .map(line -> line.replaceAll(" ", "")
                        .replaceAll("\"", ""))
                .map(line -> line.split("X_FORWARDED_"))
                .flatMap(Arrays::stream)
                .filter(line -> !line.contains("environment"))
                .map(variable -> {
                    int indexOfDot = variable.indexOf(",");
                    if (indexOfDot == -1) {
                        return variable;
                    } else {
                        return variable.substring(0, indexOfDot);
                    }
                })
                .collect(Collectors.joining(","));
    }
}
//END
