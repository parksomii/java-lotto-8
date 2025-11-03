package lotto.exception;

public enum ErrorMessage {
    LOTTO_SIZE("로또 번호는 6개여야 합니다."),
    LOTTO_DUPLICATE("로또 번호는 중복될 수 없습니다."),
    LOTTO_RANGE("로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    BUDGET_UNIT("구입 금액은 1,000원 단위의 양수여야 합니다."),
    BUDGET_NOT_NUMBER("구입 금액은 숫자여야 합니다."),
    WINNING_PARSE("로또 번호는 쉼표(,)로 구분된 숫자여야 합니다."),
    WINNING_EMPTY("로또 번호는 빈 값일 수 없습니다."),
    BONUS_RANGE("보너스 번호는 1부터 45 사이여야 합니다."),
    BONUS_NOT_NUMBER("보너스 번호는 숫자여야 합니다."),
    BONUS_DUPLICATE("보너스 번호는 당첨 번호와 중복될 수 없습니다.");

    private static final String PREFIX = "[ERROR] ";

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String text() {
        return PREFIX + message;
    }
}
