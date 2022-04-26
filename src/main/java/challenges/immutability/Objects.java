package challenges.immutability;

import java.util.function.Supplier;

public class Objects {

  private Objects() {
    throw new AssertionError("Cannot be instantiated");
  }

  public static <T> T requireNonNullElseThrowIAE(T obj, String message) {

    if (obj == null) {
      throw new IllegalArgumentException(message);
    }

    return obj;
  }

  public static <T> T requireNonNullElseThrowIAE(T obj,
      Supplier<String> messageSupplier) {

    if (obj == null) {
      throw new IllegalArgumentException(messageSupplier == null
          ? null : messageSupplier.get());
    }

    return obj;
  }

  public static <T, X extends Throwable> T requireNonNullElseThrow(T obj,
      X exception) throws X {

    if (obj == null) {
      throw exception;
    }

    return obj;
  }

  public static <T, X extends Throwable> T requireNotNullElseThrow(T obj,
      Supplier<? extends X> exceptionSupplier) throws X {

    if (obj != null) {
      return obj;
    } else {
      throw exceptionSupplier.get();
    }
  }
}
