package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.exception.LottoException;
import lotto.model.constant.LottoRules;
import lotto.model.lotto.Budget;
import lotto.model.lotto.Lotto;
import lotto.model.lotto.Lottos;
import lotto.model.lotto.PrizeLotto;
import lotto.model.result.LottoResult;
import lotto.util.BudgetValidator;
import lotto.util.LottoNumberParser;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoApplication {

    public void run() {
        int budgetAmount = readBudgetWithRetry();
        Budget budget = new Budget(budgetAmount);

        Lottos purchased = purchase(budget.ticketCount());
        OutputView.printTicketCount(budget.ticketCount());
        OutputView.printTickets(purchased.tickets());

        PrizeLotto prizeLotto = readPrizeLottoWithRetry();

        LottoResult result = purchased.evaluate(prizeLotto);
        OutputView.printStatistics(result);
        OutputView.printYield(result.totalPrize(), budget.amount());
    }

    private int readBudgetWithRetry() {
        while (true) {
            try {
                String input = InputView.readBudget();
                return BudgetValidator.parseAmount(input);
            } catch (LottoException e) {
                OutputView.printError(e.getMessage());
            }
        }
    }

    private PrizeLotto readPrizeLottoWithRetry() {
        List<Integer> winningNumbers = readWinningNumbers();
        while (true) {
            try {
                int bonusNumber = readBonusNumber();
                return new PrizeLotto(winningNumbers, bonusNumber);
            } catch (LottoException e) {
                OutputView.printError(e.getMessage());
            }
        }
    }

    private List<Integer> readWinningNumbers() {
        while (true) {
            try {
                String input = InputView.readWinningNumbers();
                List<Integer> numbers = LottoNumberParser.parseNumbers(input);
                new Lotto(numbers);
                return numbers;
            } catch (LottoException e) {
                OutputView.printError(e.getMessage());
            }
        }
    }

    private int readBonusNumber() {
        while (true) {
            try {
                String input = InputView.readBonusNumber();
                return LottoNumberParser.parseBonus(input);
            } catch (LottoException e) {
                OutputView.printError(e.getMessage());
            }
        }
    }

    private Lottos purchase(int count) {
        List<Lotto> tickets = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            tickets.add(new Lotto(
                    Randoms.pickUniqueNumbersInRange(
                            LottoRules.MIN_NUMBER.getValue(),
                            LottoRules.MAX_NUMBER.getValue(),
                            LottoRules.LOTTO_NUMBERS_COUNT.getValue())));
        }
        return new Lottos(tickets);
    }
}
