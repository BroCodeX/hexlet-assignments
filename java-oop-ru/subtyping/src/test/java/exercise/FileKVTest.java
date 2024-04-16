package exercise;

import java.util.HashMap;
import org.junit.jupiter.api.BeforeEach;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
// BEGIN


class FileKVTest {

    private static Path filepath = Paths.get("src/test/resources/file").toAbsolutePath().normalize();

    @BeforeEach
    public void beforeEach() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String content = mapper.writeValueAsString(new HashMap<String, String>());
        Files.writeString(filepath, content, StandardOpenOption.CREATE);
    }

    // BEGIN
    @Test
    public void mainTest() {
        FileKV test = new FileKV(filepath.toString(), Map.of("one", "1"));
        String actualContent = Utils.readFile(filepath.toString());
        Map<String, String> actual = Utils.unserialize(actualContent);
        Map<String, String> expected = new HashMap<>(Map.of("one", "1"));
        assertEquals(expected, actual);
    }

    @Test
    public void setTest() {
        FileKV test = new FileKV(filepath.toString(), Map.of("one", "1"));
        test.set("one", "2");
        test.set("three", "3");
        String actualContent = Utils.readFile(filepath.toString());
        Map<String, String> actual = Utils.unserialize(actualContent);
        Map<String, String> expected = new HashMap<>(Map.of("one", "2", "three", "3"));
        assertEquals(expected, actual);
    }

    @Test
    public void getTest() {
        FileKV test = new FileKV(filepath.toString(), Map.of("one", "1"));
        test.set("one", "2");
        String actualContent = Utils.readFile(filepath.toString());
        Map<String, String> actualMap = Utils.unserialize(actualContent);
        String actual = actualMap.getOrDefault("one", "default");
        String expected = "2";
        assertEquals(expected, actual);
    }
    // END
}
