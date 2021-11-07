package chapter01;

import chapter01.domain.Apple;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.List;
import java.util.stream.Stream;

import static chapter01.FilterFactory.filterApples;
import static chapter01.LambdaFactory.*;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static utils.TestFixture.createList;

class FilterTest {

    @ParameterizedTest
    @ArgumentsSource(AppleProvider.class)
    void testFilterGreenApples(List<Apple> inventory){

        List<Apple> result = filterApples(inventory, FilterFactory::isGreenApple);
        assertThat(result).hasSameElementsAs( createList(new Apple(80, "green"), new Apple(155, "green")));
    }

    @ParameterizedTest
    @ArgumentsSource(AppleProvider.class)
    void testFilterGreenApplesWithLambda(List<Apple> inventory){

        List<Apple> result = filterApples(inventory, GREEN_APPLE);
        assertThat(result).hasSameElementsAs( createList(new Apple(80, "green"), new Apple(155, "green")));
    }

    @ParameterizedTest
    @ArgumentsSource(AppleProvider.class)
    void testFilterHeavyApples(List<Apple> inventory){
        List<Apple> result = filterApples(inventory, FilterFactory::isHeavyApple);
        assertThat(result).hasSameElementsAs( createList(new Apple(155, "green")));
    }

    @ParameterizedTest
    @ArgumentsSource(AppleProvider.class)
    void testFilterHeavyApplesWithLambda(List<Apple> inventory){
        List<Apple> result = filterApples(inventory, HEAVY_APPLE);
        assertThat(result).hasSameElementsAs( createList(new Apple(155, "green")));
    }

    @ParameterizedTest
    @ArgumentsSource(AppleProvider.class)
    void test(List<Apple> inventory){
        List<Apple> result = filterApples(inventory, WEIRD_APPLE);
        assertThat(result).isEmpty();
    }

    static class AppleProvider implements ArgumentsProvider {

        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
            return Stream.of(
                    Arguments.of(createList(new Apple(80, "green"),
                            new Apple(155, "green"),
                            new Apple(120, "red")))
            );
        }
    }
}
