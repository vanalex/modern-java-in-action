package utils;

import java.util.List;

public class TestFixture<T> {

    public static <T> List<T> createList(T...t){
        return List.of(t);
    }
}
