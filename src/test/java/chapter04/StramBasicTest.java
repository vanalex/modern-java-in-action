package chapter04;

import static java.util.Comparator.comparing;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import utils.TestFixture;

class StramBasicTest {

  @Test
  void getLowCaloriesDishesNamesTest(){
    List<String> result = TestFixture.menu.stream()
        .filter(dish -> dish.getCalories() < 400)
        .sorted(comparing(Dish::getCalories))
        .map(Dish::getName)
        .collect(Collectors.toList());
    assertThat(result).isEqualTo(List.of("season fruit", "rice"));
  }

  @Test
  void streamCanOnlyBeConsumedOnce(){
    Stream<String> names = Stream.of("Java8", "Lambdas", "Are", "Awesome");
    names.forEach(System.out::println);
    assertThatThrownBy(() -> names.forEach(System.out::println))
        .isInstanceOf(IllegalStateException.class)
        .hasMessageContaining("stream has already been operated upon or closed");

  }
}
