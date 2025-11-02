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
        System.out.println(count + ViewMessages.getPurchasedCountSuffix());
    }

    public static void printTickets(List<Lotto> tickets) {
        System.out.print(OutputFormatBuilder.tickets(tickets));
    }

    public static void printStatistics(LottoResult result) {
        System.out.print(OutputFormatBuilder.statistics(result));
    }

    public static void printYield(long totalPrize, int budget) {
        BigDecimal yield = YieldCalculator.calculate(totalPrize, budget);
        String yieldPrefix = ViewMessages.getYieldPrefix();
        String yieldSuffix = ViewMessages.getYieldSuffix();
        System.out.println(yieldPrefix + yield + yieldSuffix);
    }

    public static void printError(String message) {
        System.out.println(message);
    }
}
