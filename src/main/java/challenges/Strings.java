package challenges;

import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;

public class Strings {

    private Strings() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static Map<String, Long> countDuplicateCharacters(String str) {

        if (str == null || str.isBlank()) {
            // or throw IllegalArgumentException
            return Collections.emptyMap();
        }

        return str.codePoints()
                .mapToObj(c -> String.valueOf(Character.toChars(c)))
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));
    }
}
