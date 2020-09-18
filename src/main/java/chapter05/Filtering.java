package chapter05;

import chapter04.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static chapter04.Dish.menu;
import static java.util.stream.Collectors.toList;

public class Filtering {

  public static void main(String[] args) {
    System.out.println("Filtering with Predicates");
    menu.stream()
            .filter(Dish::isVegetarian)
            .collect(Collectors.toList())
            .forEach(System.out::println);

    System.out.println("Filtering unique elements");
    Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19)
            .stream()
            .filter(number -> number % 2 == 0)
            .distinct()
            .forEach(System.out::println);

      // Slicing a stream
      // This list is sorted in ascending order of number of calories!
      List<Dish> specialMenu = Arrays.asList(
              new Dish("season fruit", true, 120, Dish.Type.OTHER),
              new Dish("prawns", false, 300, Dish.Type.FISH),
              new Dish("rice", true, 350, Dish.Type.OTHER),
              new Dish("chicken", false, 400, Dish.Type.MEAT),
              new Dish("french fries", true, 530, Dish.Type.OTHER));
      System.out.println("Filtered sorted menu:");
      List<Dish> slicedMenu = specialMenu.stream()
              .filter(dish -> dish.getCalories() < 320)
              .collect(toList());
      slicedMenu.forEach(System.out::println);

      List<Dish> slicedMenu2 = specialMenu.stream()
              .takeWhile(dish -> dish.getCalories() < 320)
              .collect(toList());
      slicedMenu2.forEach(System.out::println);



  }
}
