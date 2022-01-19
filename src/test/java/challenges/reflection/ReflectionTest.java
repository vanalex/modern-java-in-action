package challenges.reflection;

import challenges.Person;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ReflectionTest {
    @Test
    void testGetFieldnameFromReflection(){
        final Object person = new Person();
        final Field[] fields = person.getClass().getDeclaredFields();

        final List<String> actualFieldNames = Arrays.stream(fields).map(Field::getName).collect(Collectors.toList());

        assertTrue(Arrays.asList("name", "age").containsAll(actualFieldNames));
    }
}
