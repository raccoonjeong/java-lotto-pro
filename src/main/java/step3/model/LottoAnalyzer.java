package step3.model;

import java.util.List;
import step3.view.OutputView;

public class LottoAnalyzer {

    int[] countBoard = new int[7];
    int lottoCount;

    public LottoAnalyzer(LastWinningLotto lastWinningLotto, List<Lotto> lottos) {
        lottoCount = lottos.size();
        for (Lotto lotto : lottos) {
            countBoard[lastWinningLotto.howManyRight(lotto)] ++;
        }
    }

    public int numberMatches(int number) {
        return countBoard[number];
    }

    public double calculateYield() {
        double yield = calculateReward() / (double) (lottoCount * 1_000);
        return yield;
    }

    public long calculateReward() {
        OutputView.printWinsStatistics();
        long totalReward = 0;
        for (MatchReward reward : MatchReward.values()) {
            OutputView.printMatchCount(reward.getMatchCount(), reward.getReward(), countBoard[reward.getMatchCount()]);
            totalReward += countBoard[reward.getMatchCount()] * reward.getReward();
        }
        return totalReward;
    }

    public int[] getCountBoard() {
        return countBoard;
    }

    public String furtherExplain(double yield) {
        if (yield < (double)1) {
            return "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";
        }
        if (yield == (double)1) {
            return "(기준이 1이기 때문에 결과적으로 본전만 찾았다는 의미임)";
        }
        return "(기준이 1이기 때문에 결과적으로 이익이라는 의미임)";
    }
}
