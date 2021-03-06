package streams.streams;

import org.junit.jupiter.api.Test;
import streams.CharSequenceUtil;
import streams.MapUtil;
import streams.StreamUtils;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class CreatingStreamsTest {

    @Test
    void testCreateStringThroughStreamByJoining(){
        CharSequence names = CharSequenceUtil.of(Stream.of("Gomez", "Morticia", "Wednesday", "Pugsley"));
        assertThat(names).isEqualTo("Gomez,Morticia,Wednesday,Pugsley");
    }

    @Test
    void testCreateStringThroughStreamUsingArrayStreamByJoining(){
        String[] munsters = {"Herman", "Lily", "Eddie", "Marilyn", "Grandpa"};
        CharSequence names = CharSequenceUtil.of(munsters);
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

    @Test
    void testStreamIterate(){
        List<String> expected = List.of("2021-01-01", "2021-02-01", "2021-03-01", "2021-04-01", "2021-05-01", "2021-06-01", "2021-07-01", "2021-08-01",
                "2021-09-01", "2021-10-01", "2021-11-01", "2021-12-01");
        LocalDate localDate = LocalDate.of(2021, Month.JANUARY, 1);
        List<String> dates = Stream.iterate(localDate, d -> d.plusMonths(1))
                .limit(12)
                .map(LocalDate::toString)
                .collect(Collectors.toList());
        assertThat(dates).isEqualTo(expected);
    }

    @Test
    void testJoinStringThroughStream(){
        CharSequence names = CharSequenceUtil.of(Arrays.asList("Greg", "Marcia", "Peter", "Jan", "Bobby", "Cindy"));
        assertThat(names).isEqualTo("Greg,Marcia,Peter,Jan,Bobby,Cindy");
    }

    @Test
    void testCreateMapFromStream(){
        Map<? super CharSequence,? super Number> result = MapUtil.of(Stream.of("this", "is", "a", "list", "of", "strings"));
        assertThat(result).isInstanceOf(Map.class);
        assertThat(result.get("this")).isEqualTo(4);
    }
}
