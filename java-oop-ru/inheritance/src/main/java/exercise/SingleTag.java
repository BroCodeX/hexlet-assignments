package exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

// BEGIN
class SingleTag extends Tag {
    SingleTag(String tag, Map<String, String> attributes) {
        super(tag, attributes);
    }

    @Override
    public String toString() {
        if (attributes.isEmpty()) {
            return String.format("<%s>", tag);
        }
        return this.attributes.entrySet().stream()
                .map(entry -> String.format("%s=\"%s\"",entry.getKey(), entry.getValue()))
                .collect(Collectors.joining(" ", String.format("<" + this.tag + " "), ">"));
    }
}
// END
