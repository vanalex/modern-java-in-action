package streams.streams;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

class BoxedStreamsTest {

    @Test
    void testRangeBoxedIntStream(){
        List<Integer> expected = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> intList = IntStream.rangeClosed(1, 10)
                .mapToObj(Integer::valueOf)
                .collect(Collectors.toList());

        assertThat(intList).isEqualTo(expected);

        List<Integer> ints = IntStream.of(3, 1, 4, 1, 5, 9)
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);

    }

    @Test
    void testIntStream(){
        List<Integer> expected = List.of(3, 1, 4, 1, 5, 9);
        List<Integer> ints = IntStream.of(3, 1, 4, 1, 5, 9)
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        assertThat(ints).isEqualTo(expected);

    }

    @Test
    void testBoxedIntStream(){
        List<Integer> expected = List.of(3, 1, 4, 1, 5, 9);
        List<Integer> listOfInt = IntStream.of(3, 1, 4, 1, 5, 9).boxed().collect(Collectors.toList());
        assertThat(listOfInt).isEqualTo(expected);
    }
}
