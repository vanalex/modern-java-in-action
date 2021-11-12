package chapter02;

import static chapter02.FilterFactory.filterApplesByColor;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static utils.TestFixture.createList;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

class FilterTest {

  @ParameterizedTest
  @ArgumentsSource(FilterTest.AppleProvider.class)
    void test(List<Apple> inventory){
      List<Apple> result = filterApplesByColor(inventory, Color.GREEN);
      assertThat(result).hasSameElementsAs( createList(new Apple(80, Color.GREEN), new Apple(155, Color.GREEN)));
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
