package challenges.immutability;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class NumbersTest {

  @Test
  void testSumIntegers(){
    List<Integer> integers = Arrays.asList(3, 2, 6, null, 9);
    int result = Numbers.sumIntegers(integers);
    Assertions.assertEquals(20, result);
  }

  @Test
  void testIntegersContainNull(){
    List<Integer> integers = Arrays.asList(3, 2, 6 , null, 9);
    boolean result = Numbers.integersContainsNulls(integers);
    Assertions.assertTrue(result);
  }

}
