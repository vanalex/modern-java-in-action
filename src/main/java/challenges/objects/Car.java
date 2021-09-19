package challenges.objects;

import java.awt.*;
import java.util.Objects;

public record Car(String name, Color color) {

    public Car(String name, Color color) {
        this.name = Objects.requireNonNull(name);
        this.color = Objects.requireNonNull(color);
    }

    public void assignDriver(String license, Point location) {

        MyObjects.requireNonNullElseThrowIAE(license, "Licence cannot be null");
        MyObjects.requireNonNullElseThrowIAE(location, () -> "Location cannot be null");
    }
}
