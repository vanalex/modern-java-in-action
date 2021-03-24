package streams;

import java.util.stream.Stream;

public class StreamUtils<A, B> {

    public static <A, B> Stream concat(Stream<A> first, Stream<B> second){
        return Stream.concat(first, second);
    }
}
