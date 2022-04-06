package java17;

public class PaymentProcessor {

  public String processPayment(Payment payment) {
    return switch (payment) {
      case UpfrontPayment u -> String.format("This is an Upfront Payment of %s €", u.getAmount());
      case InvoicePayment i -> String.format("This is an Invoice Payment of %s €, due on %s",
          i.getAmount(), i.getToPayUntil());
    };
  }
}
