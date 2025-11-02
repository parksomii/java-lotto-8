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
        int requiredCount = LottoRules.getLottoNumbersCount();
        if (numbers.size() != requiredCount) {
            throw new LottoException(ErrorMessage.LOTTO_SIZE);
        }
    }

    private void validateDuplicates(List<Integer> numbers) {
        Set<Integer> uniq = new HashSet<>(numbers);
        int requiredCount = LottoRules.getLottoNumbersCount();
        if (uniq.size() != requiredCount) {
            throw new LottoException(ErrorMessage.LOTTO_DUPLICATE);
        }
    }

    private void validateRange(List<Integer> numbers) {
        if (hasOutOfRange(numbers)) {
            throw new LottoException(ErrorMessage.LOTTO_RANGE);
        }
    }

    private boolean hasOutOfRange(List<Integer> numbers) {
        int minNumber = LottoRules.getMinNumber();
        int maxNumber = LottoRules.getMaxNumber();
        return numbers.stream()
                .anyMatch(n -> isInvalidNumber(n, minNumber, maxNumber));
    }

    private boolean isInvalidNumber(Integer number, int minNumber, int maxNumber) {
        return number == null || number < minNumber || number > maxNumber;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }
}
