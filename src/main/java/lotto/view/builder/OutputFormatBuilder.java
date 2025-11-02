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
        String lineSeparator = ViewMessages.getLineSeparator();
        for (Lotto lotto : tickets) {
            List<Integer> numbers = lotto.getNumbers();
            String numbersString = numbers.toString();
            sb.append(numbersString).append(lineSeparator);
        }
        return sb.toString();
    }

    public static String statistics(LottoResult result) {
        String lineSeparator = ViewMessages.getLineSeparator();
        String statsTitle = ViewMessages.getStatsTitle();
        String statsDivider = ViewMessages.getStatsDivider();
        return String.join(lineSeparator,
                statsTitle,
                statsDivider,
                line(result, LottoRank.FIFTH),
                line(result, LottoRank.FOURTH),
                line(result, LottoRank.THIRD),
                line(result, LottoRank.SECOND),
                line(result, LottoRank.FIRST),
                ""
        );
    }

    private static String line(LottoResult result, LottoRank rank) {
        String hyphen = ViewMessages.getHyphenWithSpaces();
        String countUnit = ViewMessages.getCountUnit();
        return rank.getDescription()
                + hyphen
                + result.getCount(rank)
                + countUnit;
    }
}
