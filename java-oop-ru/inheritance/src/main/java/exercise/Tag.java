package exercise;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.stream.Collectors;
import java.util.Map;

// BEGIN
public abstract class Tag {
    String tag;
    Map<String, String> attributes;

    Tag(String tag, Map<String, String> attributes) {
        this.tag = tag;
        this.attributes = new LinkedHashMap<>(attributes);
    }

    public String getTag() {
        return this.tag;
    }

    public String collectText() {
        return this.attributes.entrySet().stream()
                .map(entry -> String.format(" %s=\"%s\"",entry.getKey(), entry.getValue()))
                .collect(Collectors.joining(""));
    }

    public Map<String, String> getaAttributes() {
        return this.attributes;
    }

    public abstract String toString();
}
// END
