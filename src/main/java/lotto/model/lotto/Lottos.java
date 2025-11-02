package lotto.model.lotto;

import lotto.model.result.LottoRank;
import lotto.model.result.LottoResult;

import java.util.List;

public record Lottos(List<Lotto> tickets) {

    public Lottos(List<Lotto> tickets) {
        this.tickets = List.copyOf(tickets);
    }

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
