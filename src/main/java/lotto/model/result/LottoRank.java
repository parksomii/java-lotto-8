package lotto.model.result;

import java.util.Arrays;

public enum LottoRank {
    FIRST(6, false, 2_000_000_000L, "6개 일치 (2,000,000,000원)"),
    SECOND(5, true, 30_000_000L, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    THIRD(5, false, 1_500_000L, "5개 일치 (1,500,000원)"),
    FOURTH(4, false, 50_000L, "4개 일치 (50,000원)"),
    FIFTH(3, false, 5_000L, "3개 일치 (5,000원)"),
    NONE(0, false, 0L, "");

    private final int matchCount;
    private final boolean bonusMatchRequired;
    private final long prize;
    private final String description;

    LottoRank(int matchCount, boolean bonusMatchRequired, long prize, String description) {
        this.matchCount = matchCount;
        this.bonusMatchRequired = bonusMatchRequired;
        this.prize = prize;
        this.description = description;
    }

    public long getPrize() {
        return prize;
    }

    public String getDescription() {
        return description;
    }

    public static LottoRank of(int matchCount, boolean bonusMatch) {
        if (matchCount == 5 && bonusMatch) {
            return SECOND;
        }
        return Arrays.stream(values())
                .filter(r -> r.matchCount == matchCount && !r.bonusMatchRequired)
                .findFirst()
                .orElse(NONE);
    }
}
