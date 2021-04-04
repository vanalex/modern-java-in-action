package streams.streams;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class CreatingStreamsTest {

    @Test
    void testCreateStringThroughStreamByJoining(){
        String names = Stream.of("Gomez", "Morticia", "Wednesday", "Pugsley")
                .collect(Collectors.joining(","));
        assertThat(names).isEqualTo("Gomez,Morticia,Wednesday,Pugsley");
    }

    @Test
    void testCreateStringThroughStreamUsingArrayStreamByJoining(){
        String[] munsters = {"Herman", "Lily", "Eddie", "Marilyn", "Grandpa"};
        String names = Arrays.stream(munsters)
                .collect(Collectors.joining(","));
        assertThat(names).isEqualTo("Herman,Lily,Eddie,Marilyn,Grandpa");
    }

    @Test
    void testCreateBigDecimalListUsingStreamIterate() {
        List<BigDecimal> nums = Stream.iterate(BigDecimal.ONE, n -> n.add(BigDecimal.ONE))
                .limit(10)
                .collect(Collectors.toList());
        assertThat(nums).isEqualTo(Arrays.asList(BigDecimal.ONE, BigDecimal.valueOf(2), BigDecimal.valueOf(3), BigDecimal.valueOf(4),
                BigDecimal.valueOf(5), BigDecimal.valueOf(6), BigDecimal.valueOf(7), BigDecimal.valueOf(8), BigDecimal.valueOf(9), BigDecimal.valueOf(10)));
    }
}
