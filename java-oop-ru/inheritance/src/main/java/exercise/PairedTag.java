package exercise;

import java.util.ArrayList;
import java.util.Map;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

// BEGIN
class PairedTag extends Tag {
    String body;
    List<Tag> children;

    PairedTag(String tag, Map<String, String> attributes, String body, List<Tag> children) {
        super(tag, attributes);
        this.body = body;
        this.children = new ArrayList<>(children);
    }

    @Override
    public String toString() {
        if (attributes.isEmpty()) {
            return String.format("<%s></%s>", tag, tag);
        }
        String attributes = collectText();
        String child = children.stream()
                .map(Objects::toString)
                .collect(Collectors.joining());
        return String.format("<%s%s>%s%s</%s>", tag, attributes, body, child, tag);
    }
}
// END
