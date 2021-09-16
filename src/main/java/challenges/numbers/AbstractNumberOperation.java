package challenges.numbers;

public abstract class AbstractNumberOperation<N extends Number> {
    protected N n1;
    protected N n2;

    AbstractNumberOperation(N n1, N n2) {
        this.n1 = n1;
        this.n2 = n2;
    }

    abstract int min();

    abstract int max();
}
