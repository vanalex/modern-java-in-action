package generics;

import java.util.ArrayList;
import java.util.List;

public class GenericsUtil {

    private List<? extends Number> numbers;

    public GenericsUtil(List<? extends Number> numbers) {
        List<Integer> ints = new ArrayList<>();
        ints.add(3); ints.add(1); ints.add(4);
        this.numbers = numbers;
    }

    public double sumListAsDoubles(){
        return this.numbers.stream().mapToDouble(Number::doubleValue).sum();
    }
}
