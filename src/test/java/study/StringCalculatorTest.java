package study;

import calculator.StringCalculator;
import calculator.StringCalculatorExceptions;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class StringCalculatorTest {
    StringCalculator stringCalculator = new StringCalculator();

    @DisplayName("올바른 계산식")
    @ParameterizedTest
    @CsvSource(value = {"1 + 1 + 2 / 2:2", "1 * 1 * 2 + 1:3"}, delimiter = ':')
    void validCalculate(String input, double result) {
        double calculate = stringCalculator.calculate(input);
        Assertions.assertThat(calculate).isEqualTo(result);
    }

    @DisplayName("틀린 계산식")
    @ParameterizedTest
    @CsvSource(value = {"2 / 0", "1 ** 1", "/", "/1", "5/1&2", "5", "5/1", "5 + 1 /"})
    void invalidCalculate(String input) {
        Assertions.assertThatExceptionOfType(StringCalculatorExceptions.class)
                .isThrownBy(() -> stringCalculator.calculate(input));
    }
}
