package lotto.util;

import lotto.exception.ErrorMessage;
import lotto.exception.LottoException;
import lotto.model.constant.LottoRules;

/**
 * 예산 입력을 파싱하고 검증하는 유틸리티 클래스
 */
public final class BudgetValidator {
    private BudgetValidator() { }

    /**
     * 문자열 입력을 파싱하여 예산 금액을 반환
     *
     * @param input 입력 문자열
     * @return 파싱된 예산 금액
     * @throws LottoException 입력이 숫자가 아니거나 유효하지 않은 경우
     */
    public static int parseAmount(String input) {
        try {
            int amount = Integer.parseInt(input.trim());
            validateAmount(amount);
            return amount;
        } catch (NumberFormatException e) {
            throw new LottoException(ErrorMessage.BUDGET_NOT_NUMBER);
        }
    }

    private static void validateAmount(int amount) {
        int lottoPrice = LottoRules.getLottoPrice();
        if (amount <= 0 || amount % lottoPrice != 0) {
            throw new LottoException(ErrorMessage.BUDGET_UNIT);
        }
    }
}
