package lotto.model.result;

import java.math.BigDecimal;
import java.math.RoundingMode;

public final class YieldCalculator {
    private static final int PERCENTAGE_MULTIPLIER = 100;
    private static final int DECIMAL_SCALE_FOR_YIELD = 1;

    private YieldCalculator() {
    }

    public static BigDecimal calculate(long totalPrize, int budget) {
        return BigDecimal.valueOf(totalPrize)
                .multiply(BigDecimal.valueOf(PERCENTAGE_MULTIPLIER))
                .divide(BigDecimal.valueOf(budget), DECIMAL_SCALE_FOR_YIELD, RoundingMode.HALF_UP);
    }
}
