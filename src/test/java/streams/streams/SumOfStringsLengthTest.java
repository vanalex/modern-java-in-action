package streams.streams;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class SumOfStringsLengthTest {

    @Test
    void testCountStringsLength(){
        String[] strings = "this is an array of strings".split(" ");
        long count = Arrays.stream(strings)
                .map(String::length)
                .count();
        assertThat(count).isEqualTo(6);
    }

    @Test
    void testCountStringsLengthWithMapToInt(){
        String[] strings = "this is an array of strings".split(" ");
        long count = Arrays.stream(strings)
                .mapToInt(String::length)
                .count();
        assertThat(count).isEqualTo(6);
    }
}
