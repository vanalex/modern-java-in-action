package chapter05;

import chapter04.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static chapter04.Dish.menu;
import static java.util.stream.Collectors.toList;

public class Mapping {
  public static void main(String[] args) {
    menu.stream()
            .map(Dish::getName)
            .collect(Collectors.toList())
            .forEach(System.out::println);

      menu.stream()
              .map(Dish::getName)
              .map(name -> name.length())
              .collect(Collectors.toList())
              .forEach(System.out::println);

      List<String> words = Arrays.asList("Hello", "World");

      // flatMap
      words.stream()
              .flatMap((String line) -> Arrays.stream(line.split("")))
              .distinct()
              .forEach(System.out::println);

      // flatMap
      List<Integer> numbers1 = Arrays.asList(1,2,3,4,5);
      List<Integer> numbers2 = Arrays.asList(6,7,8);
      List<int[]> pairs = numbers1.stream()
              .flatMap((Integer i) -> numbers2.stream()
                      .map((Integer j) -> new int[]{i, j})
              )
              .filter(pair -> (pair[0] + pair[1]) % 3 == 0)
              .collect(toList());
      pairs.forEach(pair -> System.out.printf("(%d, %d)", pair[0], pair[1]));
  }
}
