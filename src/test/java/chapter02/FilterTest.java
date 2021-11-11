package chapter02;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static utils.TestFixture.createList;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

class FilterTest {

    @Test
    void dummyTest(){
      int i = 1;
      assertThat(1).isSameAs(i);
    }

  static class AppleProvider implements ArgumentsProvider {

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          Arguments.of(createList(new Apple(80, Color.GREEN),
              new Apple(155, Color.GREEN),
              new Apple(120, Color.RED)))
      );
    }
  }

}
