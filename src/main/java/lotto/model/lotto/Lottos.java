package lotto.model.lotto;

import lotto.model.result.LottoRank;
import lotto.model.result.LottoResult;

import java.util.List;

/**
 * 여러 로또 티켓을 관리하는 Record
 */
public record Lottos(List<Lotto> tickets) {

    /**
     * 로또 티켓 목록 생성자
     *
     * @param tickets 로또 티켓 목록
     */
    public Lottos(List<Lotto> tickets) {
        this.tickets = List.copyOf(tickets);
    }

    /**
     * 당첨 로또와 비교하여 당첨 결과를 평가
     *
     * @param prizeLotto 당첨 로또 정보
     * @return 당첨 결과
     */
    public LottoResult evaluate(PrizeLotto prizeLotto) {
        LottoResult result = new LottoResult();
        tickets.forEach(ticket -> evaluateTicket(ticket, prizeLotto, result));
        return result;
    }

    private void evaluateTicket(Lotto ticket, PrizeLotto prizeLotto, LottoResult result) {
        int matchCount = LottoMatcher.countMatches(ticket, prizeLotto);
        boolean bonusMatch = prizeLotto.isBonus(ticket);
        LottoRank rank = LottoRank.of(matchCount, bonusMatch);

        if (rank != LottoRank.NONE) {
            result.add(rank);
        }
    }
}
