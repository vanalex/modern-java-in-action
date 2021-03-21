package generics;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;

import static generics.Comparators.max;
import static generics.Comparators.sizeOrder;
import static generics.Comparators.min;
import static org.assertj.core.api.Assertions.assertThat;

class ComparatorsTest {

    @Test
    void testMax(){
        Collection<String> strings = Arrays.asList("from","aaa","to","zzz");
        String result = max(strings, Comparator.naturalOrder());
        assertThat(result).isEqualTo("zzz");
    }

    @Test
    void testMin(){
        Collection<String> strings = Arrays.asList("from","aaa","to","zzz");
        String result = Comparators.min(strings, Comparator.naturalOrder());
        assertThat(result).isEqualTo("aaa");
    }

    @Test
    void testNaturalOrder(){
        Collection<String> strings = Arrays.asList("from","aaa","to","zzz");
        String result = max(strings);
        assertThat(result).isEqualTo("zzz");
    }

    @Test
    void testReverseOrder(){
        Collection<String> strings = Arrays.asList("from","aaa","to","zzz");
        String result = Comparators.min(strings);
        assertThat(result).isEqualTo("aaa");
    }

    @Test
    void testMaxWithSizeOrder(){
        Collection<String> strings = Arrays.asList("from","aaa","to","zzz");
        assertThat(max(strings, sizeOrder())).isEqualTo("from");
    }

    @Test
    void testMinWithSizeOrder(){
        Collection<String> strings = Arrays.asList("from","aaa","to","zzz");
        assertThat(min(strings, sizeOrder())).isEqualTo("to");
    }
}
