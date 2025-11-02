package lotto.model.result;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

class LottoRankTest {
    @ParameterizedTest
    @MethodSource("rankProvider")
    @DisplayName("등수 구분 로직")
    void 등수_구분_로직(int matchCount, boolean hasBonus, LottoRank expected) {
        assertThat(LottoRank.of(matchCount, hasBonus)).isEqualTo(expected);
    }

    static Stream<Arguments> rankProvider() {
        return Stream.of(
                Arguments.of(6, false, LottoRank.FIRST),
                Arguments.of(5, true, LottoRank.SECOND),
                Arguments.of(5, false, LottoRank.THIRD),
                Arguments.of(4, false, LottoRank.FOURTH),
                Arguments.of(3, false, LottoRank.FIFTH),
                Arguments.of(2, false, LottoRank.NONE),
                Arguments.of(1, false, LottoRank.NONE),
                Arguments.of(0, false, LottoRank.NONE)
        );
    }

    @ParameterizedTest
    @MethodSource("prizeProvider")
    @DisplayName("등수별 상금 반환")
    void 등수별_상금반환(LottoRank rank, long expectedPrize) {
        assertThat(rank.getPrize()).isEqualTo(expectedPrize);
    }

    static Stream<Arguments> prizeProvider() {
        return Stream.of(
                Arguments.of(LottoRank.FIRST, 2_000_000_000L),
                Arguments.of(LottoRank.SECOND, 30_000_000L),
                Arguments.of(LottoRank.THIRD, 1_500_000L),
                Arguments.of(LottoRank.FOURTH, 50_000L),
                Arguments.of(LottoRank.FIFTH, 5_000L),
                Arguments.of(LottoRank.NONE, 0L)
        );
    }
}
