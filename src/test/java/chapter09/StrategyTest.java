package chapter09;

import chapter09.strategy.IsAllowerCase;
import chapter09.strategy.IsNumeric;
import chapter09.strategy.ValidationStrategy;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StrategyTest {

    @Test
    public void testStrategy(){
        ValidationStrategy strategy = new IsNumeric();
        assertThat(strategy.execute("aaaa")).isFalse();
        assertThat(strategy.execute("4234")).isTrue();
        strategy = new IsAllowerCase();
        assertThat(strategy.execute("aasd")).isTrue();
        assertThat(strategy.execute("aasD")).isFalse();
    }
}
