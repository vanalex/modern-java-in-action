package chapter05;

import static java.util.stream.Collectors.toList;

import chapter04.Dish;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.MutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import utils.TestFixture;

public class MappingTest {

  @Test
  void test(){
    List<String> result = TestFixture.menu.stream()
        .map(Dish::getName)
        .collect(toList());

    Assertions.assertThat(result).isEqualTo(List.of("pork", "beef", "chicken", "french fries", "rice", "season fruit", "pizza", "prawns", "salmon"));

    List<Integer> res = TestFixture.menu.stream()
        .map(Dish::getName)
        .map(name -> name.length())
        .collect(toList());

    Assertions.assertThat(res).isEqualTo(List.of(4, 4, 7, 12, 4, 12, 5, 6, 6));

    List<String> words = Arrays.asList("Hello", "World");

    // flatMap
    List<String> wordaList = words.stream()
        .flatMap((String line) -> Arrays.stream(line.split("")))
        .distinct()
        .collect(Collectors.toList());

    Assertions.assertThat(wordaList).isEqualTo(List.of("H", "e", "l", "o", "W", "r", "d"));

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
