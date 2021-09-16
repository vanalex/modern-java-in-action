package challenges.numbers;

import java.util.function.BinaryOperator;

public class Numbers {

    private static BinaryOperator<Integer> operator = Math::addExact;

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

    public static int minWithInteger(int number1, int number2){
        return new IntegerOperation<>(number1, number2).min();
    }

    public static int minWithMath(int number1, int number2){
        return new MathOperation<>(number1, number2).min();
    }

    public static int maxWithInteger(int number1, int number2){
        return new IntegerOperation<>(number1, number2).max();
    }

    public static int maxWithMath(int number1, int number2){
        return new MathOperation<>(number1, number2).max();
    }

    public static int maxWithBinaryOperator(int number1, int number2){
        return new BinaryOperation<>(number1, number2).max();
    }

    public static int minWithBinaryOperator(int number1, int number2){
        return new BinaryOperation<>(number1, number2).min();
    }
}
