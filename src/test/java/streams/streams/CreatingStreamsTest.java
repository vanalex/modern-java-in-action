package streams.streams;

import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class CreatingStreamsTest {

    @Test
    public void testCreateStringThroughStreamByJoining(){
        String names = Stream.of("Gomez", "Morticia", "Wednesday", "Pugsley")
                .collect(Collectors.joining(","));
        assertThat(names).isEqualTo("Gomez,Morticia,Wednesday,Pugsley");
    }
}
