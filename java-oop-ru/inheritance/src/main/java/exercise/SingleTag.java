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
        return String.format("<%s%s>", tag, collectText());
    }
}
// END
