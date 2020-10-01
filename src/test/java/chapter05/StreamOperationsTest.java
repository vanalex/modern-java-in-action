package chapter05;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class StreamOperationsTest {

    private static List<Transaction> transactions;

    @BeforeEach
    public void init(){
        transactions = buildTransactions();
    }

    @Test
    public void test(){
        List<Transaction> transactionsIn2011 = transactions.stream()
                .filter(transactions -> transactions.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getValue))
                .collect(Collectors.toList());

        assertThat(transactionsIn2011.size()).isEqualTo(2);
        Transaction first = transactionsIn2011.get(0);
        assertThat(first.getValue()).isEqualTo(300);
        assertThat(first.getYear()).isEqualTo(2011);

        Transaction second = transactionsIn2011.get(1);
        assertThat(second.getValue()).isEqualTo(400);
        assertThat(second.getYear()).isEqualTo(2011);

    }

    private static List<Transaction> buildTransactions(){
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        return Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );
    }
}
