package chapter06;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static chapter06.DishFactory.menu;
import static java.util.stream.Collectors.partitioningBy;
import static org.assertj.core.api.Assertions.assertThat;

public class PartitionTest {

    @Test
    public void testPartitionByVegetarian(){
        Map<Boolean, List<Dish>> vegetarianDish = menu.stream().collect(partitioningBy(Dish::isVegetarian));
        assertThat(vegetarianDish).isNotNull();
        assertThat(vegetarianDish.get(false).size()).isEqualTo(5);
        assertThat(vegetarianDish.get(true).size()).isEqualTo(4);
    }
}
