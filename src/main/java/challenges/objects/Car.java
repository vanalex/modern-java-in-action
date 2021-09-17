package challenges.objects;

import java.awt.*;
import java.util.Objects;

public record Car(String name, Color color) {

    public Car(String name, Color color) {
        this.name = Objects.requireNonNull(name);
        this.color = Objects.requireNonNull(color);
    }
}
