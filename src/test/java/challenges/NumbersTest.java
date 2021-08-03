package challenges;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class NumbersTest {

    @Test
    void testreturnMinimumByInteger(){
        int result = Numbers.returnMinimumByInteger(5,3);
        assertThat(result).isEqualTo(3);
    }

    @Test
    void testreturnMinimumByMath(){
        int result = Numbers.returnMinimumByMath(5,3);
        assertThat(result).isEqualTo(3);
    }

    @Test
    void testreturnMinimumByBinaryOperator(){
        int result = Numbers.returnMinimumByBinnaryOperator(5,3);
        assertThat(result).isEqualTo(3);
    }

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
}
