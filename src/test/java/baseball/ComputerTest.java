package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class ComputerTest {
    @ParameterizedTest
    @CsvSource(value = {"3", "4", "5", "6", "7", "8", "9"})
    @DisplayName("랜덤으로 ball 생성, 동일한 숫자가 나오지 않음")
    void ballGenerate(int count) {
        Computer computer = new Computer(count);
        List<Ball> balls = computer.getBalls();
        Set<Integer> ballSet = balls.stream().map(b -> b.getNumber())
                .collect(Collectors.toSet());

        assertThat(ballSet.size()).isEqualTo(count);
    }
}
