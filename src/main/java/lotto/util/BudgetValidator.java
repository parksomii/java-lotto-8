package lotto.util;

import lotto.exception.ErrorMessage;
import lotto.exception.LottoException;
import lotto.model.constant.LottoRules;

public final class BudgetValidator {
    private BudgetValidator() { }

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
