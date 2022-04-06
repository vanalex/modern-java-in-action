package java17;

import java.math.BigDecimal;
import java.time.LocalDate;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class PaymentProcessorTest {

  @Test
  void testSealedClasses(){
    LocalDate localDate = LocalDate.of(2022, 1,1);
    InvoicePayment invoicePayment = new InvoicePayment(BigDecimal.ONE, localDate);
    UpfrontPayment upfrontPayment = new UpfrontPayment(BigDecimal.TEN);

    PaymentProcessor paymentProcessor = new PaymentProcessor();
    String invoicePaymentResult = paymentProcessor.processPayment(invoicePayment);
    Assertions.assertThat(invoicePaymentResult).isEqualTo("This is an Invoice Payment of 1 €, due on 2022-01-01");

    String upfrontPAymentResult = paymentProcessor.processPayment(upfrontPayment);
    Assertions.assertThat(upfrontPAymentResult).isEqualTo("This is an Upfront Payment of 10 €");
  }

}
