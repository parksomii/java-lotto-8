package lotto.model.lotto;

import lotto.exception.ErrorMessage;
import lotto.exception.LottoException;
import lotto.model.constant.LottoRules;

public record Budget(int amount) {
    private static final int MINIMUM_BUDGET_AMOUNT = 0;

    public Budget {
        int lottoPrice = LottoRules.getLottoPrice();
        if (amount <= MINIMUM_BUDGET_AMOUNT || amount % lottoPrice != MINIMUM_BUDGET_AMOUNT) {
            throw new LottoException(ErrorMessage.BUDGET_UNIT);
        }
    }

    public int ticketCount() {
        int lottoPrice = LottoRules.getLottoPrice();
        return amount / lottoPrice;
    }
}
