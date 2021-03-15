package streamex;

import chapter06.Dish;
import one.util.streamex.StreamEx;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static chapter06.DishFactory.menu;
import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

public class StreamexTest {

    @Test
    public void testMap(){
        List<String> expected = List.of("pork", "beef", "chicken", "french fries", "rice", "season fruit", "pizza", "prawns", "salmon");
        List<String> dishNames = StreamEx.of(menu).map(Dish::getName).toList();
        assertThat(dishNames).isEqualTo(expected);
    }

    @Test
    public void testGroupingBy(){
        Set<String> expected = Set.of("season fruit", "chicken", "pizza", "salmon", "beef", "rice", "pork", "prawns", "french fries");
        Map<String, List<Dish>> name2Dish = StreamEx.of(menu).groupingBy(Dish::getName);
        assertThat(name2Dish.keySet()).isEqualTo(expected);
    }

    @Test
    public void testSelect(){
        assertThat(asList("a", "b")).isEqualTo(StreamEx.of(1, "a", 2, "b", 3, "cc").select(String.class).filter(s -> s.length() == 1).toList());
    }

    @Test
    public void testIterateWithUnaryOperatorAndLimit() {
        assertThat(asList("a", "aa", "aaa", "aaaa")).isEqualTo( StreamEx.iterate("a", x -> x + "a").limit(4).toList());
    }

    @Test
    public void testEmptyList() {
        assertThat(List.of()).isEqualTo( StreamEx.empty().toList());
        assertThat(asList()).isEqualTo( StreamEx.empty().toList());
    }
}
