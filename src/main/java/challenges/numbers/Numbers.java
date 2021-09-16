package challenges.numbers;

import java.util.function.BinaryOperator;

public class Numbers {

    private static BinaryOperator<Integer> operator = Math::addExact;

    public static int returnMinimumByInteger(int num1, int num2){
        return Integer.min(num1, num2);
    }

    public static int returnMinimumByMath(int num1, int num2){
        return Math.min(num1, num2);
    }

    public static int returnMinimumByBinnaryOperator(int num1, int num2){
        return BinaryOperator.minBy(Integer::compare).apply(num1, num2);
    }

    public static int returnMaximumByInteger(int num1, int num2){
        return Integer.max(num1, num2);
    }

    public static int returnMaximumByMath(int num1, int num2){
        return Math.max(num1, num2);
    }

    public static int returnMaximumByBinnaryOperator(int num1, int num2){
        return BinaryOperator.maxBy(Integer::compare).apply(num1, num2);
    }

    public static int sumClassicWay(int num1, int num2){
        return num1 + num2;
    }

    public static int sumWithInteger(int num1, int num2){
        return Integer.sum(num1, num2);
    }

    public static int sumWithMath(int num1, int num2){
        return Math.addExact(num1, num2);
    }

    public static int sumWithOperator(int num1, int num2){
        return operator.apply(num1, num2);
    }
}
