package chapter05;

import static java.util.stream.Collectors.toList;

import chapter04.Dish;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import utils.TestFixture;

class FilteringTest {
  @Test
  void isVeggieTest(){
    List<Dish> dishList = TestFixture.menu.stream()
        .filter(Dish::isVegetarian)
        .collect(toList());

    Assertions.assertThat(dishList).isNotEmpty();
  }

  @Test
  void uniqueElementsTest(){
    List<Integer> uniqueElements = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19)
        .stream()
        .filter(number -> number % 2 == 0)
        .distinct()
        .collect(toList());

    Assertions.assertThat(uniqueElements).isEqualTo(List.of(2, 4, 6, 8, 10, 12, 14, 16, 18));
  }

  @Test
  void sclicedMenuTest(){
    List<Dish> slicedMenu = TestFixture.specialMenu.stream()
        .filter(dish -> dish.getCalories() < 320)
        .collect(toList());

    Assertions.assertThat(slicedMenu.get(0).getCalories()).isLessThan(320);
    Assertions.assertThat(slicedMenu.get(0).getCalories()).isLessThan(320);
  }

  @Test
  void menuTest2(){
    List<Dish> slicedMenu = TestFixture.specialMenu.stream()
        .takeWhile(dish -> dish.getCalories() > 300)
        .collect(toList());

    Assertions.assertThat(slicedMenu.get(0).getCalories()).isGreaterThan(300);

  }

  @Test
  void filteringUniqueElementsTest(){
    // Filtering unique elements
    List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
    List<Integer> result = numbers.stream()
        .filter(i -> i % 2 == 0)
        .distinct()
        .collect(Collectors.toList());
    Assertions.assertThat(result).isEqualTo(List.of(2, 4));
  }
}
