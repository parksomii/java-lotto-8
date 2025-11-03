package lotto.model.result;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * 로또 수익률을 계산하는 유틸리티 클래스
 */
public final class YieldCalculator {
    private static final int PERCENTAGE_MULTIPLIER = 100;
    private static final int DECIMAL_SCALE_FOR_YIELD = 1;

    private YieldCalculator() {
    }

    /**
     * 총 당첨금과 예산을 기반으로 수익률을 계산
     *
     * @param totalPrize 총 당첨금
     * @param budget 예산
     * @return 소수점 첫째 자리까지 반올림된 수익률
     */
    public static BigDecimal calculate(long totalPrize, int budget) {
        return BigDecimal.valueOf(totalPrize)
                .multiply(BigDecimal.valueOf(PERCENTAGE_MULTIPLIER))
                .divide(BigDecimal.valueOf(budget), DECIMAL_SCALE_FOR_YIELD, RoundingMode.HALF_UP);
    }
}
