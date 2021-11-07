package chapter01;

import chapter01.domain.Apple;

import java.util.function.Predicate;

public class LambdaFactory {

    private LambdaFactory(){}

    public static final Predicate<Apple> GREEN_APPLE = a -> "green".equals(a.getColor());
    public static final Predicate<Apple> HEAVY_APPLE = a -> a.getWeight() > 150;
    public static final Predicate<Apple> WEIRD_APPLE = a -> a.getWeight() < 80 || "brown".equals(a.getColor());
}
