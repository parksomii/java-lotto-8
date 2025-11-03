package lotto.model.lotto;

import java.util.List;

/**
 * 로또 티켓과 당첨 로또 간의 매칭을 처리하는 유틸리티 클래스
 */
public final class LottoMatcher {
    private LottoMatcher() {
    }

    /**
     * 로또 티켓과 당첨 로또 간의 일치하는 번호 개수를 계산
     *
     * @param ticket 로또 티켓
     * @param prizeLotto 당첨 로또
     * @return 일치하는 번호 개수
     */
    public static int countMatches(Lotto ticket, PrizeLotto prizeLotto) {
        List<Integer> numbers = ticket.getNumbers();
        return (int) numbers.stream()
                .filter(prizeLotto::contains)
                .count();
    }
}
