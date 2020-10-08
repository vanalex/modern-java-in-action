package chapter06;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.function.BinaryOperator;

import static chapter06.DishFactory.menu;
import static chapter06.DishHelper.dishCaloriesComprarator;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.reducing;
import static org.assertj.core.api.Assertions.assertThat;

public class CollectorsTest {

    @Test
    public void testHowManyDishes(){
        long numberOfDishes = menu.stream().collect(counting());
        assertThat(numberOfDishes).isEqualTo(9L);
    }

    @Test
    public void findMostCaloricDish(){
        Dish dish = menu.stream().reduce((d1, d2) -> d1.getCalories() > d2.getCalories() ? d1 : d2).get();
        Dish expected = menu.get(0);
        assertThat(dish).isEqualToComparingFieldByField(expected);
    }

    @Test
    public void findMostCaloricDishUsingComparator(){
        Dish expected = menu.get(0);
        Comparator<Dish> dishCaloriesComparator = Comparator.comparingInt(Dish::getCalories);
        BinaryOperator<Dish> moreCaloricOf = BinaryOperator.maxBy(dishCaloriesComparator);
        Dish result = menu.stream().collect(reducing(moreCaloricOf)).get();
        assertThat(result).isEqualToComparingFieldByField(expected);
    }
}
