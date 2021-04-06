package streams.streams;

import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class CoutingElementsTest {

    @Test
    void testStreamCount(){
        long count = Stream.of(3, 1, 4, 1, 5, 9, 2, 6, 5)
                .count();
        assertThat(count).isEqualTo(9);
    }

    @Test
    void testStreamCollectorCount(){
        long count = Stream.of(3, 1, 4, 1, 5, 9, 2, 6, 5).count();
        assertThat(count).isEqualTo(9);
    }
}
