package lotto.model.lotto;

import lotto.exception.ErrorMessage;
import lotto.exception.LottoException;
import lotto.model.constant.LottoRules;

public record Budget(int amount) {
    public Budget {
        if (amount <= 0 || amount % LottoRules.LOTTO_PRICE.getValue() != 0) {
            throw new LottoException(ErrorMessage.BUDGET_UNIT);
        }
    }

    public int ticketCount() {
        return amount / LottoRules.LOTTO_PRICE.getValue();
    }
}
