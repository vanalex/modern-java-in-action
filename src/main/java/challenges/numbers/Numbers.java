package challenges.numbers;

import java.util.List;
import java.util.Objects;

public final class Numbers {

    private Numbers(){
        throw new AssertionError("Cannot be instantiated");
    }

    public static int sumIntegers(List<Integer> integers) {

        if (Objects.isNull(integers)) {
            throw new IllegalArgumentException("List cannot be null");
        }

        return integers.stream()
            .filter(Objects::nonNull)
            .mapToInt(Integer::intValue).sum();
    }
}
