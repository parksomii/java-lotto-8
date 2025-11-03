package lotto.model.lotto;

import lotto.model.constant.LottoRules;
import lotto.exception.ErrorMessage;
import lotto.exception.LottoException;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 단일 로또 번호를 나타내는 클래스
 */
public class Lotto {
    private final List<Integer> numbers;

    /**
     * 로또 번호 생성자
     * 번호 목록을 검증하고 정렬하여 저장
     *
     * @param numbers 로또 번호 목록
     * @throws LottoException 번호가 유효하지 않은 경우
     */
    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers.stream()
                .sorted()
                .toList();
    }

    /**
     * 로또 번호 목록을 검증
     *
     * @param numbers 검증할 번호 목록
     */
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

    /**
     * 로또 번호 목록을 반환
     *
     * @return 로또 번호 목록
     */
    public List<Integer> getNumbers() {
        return numbers;
    }

    /**
     * 특정 번호가 포함되어 있는지 확인
     *
     * @param number 확인할 번호
     * @return 포함 여부
     */
    public boolean contains(int number) {
        return numbers.contains(number);
    }
}
