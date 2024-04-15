package exercise;

import lombok.AllArgsConstructor;

// BEGIN
@AllArgsConstructor
class ReversedSequence implements java.lang.CharSequence {
    String text;


    @Override
    public int length() {
        return this.text.length();
    }

    @Override
    public char charAt(int index) {
        return this.text.charAt(index);
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return this.text.subSequence(start, end);
    }

    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder(this.text);
        return builder.reverse().toString();
    }
}
// END
