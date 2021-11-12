package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    @DisplayName("요구사항1")
    void request_1() {
        String[] s1 = "1,2".split(",");
        assertThat(s1).contains("1").contains("2");

        String[] s2 = "1".split(",");
        assertThat(s2).contains("1").doesNotContain("2");
    }

    @Test
    @DisplayName("요구사항2")
    void request_2() {
        String split = "(1,2)";
        int subStart = 1;
        int subEnd = split.length() - 1;

        String target = split.substring(subStart, subEnd);
        assertThat(target).isEqualTo("1,2");

    }

    @Test
    @DisplayName("요구사항3, 특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생")
    void request_3() {
        String target = "abc";
        int index = 15;
        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(() -> target.charAt(index));

    }
}
