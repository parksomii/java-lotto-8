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

    /**
     * 구매한 로또 티켓 개수를 출력
     *
     * @param count 구매한 티켓 개수
     */
    public static void printTicketCount(int count) {
        System.out.println(count + ViewMessages.getPurchasedCountSuffix());
    }

    /**
     * 구매한 로또 티켓 목록을 출력
     *
     * @param tickets 로또 티켓 목록
     */
    public static void printTickets(List<Lotto> tickets) {
        System.out.print(OutputFormatBuilder.tickets(tickets));
    }

    /**
     * 당첨 통계를 출력
     *
     * @param result 당첨 결과
     */
    public static void printStatistics(LottoResult result) {
        System.out.print(OutputFormatBuilder.statistics(result));
    }

    /**
     * 수익률을 출력
     *
     * @param totalPrize 총 당첨금
     * @param budget 예산
     */
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
