package lotto;

import lotto.exception.LottoException;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        try {
            new LottoApplication().run();
        } catch (LottoException e) {
            OutputView.printError(e.getMessage());
            throw e;
        }
    }
}
