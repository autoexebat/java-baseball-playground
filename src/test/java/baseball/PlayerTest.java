package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class PlayerTest {
    @ParameterizedTest
    @ValueSource(strings = {"-123", "*12", "1 2 1", ""})
    @DisplayName("입력값 테스트")
    void test(String input) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Player(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"123", "013", "457", "123456789"})
    @DisplayName("input으로 입력받은 문자열이 Ball 객체로 잘 생성되는지 확인")
    void getBalls(String input) {
        Player player = new Player(input);
        List<Ball> balls = player.getBalls();

        assertThat(balls.size()).isEqualTo(input.length());
        for(int i=0; i<input.length(); i++) {
            Character ch = input.charAt(i);
            assertThat(balls.get(i)).isEqualTo(new Ball(i,Integer.parseInt(ch.toString())));
        }
    }
}
