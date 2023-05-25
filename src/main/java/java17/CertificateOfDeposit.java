package java17;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.temporal.ChronoUnit;

public final class CertificateOfDeposit extends Asset{

  private float interestRate;
  private LocalDate issuedDate;
  private Term term;

  CertificateOfDeposit(String issuer, String holder, int totalAmount, float interestRate, LocalDate issuedDate, Term term) {
    super(issuer, holder, totalAmount);
    this.interestRate = interestRate;
    this.issuedDate = issuedDate;
    this.term = term;
  }

  public LocalDate calculateMaturityDate() {
    switch (term) {
      case SIX_MONTH: return issuedDate.plusMonths(6);
      case ONE_YEAR: return issuedDate.plusYears(1);
      case EIGHTEEN_MONTH: return issuedDate.plusMonths(18);
      case TWO_YEAR: return issuedDate.plusYears(2);
      default: throw new IllegalStateException();
    }
  }

  public boolean isExpired() {
    return this.calculateMaturityDate().isBefore(LocalDate.now());
  }

  public long calculatePrice() {
    var maturityDate = calculateMaturityDate();
    var totalOfMonths = YearMonth.of(this.issuedDate.getYear(), this.issuedDate.getMonth())
        .until(YearMonth.of(maturityDate.getYear(), maturityDate.getMonth()), ChronoUnit.MONTHS)
        + 1;
    return getTotalAmount() + (int) (totalOfMonths * this.interestRate);
  }
}
