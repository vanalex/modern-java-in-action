package challenges.objects;

import java.util.List;

public class Objects {

    public static boolean checkNulls(List<?> list){
        return list.stream().anyMatch(java.util.Objects::isNull);
    }
}
