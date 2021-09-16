package challenges;

import challenges.numbers.Numbers;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class NumbersTest {

    @Test
    void testSumClassicWay(){
        int result = Numbers.sumClassicWay(5, 3);
        assertThat(result).isEqualTo(8);
    }

    @Test
    void testSumWithInteger(){
        int result = Numbers.sumWithInteger(5, 3);
        assertThat(result).isEqualTo(8);
    }

    @Test
    void testSumWithMath(){
        int result = Numbers.sumWithMath(5, 3);
        assertThat(result).isEqualTo(8);
    }

    @Test
    void testSumWithOperator(){
        int result = Numbers.sumWithOperator(5, 3);
        assertThat(result).isEqualTo(8);
    }

    @Test
    void testMinWithInteger(){
        assertThat(Numbers.minWithInteger(5,3)).isEqualTo(3);
    }

    @Test
    void testMinWithMath(){
        assertThat(Numbers.minWithMath(5,3)).isEqualTo(3);
    }

    @Test
    void testMaxWithInteger(){
        assertThat(Numbers.maxWithInteger(5,3)).isEqualTo(5);
    }

    @Test
    void testMaxWithMath(){
        assertThat(Numbers.maxWithMath(5,3)).isEqualTo(5);
    }

    @Test
    void testMaxWithBinaryOperator(){
        assertThat(Numbers.maxWithBinaryOperator(5,3)).isEqualTo(5);
    }

    @Test
    void testMinWithBinaryOperator(){
        assertThat(Numbers.minWithBinaryOperator(5,3)).isEqualTo(3);
    }
}
