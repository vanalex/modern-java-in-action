package chapter05;

import chapter04.Dish;

import java.util.OptionalInt;
import java.util.stream.IntStream;

import static chapter04.Dish.menu;

public class NumericStreams {

    public static void main(String[] args) {
        int calories = menu.stream()
                .mapToInt(Dish::getCalories)
                .sum();
        System.out.println("Number of calories: " + calories);

        // max and OptionalInt
        OptionalInt maxCalories = menu.stream()
                .mapToInt(Dish::getCalories)
                .max();
        int max = maxCalories.getAsInt();
        System.out.println(max);

        //numeric ranges
        IntStream evenNumbers = IntStream.rangeClosed(1, 100)
                .filter(n -> n % 2 == 0);
        System.out.println(evenNumbers.count());

    }
}
