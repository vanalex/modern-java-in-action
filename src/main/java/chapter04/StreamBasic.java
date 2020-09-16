package chapter04;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;

public class StreamBasic {

  public static void main(String[] args) {
      getStreamAndIterate();
      getLowCaloriesDishesNames();
      streamCanOnlyBeConsumedOnce();
  }

  private static void getStreamAndIterate(){
      Dish.menu.forEach(System.out::println);
  }

  private static void getLowCaloriesDishesNames(){
      Dish.menu.stream()
      .filter(dish -> dish.getCalories() < 400)
      .sorted(comparing(Dish::getCalories))
      .map(Dish::getName)
      .collect(Collectors.toList())
      .forEach(System.out::println);
  }

  private static void streamCanOnlyBeConsumedOnce(){
      List<String> names = Arrays.asList("Java8", "Lambdas", "Are", "Awesome");
      Stream<String> s = names.stream();
      s.forEach(System.out::println);
      // uncommenting this line will result in an IllegalStateException
      // because streams can be consumed only once
      //s.forEach(System.out::println);
  }
}
