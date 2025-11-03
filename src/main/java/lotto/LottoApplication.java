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

    /**
     * 로또 애플리케이션의 메인 실행 로직
     * 예산 입력, 로또 구매, 당첨 번호 입력, 결과 평가 및 출력을 순차적으로 수행
     */
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

    /**
     * 예산을 입력받는 메서드
     * 잘못된 입력 시 재시도
     *
     * @return 입력된 예산 금액
     */
    private int readBudget() {
        return InputRetryHandler.retry(() -> {
            String input = InputView.readBudget();
            return BudgetValidator.parseAmount(input);
        });
    }

    /**
     * 당첨 로또 번호와 보너스 번호를 입력받는 메서드
     * 잘못된 입력 시 재시도
     *
     * @return 입력된 당첨 로또 정보
     */
    private PrizeLotto readPrizeLotto() {
        List<Integer> winningNumbers = readWinningNumbers();
        return InputRetryHandler.retry(() -> {
            int bonusNumber = readBonusNumber();
            return new PrizeLotto(winningNumbers, bonusNumber);
        });
    }

    /**
     * 당첨 번호를 입력받는 메서드
     * 잘못된 입력 시 재시도
     *
     * @return 입력된 당첨 번호 목록
     */
    private List<Integer> readWinningNumbers() {
        return InputRetryHandler.retry(() -> {
            String input = InputView.readWinningNumbers();
            List<Integer> numbers = LottoNumberParser.parseNumbers(input);
            new Lotto(numbers);
            return numbers;
        });
    }

    /**
     * 보너스 번호를 입력받는 메서드
     * 잘못된 입력 시 재시도
     *
     * @return 입력된 보너스 번호
     */
    private int readBonusNumber() {
        return InputRetryHandler.retry(() -> {
            String input = InputView.readBonusNumber();
            return LottoNumberParser.parseBonus(input);
        });
    }

    /**
     * 지정된 개수만큼 로또를 구매하는 메서드
     *
     * @param count 구매할 로또 개수
     * @return 구매한 로또 목록
     */
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
