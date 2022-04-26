package challenges.immutability;

import java.awt.Color;
import java.util.Objects;

public class NewCar {

  private final String name;
  private final Color color;

  public NewCar(String name, Color color) {
    this.name = Objects.requireNonNull(name, "Car name cannot be null");
    this.color = Objects.requireNonNull(color, "Color cannot be null");
  }
}
