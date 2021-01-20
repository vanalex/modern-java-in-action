package chapter10.grouping;

import chapter06.Dish;
import chapter06.Type;
import chapter10.enums.CaloricLevel;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collector;

import static chapter06.DishFactory.menu;
import static java.util.stream.Collectors.groupingBy;

public class Grouping {

    private static CaloricLevel getCaloricLevel(Dish dish ) {
        if (dish.getCalories() <= 400) {
            return CaloricLevel.DIET;
        }
        else if (dish.getCalories() <= 700) {
            return CaloricLevel.NORMAL;
        }
        else {
            return CaloricLevel.FAT;
        }
    }

    public static Map<Type, Map<CaloricLevel, List<Dish>>> groupDishedByTypeAndCaloricLevel2() {
        return menu.stream().collect(
                twoLevelGroupingBy(Dish::getType, dish -> getCaloricLevel(dish))
        );
    }

    public static <A, B, T> Collector<T, ?, Map<A, Map<B, List<T>>>> twoLevelGroupingBy(Function<? super T, ? extends A> f1, Function<? super T, ? extends B> f2) {
        return groupingBy(f1, groupingBy(f2));
    }
}
