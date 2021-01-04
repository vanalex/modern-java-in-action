package chapter06;

import org.junit.jupiter.api.Test;

import static chapter06.DishFactory.menu;
import static java.util.stream.Collectors.reducing;
import static org.assertj.core.api.Assertions.assertThat;

public class ReducingTest {

    @Test
    public void testCalculateTotalCalories(){
        int result = calculateTotalCalories();
        assertThat(result).isEqualTo(4300);
    }

    @Test
    public void testCalculateTotalCaloriesWithMethodReference(){
        int result = calculateTotalCaloriesWithMethodReference();
        assertThat(result).isEqualTo(4300);
    }

    @Test
    public void testCalculateTotalCaloriesWithoutCollectors(){
        int result = calculateTotalCaloriesWithoutCollectors();
        assertThat(result).isEqualTo(4300);
    }

    @Test
    public void testCalculateTotalCaloriesUsingSum(){
        int result = calculateTotalCaloriesUsingSum();
        assertThat(result).isEqualTo(4300);
    }

    private static int calculateTotalCalories() {
        return menu.stream().collect(reducing(0, Dish::getCalories, (Integer i, Integer j) -> i + j));
    }

    private static int calculateTotalCaloriesWithMethodReference() {
        return menu.stream().collect(reducing(0, Dish::getCalories, Integer::sum));
    }

    private static int calculateTotalCaloriesWithoutCollectors() {
        return menu.stream().map(Dish::getCalories).reduce(Integer::sum).get();
    }

    private static int calculateTotalCaloriesUsingSum() {
        return menu.stream().mapToInt(Dish::getCalories).sum();
    }

}
