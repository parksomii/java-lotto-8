package lotto.view.constant;

public enum ViewMessages {
    PURCHASE_PROMPT("구입금액을 입력해 주세요."),
    WINNING_PROMPT("당첨 번호를 입력해 주세요."),
    BONUS_PROMPT("보너스 번호를 입력해 주세요."),
    PURCHASED_COUNT_SUFFIX("개를 구매했습니다."),
    STATS_TITLE("당첨 통계"),
    STATS_DIVIDER("---"),
    COUNT_UNIT("개"),
    HYPHEN_WITH_SPACES(" - "),
    YIELD_PREFIX("총 수익률은 "),
    YIELD_SUFFIX("%입니다.");

    private final String message;

    ViewMessages(String message) {
        this.message = message;
    }

    public String getValue() {
        return message;
    }

    public static String getLineSeparator() {
        return System.lineSeparator();
    }

    public static String getPurchasePrompt() {
        return PURCHASE_PROMPT.getValue();
    }

    public static String getWinningPrompt() {
        return WINNING_PROMPT.getValue();
    }

    public static String getBonusPrompt() {
        return BONUS_PROMPT.getValue();
    }

    public static String getPurchasedCountSuffix() {
        return PURCHASED_COUNT_SUFFIX.getValue();
    }

    public static String getStatsTitle() {
        return STATS_TITLE.getValue();
    }

    public static String getStatsDivider() {
        return STATS_DIVIDER.getValue();
    }

    public static String getCountUnit() {
        return COUNT_UNIT.getValue();
    }

    public static String getHyphenWithSpaces() {
        return HYPHEN_WITH_SPACES.getValue();
    }

    public static String getYieldPrefix() {
        return YIELD_PREFIX.getValue();
    }

    public static String getYieldSuffix() {
        return YIELD_SUFFIX.getValue();
    }
}
