package chapter06;

import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;

import static chapter06.DishFactory.menu;
import static java.util.stream.Collectors.counting;
import static org.assertj.core.api.Assertions.assertThat;

public class CollectorsTest {

    @Test
    public void testHowManyDishes(){
        long numberOfDishes = menu.stream().collect(counting());
        assertThat(numberOfDishes).isEqualTo(9L);
    }
}
