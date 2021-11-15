package calculator;

public class StringCalculatorValidator {
    private final static int FIRST_OPERATOR_INDEX = 1;
    private final static int NEXT_OPERATOR_INDEX_OFFSET = 2;
    private static final String DELIMITER = " ";

    public void throwExceptionIfEmpty(String input) {
        if(input.isEmpty()) {
            throw new StringCalculatorExceptions("빈 값을 입력할 수 없습니다.");
        }
    }

    public void throwExceptionIfInvalidInput(String input) {
        String withouSpace = input.replaceAll("\\s", "");
        if(withouSpace.length() < 3 || withouSpace.length() % 2 == 0) {
            throw new StringCalculatorExceptions("유효한 표현식을 넣어야 합니다.");
        }

        String[] inputs = input.split(DELIMITER);
        if(inputs.length < 3 || inputs.length % 2 == 0) {
            throw new StringCalculatorExceptions("유효한 표현식을 넣어야 합니다.");
        }

        for(int i=FIRST_OPERATOR_INDEX; i<inputs.length; i+= NEXT_OPERATOR_INDEX_OFFSET) {
            String targetOp = inputs[i];
            String prevString = inputs[i-1];
            String nextString = inputs[i+1];

            if(!isNumber(prevString) || !isNumber(nextString)) {
                throw new StringCalculatorExceptions("정수를 입력해주세요.");
            }

            Operator calculatorOp = Operator.getOperator(targetOp).orElse(null);
            if(calculatorOp == null) {
                throw new StringCalculatorExceptions("유효한 표현식을 넣어야 합니다.");
            }
        }
    }

    public void throwExceptionIfZeroDivide(double next, Operator calculatorOp) {
        if(Operator.DIVIDE == calculatorOp && next == 0) {
            throw new StringCalculatorExceptions("0으로 나눌 수 없습니다.");
        }
    }

    private boolean isNumber(String target) {
        for(int i=0; i<target.length(); i++) {
            if(!Character.isDigit(target.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
