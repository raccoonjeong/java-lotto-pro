package step3.model;

import java.util.List;

public class LottoAnalyzer {

    CountBoard countBoard;
    int lottoCount;

    public LottoAnalyzer(LastWinningLotto lastWinningLotto, List<Lotto> lottos, CountBoard board) {
        lottoCount = lottos.size();
        countBoard = board;
        for (Lotto lotto : lottos) {
            countBoard.plusCount(lastWinningLotto.howManyRight(lotto));
        }
    }

    public int numberMatches(int number) {
        return countBoard.oneRankResult(number);
    }

    public double calculateYield() {
        double yield = calculateReward() / (double) (lottoCount * 1_000);
        return yield;
    }

    public long calculateReward() {
        return countBoard.calculateTotalRankReward();
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
