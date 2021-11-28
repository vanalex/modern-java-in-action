package challenges.objects;

import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    void testObjectsNullabilityFields(){
        Car car = new Car("Seat", Color.GREEN);
        assertThrows(IllegalArgumentException.class, () -> car.assignDriver(null, null));
    }

    @Test
    void checkIndexTest() {
        var index = 1;
        var length = 2;
        var actual = java.util.Objects.checkIndex(index, length);
        assertEquals(index, actual);

        assertThrows(IndexOutOfBoundsException.class, () -> {
            java.util.Objects.checkIndex(2,2);
        });
    }

    @Test
    void checkFromToIndexTest() {
        var fromIndex = 0;
        var toIndex = 0;
        var length = 4;
        var actual = java.util.Objects.checkFromToIndex(fromIndex, toIndex, length);
        assertEquals(fromIndex, actual);

        assertThrows(IndexOutOfBoundsException.class, () -> {
            java.util.Objects.checkFromIndexSize(0, 5, 4);
        });
    }
}
