package step3;

import java.util.List;

public class LottoAnalyzer {

    int[] countBoard = new int[7];

    public LottoAnalyzer(LastWinningLotto lastWinningLotto, List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            Long rightCount = lastWinningLotto.howManyRight(lotto);
            countBoard[rightCount.intValue()] ++;
        }
    }

    public int numberMatches(int number) {
        return countBoard[number];
    }

    double calculateYield(long payment) {
        double yield = calculateReward() / (double) payment;
        System.out.printf("총 수익률은 %.2f입니다.", yield);
        furtherExplain(yield);
        return yield;
    }

    long calculateReward() {
        System.out.println("\n당첨 통계\n---------");
        long totalReward = 0;
        for (MatchReward reward : MatchReward.values()) {
            System.out.printf("%d개 일치 (%d)- %d개%n", reward.getMatchCount(), reward.getReward(), countBoard[reward.getMatchCount()]);
            totalReward += countBoard[reward.getMatchCount()] * reward.getReward();
        }
        return totalReward;
    }

    void furtherExplain(double yield) {
        if (yield < (double)1) {
            System.out.println("(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
        }
        if (yield == (double)1) {
            System.out.println("(기준이 1이기 때문에 결과적으로 본전만 찾았다는 의미임)");
        }
        if (yield > (double)1) {
            System.out.println("(기준이 1이기 때문에 결과적으로 이익이라는 의미임)");
        }
    }
}
