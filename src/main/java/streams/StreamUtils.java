package streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamUtils<A, B> {

    public static <A, B> Stream concat(Stream<A> first, Stream<B> second){
        return Stream.concat(first, second);
    }

    public static <A> CharSequence of(Stream<A> stream){
        return join(stream);
    }

    public static <A> CharSequence of(List<String> values){
        return join(values.stream());
    }

    public static <A> CharSequence of(String[] values){
        return join(Arrays.stream(values));
    }

    private static <A> CharSequence join(Stream stream){
        return (CharSequence) stream.collect(Collectors.joining(","));
    }
}
