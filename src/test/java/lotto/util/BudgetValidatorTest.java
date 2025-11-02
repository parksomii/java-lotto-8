package lotto.util;

import lotto.exception.LottoException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

class BudgetValidatorTest {
    @ParameterizedTest
    @ValueSource(strings = {"0", "-2000", "-1000", "500", "999"})
    @DisplayName("음수나 0 또는 1000 미만일 때 예외 발생")
    void 음수나_0_1000미만_예외(String input) {
        assertThatThrownBy(() -> BudgetValidator.parseAmount(input))
                .isInstanceOf(LottoException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"천원", "1000j", "abc", "1000원", "1,000"})
    @DisplayName("숫자가 아닐 때 예외 발생")
    void 숫자아닐때_예외(String input) {
        assertThatThrownBy(() -> BudgetValidator.parseAmount(input))
                .isInstanceOf(LottoException.class);
    }

    @ParameterizedTest
    @MethodSource("validBudgetProvider")
    @DisplayName("정상 입력은 값 반환")
    void 정상입력은_값반환(String input, int expected) {
        assertThat(BudgetValidator.parseAmount(input)).isEqualTo(expected);
    }

    static Stream<Arguments> validBudgetProvider() {
        return Stream.of(
                Arguments.of("1000", 1000),
                Arguments.of("5000", 5000),
                Arguments.of("10000", 10000),
                Arguments.of("2000", 2000)
        );
    }
}


