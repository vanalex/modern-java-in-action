package chapter05;

import chapter04.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;

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

    }
}
