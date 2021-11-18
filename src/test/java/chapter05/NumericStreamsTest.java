package chapter05;

import chapter04.Dish;
import java.util.stream.IntStream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import utils.TestFixture;

public class NumericStreamsTest {

  @Test
  void testSumCalories() {
    int calories = TestFixture.menu.stream()
        .mapToInt(Dish::getCalories)
        .sum();
    Assertions.assertThat(calories).isEqualTo(4300);
  }

  @Test
  void testMaxCalories() {
    int calories = TestFixture.menu.stream()
        .mapToInt(Dish::getCalories)
        .sum();
    Assertions.assertThat(calories).isEqualTo(4300);
  }

    @Test
    void testEvenNumberCount(){
      IntStream evenNumbers = IntStream.rangeClosed(1, 100)
          .filter(n -> n % 2 == 0);
      Assertions.assertThat(evenNumbers.count()).isEqualTo(50);
    }


    /*Stream<int[]> pythagoreanTriples = IntStream.rangeClosed(1, 100).boxed()
        .flatMap(a -> IntStream.rangeClosed(a, 100)
            .filter(b -> Math.sqrt(a * a + b * b) % 1 == 0).boxed()
            .map(b -> new int[] { a, b, (int) Math.sqrt(a * a + b * b) }));
    pythagoreanTriples.forEach(t -> System.out.println(t[0] + ", " + t[1] + ", " + t[2]));

    Stream<int[]> pythagoreanTriples2 = IntStream.rangeClosed(1, 100).boxed()
        .flatMap(a -> IntStream.rangeClosed(a, 100)
            .mapToObj(b -> new double[]{a, b, Math.sqrt(a * a + b * b)})
            .filter(t -> t[2] % 1 == 0))
        .map(array -> Arrays.stream(array).mapToInt(a -> (int) a).toArray());
    pythagoreanTriples2.forEach(t -> System.out.println(t[0] + ", " + t[1] + ", " + t[2]));
*/
}
