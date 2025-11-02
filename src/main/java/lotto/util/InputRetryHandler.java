package lotto.util;

import lotto.exception.LottoException;
import lotto.view.OutputView;

import java.util.function.Supplier;

public final class InputRetryHandler {
    private InputRetryHandler() {
    }

    public static <T> T retry(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (LottoException e) {
                OutputView.printError(e.getMessage());
            }
        }
    }
}

