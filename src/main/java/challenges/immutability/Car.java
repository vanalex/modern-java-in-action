package challenges.immutability;

import java.awt.Color;

public class Car {

  private String name;
  private Color color;

  public Car(String name, Color color) {
    this.name = Objects.requireNonNullElseThrow(name,
        new UnsupportedOperationException("Name cannot be set as null"));
    this.color = Objects.requireNotNullElseThrow(color,
        () -> new UnsupportedOperationException("Color cannot be set as null"));
  }
}
