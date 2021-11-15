package java15;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class PersonTest {

    @Test
    void testPerson(){
        Person john = new Person("john", 20);
        Assertions.assertThat(john.name()).isEqualTo("john");
        Assertions.assertThat(john.age()).isEqualTo(20);
    }
}
