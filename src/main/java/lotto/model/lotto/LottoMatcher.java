package lotto.model.lotto;

import java.util.List;

public final class LottoMatcher {
    private LottoMatcher() {
    }

    public static int countMatches(Lotto ticket, PrizeLotto prizeLotto) {
        List<Integer> numbers = ticket.getNumbers();
        return (int) numbers.stream()
                .filter(prizeLotto::contains)
                .count();
    }
}
