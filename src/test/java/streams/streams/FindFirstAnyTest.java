package streams.streams;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;
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

    @Test
    void testUnordered() {
        List<Integer> expected = List.of(3, 1, 4, 1, 5, 9, 2, 6, 5);
        List<Integer> result = Stream.of(3, 1, 4, 1, 5, 9, 2, 6, 5)
                .unordered()
                .collect(Collectors.toList());
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void testOrdered() {
        List<Integer> expected = List.of(1, 1, 2, 3, 4, 5, 5, 6, 9);
        List<Integer> result = Stream.of(3, 1, 4, 1, 5, 9, 2, 6, 5)
                .sorted()
                .collect(Collectors.toList());
        assertThat(result).isEqualTo(expected);

        Optional<Integer> any = Stream.of(3, 1, 4, 1, 5, 9, 2, 6, 5)
                .unordered()
                .map(FindFirstAnyTest::delay)
                .findAny();

        System.out.println("Sequential Any: " + any);
    }

    @Test
    void testSequentialAny() {
        Optional<Integer> any = Stream.of(3, 1, 4, 1, 5, 9, 2, 6, 5)
                .unordered()
                .map(FindFirstAnyTest::delay)
                .findAny();
        assertThat(any).isEqualTo(Optional.of(3));
    }

    @Test
    void testParallel() {
        Set<String> words = new HashSet<>();
        words.addAll(Arrays.asList("this", "is", "a", "stream", "of", "strings"));
        Optional<String> firstString = words.stream()
                .parallel() // doesn't change anything in Java 8
                .findFirst();
        assertThat(firstString.get()).isEqualTo("this");
    }

    @Test
    void test(){
     Optional<String> firstString = Stream.of("this", "is", "a", "stream", "of", "strings")
                .unordered()
                .findFirst();

        assertThat(firstString.get()).isEqualTo("this");
    }

    private static Integer delay(Integer n) {
        try {
            System.out.println(Thread.currentThread().getName());
            Thread.sleep((long) (Math.random() * 100));
        } catch (InterruptedException ignored) {
        }
        return n;
    }
}
