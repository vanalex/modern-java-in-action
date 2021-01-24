package chapter10.builder;

import chapter10.model.Order;
import chapter10.model.Stock;
import chapter10.model.Trade;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class NestedFunctionOrderBuilderTest {

    @Test
    void testBuilder(){
        Stock stock = new Stock();
        stock.setSymbol("IBM");
        stock.setMarket("NYSE");

        Trade trade = new Trade();
        trade.setType(Trade.Type.BUY);
        trade.setPrice(3.0);
        trade.setQuantity(2);
        trade.setStock(stock);
        Order order = NestedFunctionOrderBuilder.order("customer", trade);
        assertThat(order).isNotNull();
        assertThat(order.getCustomer()).isEqualTo("customer");
    }
}
