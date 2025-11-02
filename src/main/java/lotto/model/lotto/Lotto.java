package lotto.model.lotto;

import lotto.model.constant.LottoRules;
import lotto.exception.ErrorMessage;
import lotto.exception.LottoException;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers.stream()
                .sorted()
                .toList();
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicates(numbers);
        validateRange(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != LottoRules.LOTTO_NUMBERS_COUNT.getValue()) {
            throw new LottoException(ErrorMessage.LOTTO_SIZE);
        }
    }

    private void validateDuplicates(List<Integer> numbers) {
        Set<Integer> uniq = new HashSet<>(numbers);
        if (uniq.size() != LottoRules.LOTTO_NUMBERS_COUNT.getValue()) {
            throw new LottoException(ErrorMessage.LOTTO_DUPLICATE);
        }
    }

    private void validateRange(List<Integer> numbers) {
        if (hasOutOfRange(numbers)) {
            throw new LottoException(ErrorMessage.LOTTO_RANGE);
        }
    }

    private boolean hasOutOfRange(List<Integer> numbers) {
        return numbers.stream()
                .anyMatch(n -> n == null || n < LottoRules.MIN_NUMBER.getValue() || n > LottoRules.MAX_NUMBER.getValue());
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
