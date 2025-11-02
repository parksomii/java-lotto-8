package lotto.model.lotto;

import lotto.exception.LottoException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

class PrizeLottoTest {
    @ParameterizedTest
    @MethodSource("invalidBonusRangeProvider")
    @DisplayName("보너스 번호가 1~45 범위를 벗어나면 예외")
    void bonus_range(List<Integer> main, int bonus) {
        assertThatThrownBy(() -> new PrizeLotto(main, bonus))
                .isInstanceOf(LottoException.class);
    }

    static Stream<Arguments> invalidBonusRangeProvider() {
        List<Integer> main = List.of(1,2,3,4,5,6);
        return Stream.of(
                Arguments.of(main, 0),
                Arguments.of(main, 46),
                Arguments.of(main, -1),
                Arguments.of(main, 47)
        );
    }

    @ParameterizedTest
    @MethodSource("duplicateBonusProvider")
    @DisplayName("보너스가 당첨 번호와 중복되면 예외")
    void bonus_duplicate(List<Integer> main, int bonus) {
        assertThatThrownBy(() -> new PrizeLotto(main, bonus))
                .isInstanceOf(LottoException.class);
    }

    static Stream<Arguments> duplicateBonusProvider() {
        return Stream.of(
                Arguments.of(List.of(1,2,3,4,5,6), 6),
                Arguments.of(List.of(1,2,3,4,5,6), 1),
                Arguments.of(List.of(10,20,30,40,41,45), 45)
        );
    }
}


