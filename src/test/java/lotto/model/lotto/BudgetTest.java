package lotto.model.lotto;

import lotto.exception.LottoException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

class BudgetTest {
    @ParameterizedTest
    @MethodSource("invalidBudgetProvider")
    @DisplayName("예산이 0 이하이거나 1000 미만이면 예외 발생")
    void must_be_positive_and_divisible(int amount) {
        assertThatThrownBy(() -> new Budget(amount))
                .isInstanceOf(LottoException.class);
    }

    static Stream<Arguments> invalidBudgetProvider() {
        return Stream.of(
                Arguments.of(-1000),
                Arguments.of(0),
                Arguments.of(1500),
                Arguments.of(999),
                Arguments.of(500),
                Arguments.of(-1)
        );
    }

    @ParameterizedTest
    @MethodSource("validTicketCountProvider")
    @DisplayName("1000원 단위로만 티켓 수 계산")
    void correct_ticket_count(int amount, int expectedTicketCount) {
        assertThat(new Budget(amount).ticketCount()).isEqualTo(expectedTicketCount);
    }

    static Stream<Arguments> validTicketCountProvider() {
        return Stream.of(
                Arguments.of(1000, 1),
                Arguments.of(3000, 3),
                Arguments.of(5000, 5),
                Arguments.of(10000, 10)
        );
    }
}
