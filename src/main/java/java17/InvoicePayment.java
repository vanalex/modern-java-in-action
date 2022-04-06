package java17;

import java.math.BigDecimal;
import java.time.LocalDate;

public final class InvoicePayment implements Payment{

  private final BigDecimal amount;
  private final LocalDate toPayUntil;

  public InvoicePayment(BigDecimal amount, LocalDate toPayUntil) {
    this.amount = amount;
    this.toPayUntil = toPayUntil;
  }

  public BigDecimal getAmount() {
    return this.amount;
  }

  public LocalDate getToPayUntil() {
    return this.toPayUntil;
  }
}
