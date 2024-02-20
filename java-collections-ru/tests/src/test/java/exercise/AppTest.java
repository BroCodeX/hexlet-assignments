package exercise;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;

class AppTest {

    @Test
    void testTake() {
        // BEGIN
        List<Integer> numbers1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        List<Integer> actual1 = App.take(numbers1, 2);
        List<Integer> expected = List.of(1, 2);
        assertThat(actual1).isEqualTo(expected);

        List<Integer> numbers11 = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        List<Integer> actual11 = App.take(numbers11, 10);
        List<Integer> expected11 = List.of(1, 2, 3, 4);
        assertThat(actual11).isEqualTo(expected11);
        // END
    }

    @Test
    void testTake2() {
        // BEGIN
        List<Integer> numbers2 = new ArrayList<>(Arrays.asList(7, 3, 10));
        List<Integer> actual2 = App.take(numbers2, 8);
        List<Integer> expected2 = List.of(7, 3, 10);
        assertThat(actual2).isEqualTo(expected2);
        // END
    }

    @Test
    void testTake3() {
        // BEGIN
        List<Integer> numbers3 = new ArrayList<>(List.of(0));
        List<Integer> actual3 = App.take(numbers3, 3);
        List<Integer> expected3 = List.of(0);
        assertThat(actual3).isEqualTo(expected3);
        // END
    }

    @Test
    void testTake4() {
        // BEGIN
        List<Integer> numbers3 = new ArrayList<>();
        List<Integer> actual3 = App.take(numbers3, 3);
        List<Integer> expected3 = new ArrayList<>();
        assertThat(actual3).isEqualTo(expected3);
        // END
    }
}
