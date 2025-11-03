package lotto.util;

import lotto.exception.LottoException;
import lotto.view.OutputView;

import java.util.function.Supplier;

/**
 * 입력 재시도 로직을 처리하는 유틸리티 클래스
 */
public final class InputRetryHandler {
    private InputRetryHandler() {
    }

    /**
     * 예외 발생 시 재시도하는 메서드
     * LottoException 발생 시 에러 메시지를 출력하고 재시도
     *
     * @param supplier 실행할 작업
     * @param <T> 반환 타입
     * @return 작업 결과
     */
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

