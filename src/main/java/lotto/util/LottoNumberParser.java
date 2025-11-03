package lotto.util;

import lotto.exception.ErrorMessage;
import lotto.exception.LottoException;
import lotto.model.constant.LottoRules;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 로또 번호 입력을 파싱하는 유틸리티 클래스
 */
public final class LottoNumberParser {
    public static final String NUMBER_DELIMITER = ",";

    private LottoNumberParser() {
    }

    /**
     * 쉼표로 구분된 로또 번호 문자열을 파싱하여 숫자 목록으로 반환
     *
     * @param input 쉼표로 구분된 번호 문자열
     * @return 파싱된 번호 목록
     * @throws LottoException 입력이 유효하지 않은 경우
     */
    public static List<Integer> parseNumbers(String input) {
        try {
            return Arrays.stream(input.trim().split(NUMBER_DELIMITER))
                    .map(String::trim)
                    .filter(s -> !s.isEmpty())
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new LottoException(ErrorMessage.WINNING_PARSE);
        }
    }

    /**
     * 보너스 번호 문자열을 파싱하여 숫자로 반환
     *
     * @param input 보너스 번호 문자열
     * @return 파싱된 보너스 번호
     * @throws LottoException 입력이 숫자가 아니거나 범위를 벗어난 경우
     */
    public static int parseBonus(String input) {
        try {
            int n = Integer.parseInt(input.trim());
            validateBonusRange(n);
            return n;
        } catch (NumberFormatException e) {
            throw new LottoException(ErrorMessage.BONUS_NOT_NUMBER);
        }
    }

    private static void validateBonusRange(int number) {
        int minNumber = LottoRules.getMinNumber();
        int maxNumber = LottoRules.getMaxNumber();
        if (number < minNumber || number > maxNumber) {
            throw new LottoException(ErrorMessage.BONUS_RANGE);
        }
    }
}
