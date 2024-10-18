package exercise;

import java.nio.file.*;
import java.util.concurrent.CompletableFuture;
import java.util.Arrays;
import java.io.File;
import java.util.concurrent.ExecutionException;

class App {

    // BEGIN
    public static CompletableFuture<String> unionFiles(String source1, String source2, String target)
            throws ExecutionException, InterruptedException {
        Path sourcePath1 = Paths.get(source1).toAbsolutePath().normalize();
        Path sourcePath2 = Paths.get(source2).toAbsolutePath().normalize();
        Path targetPath = Paths.get(target).toAbsolutePath().normalize();

        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            try {
                return Files.readString(sourcePath1).replaceAll("\\n", "");
            } catch (Exception ex) {
                throw new RuntimeException("Ошибка при чтении файла " + sourcePath1, ex);
            }
        });
        future1.get();

        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            try {
                return Files.readString(sourcePath2).replaceAll("\\n", "");
            } catch (Exception ex) {
                throw new RuntimeException("Ошибка при чтении файла " + sourcePath2, ex);
            }
        });
        future2.get();

        return future1.thenCombine(future2, (cont1, cont2) -> {
            String concated = String.join(" ", cont1, cont2);
            try {
                Files.writeString(targetPath, concated);
                return concated;
            } catch (Exception ex) {
                throw new RuntimeException("Ошибка при записи в файл " + targetPath, ex);
            }
        });
    }
    // END

    public static void main(String[] args) throws Exception {
        // BEGIN
        String source1 = "src/main/resources/file1.txt";
        String source2 = "src/main/resources/file2.txt";
        String target = "src/main/resources/target.txt";
        CompletableFuture<String> result = unionFiles(source1, source2, target);
        System.out.println(result.get());
        System.out.println(getDirectorySize("src/main/resources/").get());
        // END
    }

    public static CompletableFuture<Long> getDirectorySize(String dirAddress) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Path path = Paths.get(dirAddress).toAbsolutePath().normalize();
                long resultSize = 0;
                var dirStream = Files.newDirectoryStream(path);
                for (Path p : dirStream) {
                    long tempSize = Files.size(p);
                    resultSize += tempSize;
                }
                return resultSize;
            } catch (Exception ex) {
                throw new RuntimeException("Ошибка при чтении директории " + dirAddress, ex);
            }
        });
    }
}

