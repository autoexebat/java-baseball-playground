package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.ArrayList;
import java.util.List;

public class RefereeTest {
    @ParameterizedTest
    @CsvSource(value = {"123:124:0:2", "240:240:0:3", "125:078:0:0", "012:201:3:0"}, delimiter = ':')
    @DisplayName("볼/스트라이크 카운트 확인")
    void judgement(String input, String computed, int ball, int strike) {
        Referee referee = new Referee(3);
        List<Ball> inputs = getBallsByInput(input);
        List<Ball> randomComputed = getBallsByInput(computed);

        Judgement judgement = referee.judgement(inputs, randomComputed);

        assertThat(judgement.getBall()).isEqualTo(ball);
        assertThat(judgement.getStrike()).isEqualTo(strike);
    }

    private List<Ball> getBallsByInput(String input) {
        List<Ball> balls = new ArrayList<>();
        for(int i=0; i<input.length(); i++) {
            Character ch = input.charAt(i);
            balls.add(new Ball(i, Integer.parseInt(ch.toString())));
        }
        return balls;
    }
}
