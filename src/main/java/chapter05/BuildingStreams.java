package chapter05;

import java.util.Arrays;
import java.util.function.IntSupplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class BuildingStreams {

  public static void main(String[] args) {
      Stream<String> names = Stream.of("Diego", "Maria", "Lars", "Ulrich");
      names.map(String::toUpperCase).forEach(System.out::println);

      //Stream
      Stream<Integer> numbers = Stream.of(1, 2, 3, 4, 5);
      int sum = numbers.reduce(0, Integer::sum);
      System.out.println("sum -> " + sum);

      //Stream from array
      int[] nums = {1, 2, 3, 4, 5};
      System.out.println(Arrays.stream(nums).sum());

      // Stream.iterate
      Stream.iterate(0, n -> n + 2)
              .limit(10)
              .forEach(System.out::println);

      // Fibonacci with iterate
      Stream.iterate(new int[] { 0, 1 }, t -> new int[] { t[1], t[0] + t[1] })
              .limit(10)
              .forEach(t -> System.out.printf("(%d, %d)", t[0], t[1]));

      Stream.iterate(new int[] { 0, 1 }, t -> new int[] { t[1], t[0] + t[1] })
              .limit(10)
              .map(t -> t[0])
              .forEach(System.out::println);

      // random stream of doubles with Stream.generate
      Stream.generate(Math::random)
              .limit(10)
              .forEach(System.out::println);

      // stream of 1s with Stream.generate
      IntStream.generate(() -> 1)
              .limit(5)
              .forEach(System.out::println);

      IntStream.generate(new IntSupplier() {
          @Override
          public int getAsInt() {
              return 2;
          }
      }).limit(5).forEach(System.out::println);
  }
}
