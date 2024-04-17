package exercise;


// BEGIN
class LabelTag implements TagInterface {
    String value;
    TagInterface tag;

    LabelTag(String value, TagInterface tag) {
        this.value = value;
        this.tag = tag;
    }

    @Override
    public String render() {
        return "<label>" +
                this.value +
                this.tag.render() +
                "</label>";
    }
}
// END
