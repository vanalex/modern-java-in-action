package streams.streams;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;
import static org.assertj.core.api.Assertions.assertThat;

public class GroupingTest {

    List<String> strings;

    @BeforeEach
    public void init(){
        strings = Arrays.asList("this", "is", "a", "long", "list", "of",
                "strings", "to", "use", "as", "a", "demo");
    }

    @Test
    void testGroupingByLength(){
        Map<Integer, List<String>> lengthMap = strings.stream()
                .collect(groupingBy(String::length));

        assertThat(lengthMap.get(1).get(0)).isEqualTo("a");
        assertThat(lengthMap.get(1).get(1)).isEqualTo("a");
        assertThat(lengthMap.get(2).get(0)).isEqualTo("is");
        assertThat(lengthMap.get(2).get(1)).isEqualTo("of");
        assertThat(lengthMap.get(2).get(2)).isEqualTo("to");
        assertThat(lengthMap.get(2).get(3)).isEqualTo("as");
        assertThat(lengthMap.get(2).get(3)).isEqualTo("as");
        assertThat(lengthMap.get(3).get(0)).isEqualTo("use");
        assertThat(lengthMap.get(4).get(0)).isEqualTo("this");
        assertThat(lengthMap.get(4).get(1)).isEqualTo("long");
        assertThat(lengthMap.get(4).get(2)).isEqualTo("list");
        assertThat(lengthMap.get(4).get(3)).isEqualTo("demo");
    }
}
