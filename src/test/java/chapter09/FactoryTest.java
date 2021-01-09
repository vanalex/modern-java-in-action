package chapter09;

import chapter09.factory.Product;
import chapter09.factory.ProductFactory;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FactoryTest {

    @Test
    public void testFactory(){
        Product product = ProductFactory.obtainProduct("loan");
        assertThat(product.getClass().getSimpleName()).isEqualTo("Loan");
        product = ProductFactory.obtainProduct("bond");
        assertThat(product.getClass().getSimpleName()).isEqualTo("Bond");
        product = ProductFactory.obtainProduct("stock");
        assertThat(product.getClass().getSimpleName()).isEqualTo("Stock");

        product = ProductFactory.createProductLambda("loan");
        assertThat(product.getClass().getSimpleName()).isEqualTo("Loan");
        product = ProductFactory.createProductLambda("bond");
        assertThat(product.getClass().getSimpleName()).isEqualTo("Bond");
        product = ProductFactory.createProductLambda("stock");
        assertThat(product.getClass().getSimpleName()).isEqualTo("Stock");
    }
}
