package challenges.numbers;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class NumbersTest {

  @Test
  void testSumIntegers(){
    List<Integer> integers = List.of(3, 2, 6 , null, 9);
    int result = Numbers.sumIntegers(integers);
    Assertions.assertEquals(20, result);
  }
}
