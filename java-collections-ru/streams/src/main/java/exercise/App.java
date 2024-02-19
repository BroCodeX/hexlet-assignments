package exercise;

import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;

// BEGIN
class App {
    public static int getCountOfFreeEmails(List<String> emails) {
        List<String> freeDomains = List.of("gmail.com", "yandex.ru", "hotmail.com");
        return emails.stream()
                .map(x -> x.split("@"))
                //.filter(x -> freeDomains.contains(x[1]))
                .reduce(0, (acc, x) -> {
                    if (freeDomains.contains(x[1])) {
                        acc += 1;
                    }
                    return acc;
                }, Integer::sum);
    }
//public static int getCountOfFreeEmails(List<String> emails) {
//    List<String> freeDomains = List.of("gmail.com", "yandex.ru", "hotmail.com");
//    long result = emails.stream()
//            .map(x -> x.split("@"))
//            .filter(x -> freeDomains.contains(x[1]))
//            .count();
//    return (int) result;
//}
}
// END
