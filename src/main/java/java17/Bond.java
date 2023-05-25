package java17;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.temporal.ChronoUnit;

public final class Bond extends Asset{

  private LocalDate issuedDate;
  private float interestRate;
  private LocalDate maturityDate;

  Bond(String issuer, String holder, int totalAmount, float interestRate, LocalDate issuedDate, LocalDate maturityDate) {
    super(issuer, holder, totalAmount);
    this.interestRate = interestRate;
    this.issuedDate = issuedDate;
    this.maturityDate = maturityDate;
  }

  public boolean isExpired() {
    return maturityDate.isBefore(LocalDate.now());
  }

  @Override
  public long calculatePrice() {
    var totalOfMonths = YearMonth.of(this.issuedDate.getYear(), this.issuedDate.getMonth())
        .until(YearMonth.of(this.maturityDate.getYear(), this.maturityDate.getMonth()), ChronoUnit.MONTHS)
        + 1;
    return getTotalAmount() + (int) (totalOfMonths * this.interestRate);

  }
}
