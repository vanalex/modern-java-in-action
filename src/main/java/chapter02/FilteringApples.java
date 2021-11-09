package chapter02;

import java.util.Arrays;
import java.util.List;

import static chapter02.FilterFactory.filter;
import static chapter02.FilterFactory.filterApplesByColor;

public class FilteringApples {

  public static void main(String... args) {
    List<Apple> inventory = Arrays.asList(
        new Apple(80, Color.GREEN),
        new Apple(155, Color.GREEN),
        new Apple(120, Color.RED));

    // [Apple{color=GREEN, weight=80}, Apple{color=GREEN, weight=155}]
    List<Apple> greenApples = filterApplesByColor(inventory, Color.GREEN);
    System.out.println(greenApples);

    // [Apple{color=RED, weight=120}]
    List<Apple> redApples = filterApplesByColor(inventory, Color.RED);
    System.out.println(redApples);

    // [Apple{color=GREEN, weight=80}, Apple{color=GREEN, weight=155}]
    List<Apple> greenApples2 = filter(inventory, new AppleColorPredicate());
    System.out.println(greenApples2);

    // [Apple{color=GREEN, weight=155}]
    List<Apple> heavyApples = filter(inventory, new AppleWeightPredicate());
    System.out.println(heavyApples);

    // []
    List<Apple> redAndHeavyApples = filter(inventory, new AppleRedAndHeavyPredicate());
    System.out.println(redAndHeavyApples);

    // [Apple{color=RED, weight=120}]
    List<Apple> redApples2 = filter(inventory, new ApplePredicate() {
      @Override
      public boolean test(Apple a) {
        return a.getColor() == Color.RED;
      }
    });
    System.out.println(redApples2);
  }

}
