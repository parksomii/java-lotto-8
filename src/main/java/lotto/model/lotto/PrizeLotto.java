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
        int minNumber = LottoRules.getMinNumber();
        int maxNumber = LottoRules.getMaxNumber();
        if (bonus < minNumber || bonus > maxNumber) {
            throw new LottoException(ErrorMessage.BONUS_RANGE);
        }

        if (winningNumbers.contains(bonus)) {
            throw new LottoException(ErrorMessage.BONUS_DUPLICATE);
        }

        this.bonus = bonus;
    }

    public boolean contains(int number) {
        return winning.contains(number);
    }

    public boolean isBonus(Lotto lotto) {
        return lotto.contains(bonus);
    }
}
