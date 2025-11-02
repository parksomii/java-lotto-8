package lotto.util;

import lotto.exception.ErrorMessage;
import lotto.exception.LottoException;
import lotto.model.constant.LottoRules;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public final class LottoNumberParser {
    public static final String NUMBER_DELIMITER = ",";

    private LottoNumberParser() {
    }

    public static List<Integer> parseNumbers(String input) {
        try {
            return Arrays.stream(input.split(NUMBER_DELIMITER))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new LottoException(ErrorMessage.WINNING_PARSE);
        }
    }

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
        if (number < LottoRules.MIN_NUMBER.getValue() || number > LottoRules.MAX_NUMBER.getValue()) {
            throw new LottoException(ErrorMessage.BONUS_RANGE);
        }
    }
}
