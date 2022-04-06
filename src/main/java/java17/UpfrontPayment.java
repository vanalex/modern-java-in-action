package java17;

import java.math.BigDecimal;

public non-sealed class UpfrontPayment implements Payment{
  private final BigDecimal amount;

  public UpfrontPayment(BigDecimal amount) {
    this.amount = amount;
  }

  public BigDecimal getAmount() {
    return this.amount;
  }
}
