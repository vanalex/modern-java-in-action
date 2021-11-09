package chapter02;

public class AppleRedAndHeavyPredicate implements ApplePredicate{
    @Override
    public boolean test(Apple apple) {
        return apple.getColor() == Color.RED && apple.getWeight() > 150;
    }
}
