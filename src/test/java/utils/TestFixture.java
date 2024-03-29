package utils;

import chapter04.Dish;
import chapter04.Dish.Type;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class TestFixture<T> {

    public static <T> List<T> createList(T...t){
        return List.of(t);
    }

    public static final List<Dish> menu = Arrays.asList(
        new Dish("pork", false, 800, Type.MEAT),
        new Dish("beef", false, 700, Type.MEAT),
        new Dish("chicken", false, 400, Type.MEAT),
        new Dish("french fries", true, 530, Type.OTHER),
        new Dish("rice", true, 350, Type.OTHER),
        new Dish("season fruit", true, 120, Type.OTHER),
        new Dish("pizza", true, 550, Type.OTHER),
        new Dish("prawns", false, 400, Type.FISH),
        new Dish("salmon", false, 450, Type.FISH)
    );

    public static List<Dish> specialMenu = Arrays.asList(
        new Dish("season fruit", true, 120, Dish.Type.OTHER),
        new Dish("prawns", false, 300, Dish.Type.FISH),
        new Dish("rice", true, 350, Dish.Type.OTHER),
        new Dish("chicken", false, 400, Dish.Type.MEAT),
        new Dish("french fries", true, 530, Dish.Type.OTHER));

    public static <T> Stream<T> createStream(T...values){
        return Stream.of(values);
    }
}
