package java17;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SwitchTest {

  @Test
  void testTypePatternSwitch(){
    Object inputObject  = 500L;
    String formattedObject = switch (inputObject ) {
      case Integer i -> String.format("int %d", i);
      case Long l    -> String.format("long %d", l);
      case Double d  -> String.format("double %f", d);
      case String s  -> String.format("String %s", s);
      default        -> inputObject .toString();
    };
    Assertions.assertEquals("long 500", formattedObject);
  }

  @Test
  void testSwitchMultipleValues(){
    String result = developerRating(0);
    Assertions.assertEquals("open source contributor", result);
  }

  @Test
  void testGuardedSwitch(){
    String o = "1.0";
    Double result = switch (o) {
      case String s && s.length() > 0 -> Double.parseDouble(s);
      default -> 0d;
    };

    org.assertj.core.api.Assertions.assertThat(result).isEqualTo(1.0);
  }

  @Test
  void testNullSwitch(){
    String result = testFooBar(null);

    org.assertj.core.api.Assertions.assertThat(result).isEqualTo("Oops");
  }

  String developerRating( int numberOfChildren ) {
    return switch (numberOfChildren) {
      case 0 -> "open source contributor";
      case 1, 2 -> "junior";
      case 3 -> "senior";
      default -> {
        if (numberOfChildren < 0)
          throw new IndexOutOfBoundsException( numberOfChildren );
        yield "manager";
      }
    };
  }

  private static String testFooBar(String s) {
    return switch (s) {
      case null         -> "Oops";
      case "Foo", "Bar" -> "Great";
      default           -> "Ok";
    };
  }
}
