package lotto.model.lotto;

import lotto.exception.LottoException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

class LottoTest {

    @ParameterizedTest
    @MethodSource("invalidSizeProvider")
    @DisplayName("번호가 6개가 아니면 예외 발생")
    void size_must_be_6(List<Integer> numbers) {
        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(LottoException.class);
    }

    static Stream<Arguments> invalidSizeProvider() {
        return Stream.of(
                Arguments.of(List.of(1,2,3,4,5)),
                Arguments.of(List.of(1,2,3,4,5,6,7)),
                Arguments.of(List.of(1,2,3)),
                Arguments.of(List.of(1,2,3,4,5,6,7,8))
        );
    }

    @ParameterizedTest
    @MethodSource("duplicatedNumberProvider")
    @DisplayName("중복 번호 입력시 예외 발생")
    void duplicated_number(List<Integer> numbers) {
        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(LottoException.class);
    }

    static Stream<Arguments> duplicatedNumberProvider() {
        return Stream.of(
                Arguments.of(List.of(1,2,3,3,5,6)),
                Arguments.of(List.of(1,1,2,3,4,5)),
                Arguments.of(List.of(1,2,3,4,5,5))
        );
    }

    @ParameterizedTest
    @MethodSource("invalidRangeProvider")
    @DisplayName("모든 번호는 1~45 범위여야 함")
    void number_range_invalid(List<Integer> numbers) {
        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(LottoException.class);
    }

    static Stream<Arguments> invalidRangeProvider() {
        return Stream.of(
                Arguments.of(List.of(0,2,3,4,5,6)),
                Arguments.of(List.of(1,2,3,4,5,46)),
                Arguments.of(List.of(-1,2,3,4,5,6)),
                Arguments.of(List.of(1,2,3,4,5,47))
        );
    }

    @ParameterizedTest
    @MethodSource("sortingProvider")
    @DisplayName("숫자는 오름차순으로 제공됨")
    void should_always_sorted(List<Integer> input, List<Integer> expected) {
        Lotto lotto = new Lotto(input);
        assertThat(lotto.getNumbers()).containsExactlyElementsOf(expected);
    }

    static Stream<Arguments> sortingProvider() {
        return Stream.of(
                Arguments.of(List.of(6,5,4,3,2,1), List.of(1,2,3,4,5,6)),
                Arguments.of(List.of(10,1,20,2,30,3), List.of(1,2,3,10,20,30)),
                Arguments.of(List.of(45,44,43,42,41,40), List.of(40,41,42,43,44,45))
        );
    }
}


