package chapter06;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;
import static org.assertj.core.api.Assertions.assertThat;

public class GroupingTest {

    @Test
    public void testGroupDishByType(){
        Map<Type, List<Dish>> dishByType = groupDishesByType();
        assertThat(dishByType.get(Type.FISH).size()).isEqualTo(2);
        assertThat(dishByType.get(Type.OTHER).size()).isEqualTo(4);
        assertThat(dishByType.get(Type.MEAT).size()).isEqualTo(3);
    }

    private static Map<Type, List<Dish>> groupDishesByType() {
        return DishFactory.menu.stream().collect(groupingBy(Dish::getType));
    }
}
