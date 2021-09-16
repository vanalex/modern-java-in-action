package challenges.numbers;

public class MathOperation<N extends Number> extends AbstractNumberOperation<N>{
    public MathOperation(N n1, N n2) {
        super(n1, n2);
    }

    @Override
    int min() {
        return Math.min(this.n1.intValue(), this.n2.intValue());
    }

    @Override
    int max() {
        return Math.max(this.n1.intValue(), this.n2.intValue());
    }
}
