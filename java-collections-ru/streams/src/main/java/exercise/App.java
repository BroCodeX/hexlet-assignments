package exercise;

import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;

// BEGIN
class App {
    private static final List<String> FREE_DOMAINS = List.of("gmail.com", "yandex.ru", "hotmail.com");
    public static int getCountOfFreeEmails(List<String> emails) {

        return emails.stream()
                .map(x -> x.split("@"))
                .reduce(0, (acc, x) -> {
                    if (FREE_DOMAINS.contains(x[1])) {
                        acc += 1;
                    }
                    return acc;
                }, Integer::sum);
    }
//public static long getCountOfFreeEmails(List<String> emails) {
//    return emails.stream()
//            .map(x -> x.split("@"))
//            .filter(x -> FREE_DOMAINS.contains(x[1]))
//            .count();
//}
}
// END
