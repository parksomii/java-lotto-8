package lotto.model.lotto;

import lotto.exception.ErrorMessage;
import lotto.exception.LottoException;
import lotto.model.constant.LottoRules;

import java.util.List;

/**
 * 당첨 로또 번호와 보너스 번호를 관리하는 클래스
 */
public class PrizeLotto {
    private final Lotto winning;
    private final int bonus;

    /**
     * 당첨 로또 생성자
     * 당첨 번호와 보너스 번호를 검증하여 저장
     *
     * @param winningNumbers 당첨 번호 목록
     * @param bonus 보너스 번호
     * @throws LottoException 보너스 번호가 유효하지 않은 경우
     */
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

    /**
     * 특정 번호가 당첨 번호에 포함되어 있는지 확인
     *
     * @param number 확인할 번호
     * @return 포함 여부
     */
    public boolean contains(int number) {
        return winning.contains(number);
    }

    /**
     * 로또에 보너스 번호가 포함되어 있는지 확인
     *
     * @param lotto 확인할 로또
     * @return 보너스 번호 포함 여부
     */
    public boolean isBonus(Lotto lotto) {
        return lotto.contains(bonus);
    }
}
