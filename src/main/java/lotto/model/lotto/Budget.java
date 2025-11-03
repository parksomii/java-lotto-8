package lotto.model.lotto;

import lotto.exception.ErrorMessage;
import lotto.exception.LottoException;
import lotto.model.constant.LottoRules;

/**
 * 로또 구매 예산을 나타내는 Record
 */
public record Budget(int amount) {
    private static final int MINIMUM_BUDGET_AMOUNT = 0;

    /**
     * 예산 생성자 예산이 0보다 크고 로또 가격의 배수인지 검증
     *
     * @param amount 예산 금액
     * @throws LottoException 예산이 유효하지 않은 경우
     */
    public Budget {
        int lottoPrice = LottoRules.getLottoPrice();
        if (amount <= MINIMUM_BUDGET_AMOUNT || amount % lottoPrice != MINIMUM_BUDGET_AMOUNT) {
            throw new LottoException(ErrorMessage.BUDGET_UNIT);
        }
    }

    /**
     * 예산으로 구매 가능한 로또 티켓 개수를 반환
     *
     * @return 구매 가능한 로또 티켓 개수
     */
    public int ticketCount() {
        int lottoPrice = LottoRules.getLottoPrice();
        return amount / lottoPrice;
    }
}
