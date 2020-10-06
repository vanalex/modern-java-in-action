package chapter06;

import java.util.Comparator;

public class DishHelper {

    public static final Comparator<Dish> dishCaloriesComprarator = Comparator.comparingInt(Dish::getCalories);
}
