package lotto.model.lotto;

import lotto.exception.ErrorMessage;
import lotto.exception.LottoException;
import lotto.model.constant.LottoRules;

import java.util.List;

public class PrizeLotto {
    private final Lotto winning;
    private final int bonus;

    public PrizeLotto(List<Integer> winningNumbers, int bonus) {
        this.winning = new Lotto(winningNumbers);
        if (bonus < LottoRules.MIN_NUMBER || bonus > LottoRules.MAX_NUMBER) {
            throw new LottoException(ErrorMessage.BONUS_RANGE);
        }

        if (winningNumbers.contains(bonus)) {
            throw new LottoException(ErrorMessage.BONUS_DUPLICATE);
        }

        this.bonus = bonus;
    }

    public boolean contains(int number) {
        return winning.getNumbers().contains(number);
    }

    public boolean isBonus(Lotto lotto) {
        return lotto.getNumbers().contains(bonus);
    }
}
