package calculator;

import java.util.function.BiFunction;

public class StringCalculator {
    private StringCalculatorValidator stringCalculatorValidator = new StringCalculatorValidator();

    private final static int INIT_RESULT_INDEX = 0;
    private final static int FIRST_OPERATOR_INDEX = 1;
    private final static int NEXT_OPERATOR_INDEX_OFFSET = 2;
    private final static String DELIMITER = " ";

    public double calculate(String input) {

        stringCalculatorValidator.throwExceptionIfEmpty(input);
        stringCalculatorValidator.throwExceptionIfInvalidInput(input);

        String[] token = input.split(DELIMITER);
        double result = Integer.parseInt(token[INIT_RESULT_INDEX]);

        for(int i=FIRST_OPERATOR_INDEX; i<token.length; i+= NEXT_OPERATOR_INDEX_OFFSET) {
            Operator targetOp = Operator.getOperator(token[i]).get();
            String nextStr = token[i+1];
            double next = Integer.parseInt(nextStr);

            stringCalculatorValidator.throwExceptionIfZeroDivide(next, targetOp);

            BiFunction<Double, Double, Double> express = targetOp.getFunction();
            result = express.apply(result, next);
        }
        return result;
    }
}
