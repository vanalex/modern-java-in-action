package challenges.objects;

import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ObjectsTest {

    @Test
    void testIntegerListHasNull(){
        List<Integer> numbers = Arrays.asList(1, 2, null, 4, null, 16, 7, null);
        assertTrue(Objects.checkNulls(numbers));
    }

    @Test
    void testStringListHasNull(){
        List<String> strings = Arrays.asList("Hi", "goodbye", null, "Good morning", null, "", "lalala", null);
        assertTrue(Objects.checkNulls(strings));
    }

    @Test
    void testObjectsNullability(){
        assertThrows(NullPointerException.class, () -> new Car(null, Color.BLUE));
    }
}
