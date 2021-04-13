package streams.streams;

import org.junit.jupiter.api.Test;

import java.util.Optional;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class FindFirstAnyTest {

    @Test
    void testFindFirstEven(){
        // First even number
        Optional<Integer> firstEven = Stream.of(3, 1, 4, 1, 5, 9, 2, 6, 5)
                .filter(n -> n % 2 == 0)
                .findFirst();

        assertThat(firstEven.get()).isEqualTo(4);
    }

    @Test
    void testFindFirstOnEmptyStream() {
        // findFirst on an empty stream
        Optional<Integer> firstEvenGT10 = Stream.of(3, 1, 4, 1, 5, 9, 2, 6, 5)
                .filter(n -> n > 10)
                .filter(n -> n % 2 == 0)
                .findFirst();

        assertThat(firstEvenGT10).isEqualTo(Optional.empty());
    }

}
