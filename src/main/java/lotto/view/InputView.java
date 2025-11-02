package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.view.constant.ViewMessages;

public final class InputView {
    private InputView() {
    }

    public static String readBudget() {
        System.out.println(ViewMessages.getPurchasePrompt());
        return Console.readLine();
    }

    public static String readWinningNumbers() {
        System.out.println(ViewMessages.getWinningPrompt());
        return Console.readLine();
    }

    public static String readBonusNumber() {
        System.out.println(ViewMessages.getBonusPrompt());
        return Console.readLine();
    }
}
