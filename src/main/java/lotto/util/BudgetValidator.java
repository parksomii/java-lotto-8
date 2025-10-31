package lotto.util;

import lotto.exception.ErrorMessage;
import lotto.exception.LottoException;
import lotto.model.constant.LottoRules;

public final class BudgetValidator {
    private BudgetValidator() { }

    public static int parseAmount(String input) {
        try {
            int amount = Integer.parseInt(input.trim());
            if (amount <= 0 || amount % LottoRules.LOTTO_PRICE != 0) {
                throw new LottoException(ErrorMessage.BUDGET_UNIT);
            }
            return amount;
        } catch (NumberFormatException e) {
            throw new LottoException(ErrorMessage.BUDGET_NOT_NUMBER);
        }
    }
}
