package challenges;

import java.util.function.BinaryOperator;

public class Numbers {

    public static int returnMinimumByInteger(int num1, int num2){
        return Integer.min(num1, num2);
    }

    public static int returnMinimumByMath(int num1, int num2){
        return Math.min(num1, num2);
    }

    public static int returnMinimumByBinnaryOperator(int num1, int num2){
        return BinaryOperator.minBy(Integer::compare).apply(num1, num2);
    }
}
