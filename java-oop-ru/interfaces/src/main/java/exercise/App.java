package exercise;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

// BEGIN
class App {
    public static List<String> buildApartmentsList(List<Home> homes, int count) {
        return homes.stream()
                .sorted(Comparator.comparing(Home::getArea))
                .limit(count)
                .map(Home::toString)
                .collect(Collectors.toList());
    }
}
// END
