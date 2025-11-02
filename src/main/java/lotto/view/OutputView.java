package lotto.view;

import lotto.model.lotto.Lotto;
import lotto.model.result.LottoResult;
import lotto.model.result.YieldCalculator;
import lotto.view.builder.OutputFormatBuilder;
import lotto.view.constant.ViewMessages;

import java.math.BigDecimal;
import java.util.List;

public final class OutputView {
    private OutputView() {
    }

    public static void printTicketCount(int count) {
        System.out.println(count + ViewMessages.PURCHASED_COUNT_SUFFIX);
    }

    public static void printTickets(List<Lotto> tickets) {
        System.out.print(OutputFormatBuilder.tickets(tickets));
    }

    public static void printStatistics(LottoResult result) {
        System.out.print(OutputFormatBuilder.statistics(result));
    }

    public static void printYield(long totalPrize, int budget) {
        BigDecimal yield = YieldCalculator.calculate(totalPrize, budget);
        System.out.println(ViewMessages.YIELD_PREFIX + yield + ViewMessages.YIELD_SUFFIX);
    }

    public static void printError(String message) {
        System.out.println(message);
    }
}
