package challenges.immutability;

import java.awt.Color;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ImmutabilityTest {

  @Test
  void testOldCarNullability(){
    try {
      new OldCar("skoda", null);
    }catch(Exception e){
      Assertions.assertEquals("Car color cannot be null", e.getMessage());
    }
  }

  @Test
  void testNewCarNullability(){
    try {
      new NewCar("skoda", null);
    }catch(Exception e){
      Assertions.assertEquals("Color cannot be null", e.getMessage());
    }
  }

  @Test
  void test(){
    try {
      new Car("Mazda", null);
    }catch(Exception e){
      Assertions.assertEquals("Color cannot be set as null", e.getMessage());
    }
  }

}
