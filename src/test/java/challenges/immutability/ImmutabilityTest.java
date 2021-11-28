package challenges.immutability;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class ImmutabilityTest {

  @Test
  void testImmutableObject(){
    ImmutablePoint point = new ImmutablePoint(2, 3);
    assertEquals(point.getX(), 2);
    assertEquals(point.getY(), 3);
  }

  @Test
  void builderImmutableTest(){
    //cannot be modified with setters after creation
    User user = User.getBuilder("john", "12345").build();
    Assertions.assertThat(user.getNickname()).isEqualTo("john");
  }


}
