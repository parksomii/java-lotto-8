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
        if (numbers.size() != LottoRules.LOTTO_NUMBERS_COUNT) {
            throw new LottoException(ErrorMessage.LOTTO_SIZE);
        }
        Set<Integer> uniq = new HashSet<>(numbers);
        if (uniq.size() != LottoRules.LOTTO_NUMBERS_COUNT) {
            throw new LottoException(ErrorMessage.LOTTO_DUPLICATE);
        }

        boolean isOutOfRange = numbers.stream()
                .anyMatch(n -> n == null || n < LottoRules.MIN_NUMBER || n > LottoRules.MAX_NUMBER);
        if (isOutOfRange) {
            throw new LottoException(ErrorMessage.LOTTO_RANGE);
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
