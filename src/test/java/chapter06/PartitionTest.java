package chapter06;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static chapter06.DishFactory.menu;
import static java.util.stream.Collectors.groupingBy;
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

    @Test
    public void testPartitionByDishType(){
        Map<Boolean, Map<Type, List<Dish>>> result = vegetarianDishesByType();
        assertThat(result).isNotNull();
        assertThat(result.get(false).size()).isEqualTo(2);
        Map<Type, List<Dish>> dish = result.get(false);
        List<Dish> fish = dish.get(Type.FISH);
        assertThat(fish.size()).isEqualTo(2);
        List<Dish> meat = dish.get(Type.MEAT);
        assertThat(meat.size()).isEqualTo(3);

        assertThat(result.get(true).size()).isEqualTo(1);
        Map<Type, List<Dish>> veg = result.get(true);
    }

    private static Map<Boolean, Map<Type, List<Dish>>> vegetarianDishesByType() {
        return menu.stream().collect(partitioningBy(Dish::isVegetarian, groupingBy(Dish::getType)));
    }
}
