package challenges;

public class Pair<V, C> {

    private final V v;
    private final C c;

    public Pair(V v, C c) {
        this.v = v;
        this.c = c;
    }

    static <V, C> Pair<V, C> of(V vowels, C consonants) {
        return new Pair<>(vowels, consonants);
    }

    @Override
    public int hashCode() {
        return v.hashCode() ^ c.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Pair)) {
            return false;
        }

        Pair obj = (Pair) o;
        return this.v.equals(obj.v)
                && this.c.equals(obj.c);
    }

    public V getV() {
        return v;
    }

    public C getC() {
        return c;
    }
}
