package chapter10.grouping;

import chapter06.Dish;
import chapter06.Type;
import chapter10.enums.CaloricLevel;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class GroupingTest {

    @Test
    public void testGroupingByDishTypeAndCaloricLevel(){
        Map<Type, Map<CaloricLevel, List<Dish>>> result = Grouping.groupDishedByTypeAndCaloricLevel2();
        assertThat(result).isNotNull();
    }
}
