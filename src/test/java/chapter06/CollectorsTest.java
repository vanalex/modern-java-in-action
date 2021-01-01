package chapter06;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.function.BinaryOperator;

import static chapter06.DishFactory.menu;
import static java.util.stream.Collectors.*;
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

    @Test
    public void calculateTotalCalories(){
        int totalCalories = menu.stream().collect(summingInt(Dish::getCalories));
        assertThat(totalCalories).isEqualTo(4300);
    }

    @Test
    public void testCalculateAverageCalories(){
        Double averageCalories = menu.stream().collect(averagingInt(Dish::getCalories));
        assertThat(averageCalories).isEqualTo(477.77777777777777);
    }

    @Test
    public void testShowStatistics(){
        IntSummaryStatistics intSummaryStatistics = menu.stream().collect(summarizingInt(Dish::getCalories));
        System.out.println(intSummaryStatistics.toString());
        assertThat(intSummaryStatistics.getAverage()).isEqualTo(477.77777777777777);
        assertThat(intSummaryStatistics.getCount()).isEqualTo(9);
        assertThat(intSummaryStatistics.getMax()).isEqualTo(800);
        assertThat(intSummaryStatistics.getMin()).isEqualTo(120);
        assertThat(intSummaryStatistics.getSum()).isEqualTo(4300);
    }

    @Test
    public void test(){
        String menuDescription = menu.stream().map(Dish::getName).collect(joining());
        assertThat(menuDescription).isEqualTo("porkbeefchickenfrench friesriceseason fruitpizzaprawnssalmon");
    }

    @Test
    public void test2(){
        String menuDescription = menu.stream().map(Dish::getName).collect(joining(","));
        assertThat(menuDescription).isEqualTo("pork,beef,chicken,french fries,rice,season fruit,pizza,prawns,salmon");
    }

}
