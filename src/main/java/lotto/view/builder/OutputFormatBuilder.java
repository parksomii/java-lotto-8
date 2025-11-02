package lotto.view.builder;

import lotto.model.lotto.Lotto;
import lotto.model.result.LottoRank;
import lotto.model.result.LottoResult;
import lotto.view.constant.ViewMessages;

import java.util.List;

public final class OutputFormatBuilder {
    private OutputFormatBuilder() {
    }

    public static String tickets(List<Lotto> tickets) {
        StringBuilder sb = new StringBuilder();
        for (Lotto lotto : tickets) {
            List<Integer> numbers = lotto.getNumbers();
            String numbersString = numbers.toString();
            sb.append(numbersString).append(ViewMessages.LINE_SEPARATOR);
        }
        return sb.toString();
    }

    public static String statistics(LottoResult result) {
        return String.join(ViewMessages.LINE_SEPARATOR,
                ViewMessages.STATS_TITLE,
                ViewMessages.STATS_DIVIDER,
                line(result, LottoRank.FIFTH),
                line(result, LottoRank.FOURTH),
                line(result, LottoRank.THIRD),
                line(result, LottoRank.SECOND),
                line(result, LottoRank.FIRST),
                ""
        );
    }

    private static String line(LottoResult result, LottoRank rank) {
        return rank.getDescription()
                + ViewMessages.HYPHEN_WITH_SPACES
                + result.getCount(rank)
                + ViewMessages.COUNT_UNIT;
    }
}
