package java18;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class StringifyTest {

  @Test
  void testStringify(){
    Stringify stringify = new Stringify();
    String result = stringify.convertoToString(18);
    Assertions.assertEquals("positive number", result);

    result = stringify.convertoToString(42);
    Assertions.assertEquals("42 is the answer", result);
  }
}