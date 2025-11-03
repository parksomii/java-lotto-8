package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.view.constant.ViewMessages;

public final class InputView {
    private InputView() {
    }

    /**
     * 예산을 입력받는다
     *
     * @return 입력된 예산 문자열
     */
    public static String readBudget() {
        System.out.println(ViewMessages.getPurchasePrompt());
        return Console.readLine();
    }

    /**
     * 당첨 번호를 입력받는다
     *
     * @return 입력된 당첨 번호 문자열
     */
    public static String readWinningNumbers() {
        System.out.println(ViewMessages.getWinningPrompt());
        return Console.readLine();
    }

    /**
     * 보너스 번호를 입력받는다
     *
     * @return 입력된 보너스 번호 문자열
     */
    public static String readBonusNumber() {
        System.out.println(ViewMessages.getBonusPrompt());
        return Console.readLine();
    }
}
