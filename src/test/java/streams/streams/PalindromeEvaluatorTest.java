package streams.streams;

import org.junit.jupiter.api.Test;
import streams.PalindromeEvaluator;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class PalindromeEvaluatorTest {

    @Test
    void testEvaluator(){
        PalindromeEvaluator evaluator = new PalindromeEvaluator();
        boolean result = Stream.of("Madam, in Eden, I'm Adam",
                "Go hang a salami; I'm a lasagna hog",
                "A Santa pets rats as Pat taps a star step at NASA")
                .allMatch(evaluator::isPalindrome);

        assertThat(result).isTrue();
    }
}
