package streams;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MapUtil {

    public static Map<? super CharSequence, ? super Number> of(Stream stream){
        return (Map<? super CharSequence, ? super Number>) stream.collect(Collectors.toMap(s -> s, String::length));
    }

}
