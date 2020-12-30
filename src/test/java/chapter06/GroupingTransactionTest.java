package chapter06;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;
import static org.assertj.core.api.Assertions.assertThat;

public class GroupingTransactionTest {

    @Test
    public void testStreamGrouping(){
        Map<Currency, List<Transaction>> transactionsByCurrencies = TestFixture.transactions.stream()
                .collect(groupingBy(Transaction::getCurrency));
        assertThat(transactionsByCurrencies).isNotNull();
    }
}
