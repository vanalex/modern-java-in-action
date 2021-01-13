package chapter10;

import chapter10.model.MethodChainingOrderBuilder;
import chapter10.model.Order;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MethodChainingOrderBuilderTest {

    @Test
    public void testBuilderForOrder(){
        Order order = MethodChainingOrderBuilder.forCustomer("John Doe")
                .buy(10)
                .stock("23")
                .on("Supermarket")
                .at(2.30)
                .end();

        assertThat(order.getCustomer()).isEqualTo("John Doe");
    }
}
