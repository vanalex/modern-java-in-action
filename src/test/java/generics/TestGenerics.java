package generics;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class TestGenerics {

    @Test
    public void testSumGivenListOfInts(){
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
        GenericsUtil genericsUtil = new GenericsUtil(integers);
        double result = genericsUtil.sumListAsDoubles();
        assertThat(result).isEqualTo(15.0);
    }

    @Test
    public void testSumGivenListOfDoubles(){
        List<Double> doubles = Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0);
        GenericsUtil genericsUtil = new GenericsUtil(doubles);
        double result = genericsUtil.sumListAsDoubles();
        assertThat(result).isEqualTo(15.0);
    }

    @Test
    public void testSumGivenListOfBigDecimals(){
        List<BigDecimal> bigDecimalList = Arrays.asList(
                new BigDecimal("1.0"),
                new BigDecimal("2.0"),
                new BigDecimal("3.0"),
                new BigDecimal("4.0"),
                new BigDecimal("5.0"));

        GenericsUtil genericsUtil = new GenericsUtil(bigDecimalList);
        double result = genericsUtil.sumListAsDoubles();
        assertThat(result).isEqualTo(15.0);
    }
}
