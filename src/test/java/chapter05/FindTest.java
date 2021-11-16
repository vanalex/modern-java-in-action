package chapter05;

import chapter04.Dish;
import java.util.Optional;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import utils.TestFixture;

class FindTest {

  @Test
  void testIsVegetarianFriendlyMenu(){
    Assertions.assertThat(isVegetarianFriendlyMenu()).isTrue();
  }

  @Test
  void testIsHealthyMenu(){
    Assertions.assertThat(isHealthyMenu()).isTrue();
  }

  @Test
  void testIsHealthyMenu2(){
    Assertions.assertThat(isHealthyMenu2()).isTrue();
  }

  @Test
  void testIsVeggieDish(){
    Optional<Dish> dish = findVegetarianDish();
    Assertions.assertThat(dish.isPresent()).isTrue();
  }

  private static boolean isVegetarianFriendlyMenu(){ return TestFixture.menu.stream().anyMatch(Dish::isVegetarian); }

  private static boolean isHealthyMenu() {
    return TestFixture.menu.stream().allMatch(d -> d.getCalories() < 1000);
  }
  private static boolean isHealthyMenu2() {
    return TestFixture.menu.stream().noneMatch(d -> d.getCalories() >= 1000);
  }
  private static Optional<Dish> findVegetarianDish() {
    return TestFixture.menu.stream().filter(Dish::isVegetarian).findAny();
  }

}
