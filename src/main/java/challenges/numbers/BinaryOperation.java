package challenges.numbers;

import java.util.function.BinaryOperator;

public class BinaryOperation <N extends Number> extends AbstractNumberOperation<N>{

    private static BinaryOperator<Integer> operator = Math::addExact;

    public BinaryOperation(N n1, N n2) {
        super(n1, n2);
    }

    @Override
    int min() {
        return BinaryOperator.minBy(Integer::compare).apply(this.n1.intValue(), this.n2.intValue());
    }

    @Override
    int max() {
        return BinaryOperator.maxBy(Integer::compare).apply(this.n1.intValue(), this.n2.intValue());
    }
}
