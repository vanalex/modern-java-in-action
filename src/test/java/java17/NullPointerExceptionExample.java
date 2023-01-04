package java17;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NullPointerExceptionExample {

  @Test
  void testNPE(){
    String professor= null;
    try {
      professor.length();
    }catch (Exception e){
      Assertions.assertEquals("Cannot invoke \"String.length()\" because \"professor\" is null", e.getMessage());
    }
  }
}
