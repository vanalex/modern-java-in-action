package generics;

import java.util.List;

public class GenericsUtil {

    private List<? extends Number> numbers;

    public GenericsUtil(List<? extends Number> numbers) {
        this.numbers = numbers;
    }

    public double sumListAsDoubles(){
        return this.numbers.stream().mapToDouble(Number::doubleValue).sum();
    }

    public static double sumListAsDoubles(List<? extends Number> numbers) {
        return numbers.stream()
                .mapToDouble(Number::doubleValue)
                .sum();
    }

    public static void printList(List<?> elements) {
        elements.forEach(System.out::println);
    }
}
