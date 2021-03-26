package streams.streams;

import org.junit.jupiter.api.Test;
import streams.StreamUtils;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class StreamTest {

    @Test
    void testStreamConcatetantionWithSameType(){
        Stream<String> first = Stream.of("a", "b", "c");
        Stream<String> second = Stream.of("X", "Y", "Z");
        assertThat(StreamUtils.concat(first,second).collect(Collectors.toList())).isEqualTo(Stream.of("a", "b", "c", "X", "Y", "Z").collect(Collectors.toList()));
    }

    @Test
    void testStreamConcatetantionWithDifferentType(){
        Stream<String> first = Stream.of("a", "b", "c");
        Stream<Integer> second = Stream.of(1, 2, 3);
        assertThat(StreamUtils.concat(first,second).collect(Collectors.toList())).isEqualTo(Stream.of("a", "b", "c", 1, 2, 3).collect(Collectors.toList()));
    }

    @Test
    void testThreeStreamConcatetantion(){
        Stream<String> first = Stream.of("a", "b", "c");
        Stream<String> second = Stream.of("1", "2", "3");
        Stream<String> third = Stream.of("alpha", "beta", "gamma");
        List<String> allThree = Stream.concat(Stream.concat(first, second), third).collect(Collectors.toList());
        assertThat(allThree).isEqualTo(List.of("a", "b", "c", "1", "2", "3", "alpha", "beta", "gamma"));
    }
}
