package java17;

public sealed abstract class Asset permits Bond, Stock, CertificateOfDeposit {
  private String issuer;
  private String holder;
  private long totalAmount;

  protected Asset(String issuer, String holder, long totalAmount) {
    this.issuer = issuer;
    this.holder = holder;
    this.totalAmount = totalAmount;
  }

  public long getTotalAmount() {
    return this.totalAmount;
  }

  public abstract long calculatePrice();

  public long calculateAssetPrice() {
    switch (this) {
      case Stock s: return s.calculatePrice();
      // guard
      case Bond b && b.isExpired(): throw new IllegalStateException("The bond is expired");
      case Bond b: return b.calculatePrice();
      case CertificateOfDeposit cd && cd.isExpired(): throw new IllegalStateException("The CD is expired");
      case CertificateOfDeposit cd: return cd.calculatePrice();
      case null:
        throw new IllegalArgumentException("Invalid asset");
      default:
        throw new IllegalArgumentException("Not supported");
    }
  }
}
