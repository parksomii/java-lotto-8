package lotto.model.result;

import java.util.EnumMap;
import java.util.Map;

public class LottoResult {
    private final Map<LottoRank, Integer> rankCounts = new EnumMap<>(LottoRank.class);

    public LottoResult() {
        for (LottoRank rank : LottoRank.values()) {
            rankCounts.put(rank, 0);
        }
    }

    public void add(LottoRank rank) {
        rankCounts.put(rank, rankCounts.get(rank) + 1);
    }

    public int getCount(LottoRank rank) {
        return rankCounts.get(rank);
    }

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
