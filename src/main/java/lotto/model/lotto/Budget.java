package lotto.model.lotto;

import lotto.exception.ErrorMessage;
import lotto.exception.LottoException;
import lotto.model.constant.LottoRules;

public record Budget(int amount) {
    public Budget {
        int lottoPrice = LottoRules.getLottoPrice();
        if (amount <= 0 || amount % lottoPrice != 0) {
            throw new LottoException(ErrorMessage.BUDGET_UNIT);
        }
    }

    public int ticketCount() {
        int lottoPrice = LottoRules.getLottoPrice();
        return amount / lottoPrice;
    }
}
