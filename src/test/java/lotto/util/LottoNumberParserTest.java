package lotto.util;

import lotto.exception.LottoException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LottoNumberParserTest {
    @Test
    void 정상적으로_잘_파싱된다() {
        assertThat(LottoNumberParser.parseNumbers("1,2,3,4,5,6")).isEqualTo(List.of(1,2,3,4,5,6));
        assertThat(LottoNumberParser.parseBonus("7")).isEqualTo(7);
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", "abc", "1a", "a1"})
    @DisplayName("숫자 아닌 문자 입력 시 예외 발생")
    void 숫자_아닌문자_입력_예외(String input) {
        assertThatThrownBy(() -> LottoNumberParser.parseBonus(input))
                .isInstanceOf(LottoException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "46", "47", "-1"})
    @DisplayName("범위를 벗어나면 예외 발생")
    void 범위_벗어나면_예외(String input) {
        assertThatThrownBy(() -> LottoNumberParser.parseBonus(input))
                .isInstanceOf(LottoException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1 2 3 4 5 6", "1,2,3 4,5,6", "1|2|3|4|5|6"})
    @DisplayName("쉼표 형식이 아니면 예외 발생")
    void 쉼표_형식_아닌경우_예외(String input) {
        assertThatThrownBy(() -> LottoNumberParser.parseNumbers(input))
                .isInstanceOf(LottoException.class);
    }
}


