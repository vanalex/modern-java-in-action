package challenges.numbers;

public class IntegerOperation<N extends Number> extends AbstractNumberOperation<N> {
    public IntegerOperation(N n1, N n2) {
        super(n1, n2);
    }

    @Override
    public int min() {
        return Integer.min(this.n1.intValue(), this.n2.intValue());
    }

    @Override
    int max() {
        return Integer.max(this.n1.intValue(), this.n2.intValue());
    }
}
