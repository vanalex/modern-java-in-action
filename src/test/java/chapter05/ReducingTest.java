package chapter05;

import chapter04.Dish;
import org.assertj.core.api.OptionalAssert;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class ReducingTest {

    @Test
    public void testSumListElementsByStreamReduce(){
        List<Integer> numbers = List.of(3, 4, 5, 1, 2);

        int result = numbers.stream().reduce(0, (a, b) -> a+ b);
        assertThat(result).isEqualTo(15);

        int result2 = numbers.stream().reduce(0, Integer::sum);
        assertThat(result2).isEqualTo(15);

        int result3 = numbers.stream().reduce(0, (a, b) -> Integer.max(a, b));
        assertThat(result3).isEqualTo(5);

        Optional<Integer> min = numbers.stream().reduce(Integer::min);
        assertThat(min).isEqualTo(Optional.of(1));
    }
}
