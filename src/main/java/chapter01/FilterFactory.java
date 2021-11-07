package chapter01;

import chapter01.domain.Apple;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class FilterFactory {

    public static List<Apple> filterApples(List<Apple> inventory, Predicate<Apple> p) {
        List<Apple> result = new ArrayList<>();
        inventory.forEach( apple -> {
            if (p.test(apple)) {
                result.add(apple);
            }
        });

        return result;
    }

    public static boolean isGreenApple(Apple apple) {
        return "green".equals(apple.getColor());
    }

    public static boolean isHeavyApple(Apple apple) {
        return apple.getWeight() > 150;
    }
}
