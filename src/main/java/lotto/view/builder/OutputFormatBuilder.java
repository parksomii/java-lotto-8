package lotto.view.builder;

import lotto.model.lotto.Lotto;
import lotto.model.result.LottoRank;
import lotto.model.result.LottoResult;
import lotto.view.constant.ViewMessages;

import java.util.List;

/**
 * 출력 포맷을 생성하는 빌더 클래스
 */
public final class OutputFormatBuilder {
    private OutputFormatBuilder() {
    }

    /**
     * 로또 티켓 목록을 문자열 포맷으로 변환
     *
     * @param tickets 로또 티켓 목록
     * @return 포맷팅된 티켓 목록 문자열
     */
    public static String tickets(List<Lotto> tickets) {
        StringBuilder sb = new StringBuilder();
        String lineSeparator = ViewMessages.getLineSeparator();
        for (Lotto lotto : tickets) {
            List<Integer> numbers = lotto.getNumbers();
            String numbersString = numbers.toString();
            sb.append(numbersString).append(lineSeparator);
        }
        return sb.toString();
    }

    /**
     * 당첨 통계를 문자열 포맷으로 변환
     *
     * @param result 당첨 결과
     * @return 포맷팅된 통계 문자열
     */
    public static String statistics(LottoResult result) {
        String lineSeparator = ViewMessages.getLineSeparator();
        String statsTitle = ViewMessages.getStatsTitle();
        String statsDivider = ViewMessages.getStatsDivider();
        return String.join(lineSeparator,
                statsTitle,
                statsDivider,
                line(result, LottoRank.FIFTH),
                line(result, LottoRank.FOURTH),
                line(result, LottoRank.THIRD),
                line(result, LottoRank.SECOND),
                line(result, LottoRank.FIRST),
                ""
        );
    }

    /**
     * 특정 등급의 당첨 통계 라인을 생성
     *
     * @param result 당첨 결과
     * @param rank   당첨 등급
     * @return 포맷팅된 통계 라인
     */
    private static String line(LottoResult result, LottoRank rank) {
        String hyphen = ViewMessages.getHyphenWithSpaces();
        String countUnit = ViewMessages.getCountUnit();
        return rank.getDescription()
                + hyphen
                + result.getCount(rank)
                + countUnit;
    }
}
