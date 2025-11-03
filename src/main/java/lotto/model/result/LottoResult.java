package lotto.model.result;

import java.util.EnumMap;
import java.util.Map;

/**
 * 로또 당첨 결과를 관리하는 클래스
 */
public class LottoResult {
    private final Map<LottoRank, Integer> rankCounts = new EnumMap<>(LottoRank.class);

    /**
     * 로또 결과 생성자
     * 모든 등급의 당첨 개수를 0으로 초기화
     */
    public LottoResult() {
        for (LottoRank rank : LottoRank.values()) {
            rankCounts.put(rank, 0);
        }
    }

    /**
     * 특정 등급의 당첨 개수를 증가
     *
     * @param rank 당첨 등급
     */
    public void add(LottoRank rank) {
        rankCounts.put(rank, rankCounts.get(rank) + 1);
    }

    /**
     * 특정 등급의 당첨 개수를 반환
     *
     * @param rank 당첨 등급
     * @return 당첨 개수
     */
    public int getCount(LottoRank rank) {
        return rankCounts.get(rank);
    }

    /**
     * 모든 등급의 총 당첨금을 계산
     *
     * @return 총 당첨금
     */
    public long totalPrize() {
        long sum = 0L;
        for (Map.Entry<LottoRank, Integer> entry : rankCounts.entrySet()) {
            LottoRank rank = entry.getKey();
            int count = entry.getValue();
            sum += rank.getPrize() * count;
        }
        return sum;
    }
}
