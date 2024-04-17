package exercise;

import java.util.ArrayList;
import java.util.Map;
import java.util.List;
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
        StringBuilder builder = new StringBuilder();
        if (attributes.isEmpty()) {
            return String.format("<%s></%s>", tag, tag);
        }
        String temp = this.attributes.entrySet().stream()
                .map(entry -> String.format("%s=\"%s\"",entry.getKey(), entry.getValue()))
                .collect(Collectors.joining(" ", String.format("<" + this.tag + " "), ">"));
        builder.append(temp);
        this.children.forEach(child -> builder.append(child.toString()));
        builder.append(body);
        builder.append(String.format("</%s>", tag));
        return builder.toString();
    }
}
// END
