package lotto.model.result;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class LottoResultTest {
    @Test
    void 등수별_집계_및_총수익_테스트() {
        LottoResult result = new LottoResult();
        result.add(LottoRank.FIRST);
        result.add(LottoRank.SECOND);
        result.add(LottoRank.FIFTH);

        assertThat(result.getCount(LottoRank.FIRST)).isEqualTo(1);
        assertThat(result.getCount(LottoRank.SECOND)).isEqualTo(1);
        assertThat(result.getCount(LottoRank.FIFTH)).isEqualTo(1);
        assertThat(result.getCount(LottoRank.THIRD)).isZero();

        long expectedSum = LottoRank.FIRST.getPrize() + LottoRank.SECOND.getPrize() + LottoRank.FIFTH.getPrize();
        assertThat(result.totalPrize()).isEqualTo(expectedSum);
    }
}
