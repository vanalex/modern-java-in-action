package chapter06;

import org.junit.jupiter.api.Test;

import static chapter06.DishFactory.menu;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.reducing;
import static org.assertj.core.api.Assertions.assertThat;

public class SummarizingTest {

    @Test
    public void testHowManyDishes(){
        long result = menu.stream().collect(counting());
        assertThat(result).isEqualTo(9L);
    }

    @Test
    public void testMostCaloricDish(){
        Dish result = menu.stream().collect(reducing((d1, d2) -> d1.getCalories() > d2.getCalories() ? d1: d2)).get();
        assertThat(result.getType()).isEqualTo(Type.MEAT);
        assertThat(result.getCalories()).isEqualTo(800);
        assertThat(result.getName()).isEqualTo("pork");
        assertThat(result.isVegetarian()).isEqualTo(Boolean.FALSE.booleanValue());
    }
}
