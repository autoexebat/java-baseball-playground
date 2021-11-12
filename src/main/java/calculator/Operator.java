package calculator;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.BiFunction;

public enum Operator {
    PLUS("+", (x,y) -> (x+y)), MINUS("-", (x,y) -> (x-y)), DIVIDE("/", (x,y) -> (x/y)), MULTIPLE("*", (x,y) -> (x*y));

    Operator(String operator, BiFunction<Double, Double, Double> function) {
        this.operator = operator;
        this.function = function;
    }

    private String operator;
    private BiFunction<Double, Double, Double> function;

    public String getOperator() {
        return operator;
    }

    public BiFunction<Double, Double, Double> getFunction() {
        return function;
    }

    public static Optional<Operator> getOperator(String operator) {
        return Arrays.stream(values())
                .filter(op -> op.getOperator().equals(operator))
                .findFirst();
    }
}
