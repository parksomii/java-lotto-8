package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.constant.LottoRules;
import lotto.model.lotto.Budget;
import lotto.model.lotto.Lotto;
import lotto.model.lotto.Lottos;
import lotto.model.lotto.PrizeLotto;
import lotto.model.result.LottoResult;
import lotto.util.BudgetValidator;
import lotto.util.InputRetryHandler;
import lotto.util.LottoNumberParser;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoApplication {

    public void run() {
        int budgetAmount = readBudget();
        Budget budget = new Budget(budgetAmount);

        Lottos purchased = purchase(budget.ticketCount());
        OutputView.printTicketCount(budget.ticketCount());
        OutputView.printTickets(purchased.tickets());

        PrizeLotto prizeLotto = readPrizeLotto();

        LottoResult result = purchased.evaluate(prizeLotto);
        OutputView.printStatistics(result);
        OutputView.printYield(result.totalPrize(), budget.amount());
    }

    private int readBudget() {
        return InputRetryHandler.retry(() -> {
            String input = InputView.readBudget();
            return BudgetValidator.parseAmount(input);
        });
    }

    private PrizeLotto readPrizeLotto() {
        List<Integer> winningNumbers = readWinningNumbers();
        return InputRetryHandler.retry(() -> {
            int bonusNumber = readBonusNumber();
            return new PrizeLotto(winningNumbers, bonusNumber);
        });
    }

    private List<Integer> readWinningNumbers() {
        return InputRetryHandler.retry(() -> {
            String input = InputView.readWinningNumbers();
            List<Integer> numbers = LottoNumberParser.parseNumbers(input);
            new Lotto(numbers);
            return numbers;
        });
    }

    private int readBonusNumber() {
        return InputRetryHandler.retry(() -> {
            String input = InputView.readBonusNumber();
            return LottoNumberParser.parseBonus(input);
        });
    }

    private Lottos purchase(int count) {
        List<Lotto> tickets = new ArrayList<>();
        int minNumber = LottoRules.getMinNumber();
        int maxNumber = LottoRules.getMaxNumber();
        int numbersCount = LottoRules.getLottoNumbersCount();
        for (int i = 0; i < count; i++) {
            tickets.add(new Lotto(
                    Randoms.pickUniqueNumbersInRange(minNumber, maxNumber, numbersCount)));
        }
        return new Lottos(tickets);
    }
}
