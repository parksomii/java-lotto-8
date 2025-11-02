package lotto.model.constant;

public enum LottoRules {
    LOTTO_PRICE(1000),
    LOTTO_NUMBERS_COUNT(6),
    MIN_NUMBER(1),
    MAX_NUMBER(45);

    private final int value;

    LottoRules(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static int getLottoPrice() {
        return LOTTO_PRICE.getValue();
    }

    public static int getLottoNumbersCount() {
        return LOTTO_NUMBERS_COUNT.getValue();
    }

    public static int getMinNumber() {
        return MIN_NUMBER.getValue();
    }

    public static int getMaxNumber() {
        return MAX_NUMBER.getValue();
    }
}
