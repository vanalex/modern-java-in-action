package generics;

import java.util.Collection;
import java.util.Comparator;

public class Comparators {

    public static <T> T max (Collection<? extends T> coll,
                             Comparator<? super T> cmp) {
        T candidate = coll.iterator().next();
        for (T elt : coll) {
            if (cmp.compare(candidate, elt) < 0) { candidate = elt; }
        }
        return candidate;
    }

    public static <T> T min (Collection<? extends T> coll,
                             Comparator<? super T> cmp) {
        T candidate = coll.iterator().next();
        for (T elt : coll) {
            if (cmp.compare(candidate, elt) > 0) { candidate = elt; }
        }
        return candidate;
    }

    public static <T extends Comparable<? super T>> T max (Collection<? extends T> coll) {
        return max(coll, Comparators.<T>naturalOrder());
    }

    public static <T extends Comparable<? super T>> T min (Collection<? extends T> coll) {
        return max(coll, Comparators.<T>reverseOrder());
    }

    public static <T extends Comparable<? super T>> Comparator<T> naturalOrder () {
        return (o1, o2) -> o1.compareTo(o2);
    }

    public static <T extends Comparable<? super T>> Comparator<T> reverseOrder () {
        return (o1, o2) -> o2.compareTo(o1);
    }

    public static Comparator<String> sizeOrder() {
        return (s1, s2) -> s1.length() < s2.length() ? -1 : s1.length() > s2.length() ? 1 : s1.compareTo(s2);

    }
}
