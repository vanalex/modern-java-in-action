package java17;

public final class Stock extends Asset{

  Stock(String issuer, String holder, long totalAmount) {
    super(issuer, holder, totalAmount);
  }

  public long calculatePrice() {
    return getTotalAmount();
  }
}
