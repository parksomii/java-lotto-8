package lotto.model.result;

import java.util.Arrays;

/**
 * 로또 당첨 등급을 나타내는 Enum
 */
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

    /**
     * 당첨 등급 생성자
     *
     * @param matchCount 일치하는 번호 개수
     * @param bonusMatchRequired 보너스 번호 일치 필요 여부
     * @param prize 당첨금
     * @param description 설명
     */
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

    /**
     * 일치하는 번호 개수와 보너스 번호 일치 여부로 당첨 등급을 결정
     *
     * @param matchCount 일치하는 번호 개수
     * @param bonusMatch 보너스 번호 일치 여부
     * @return 해당하는 당첨 등급
     */
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
