package step3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoAnalyzer {

    int[] countBoard = new int[7];

    public LottoAnalyzer(LastWinningLotto lastWinningLotto, List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            Long rightCount = lastWinningLotto.howManyRight(lotto);
            System.out.println(rightCount);
            System.out.println(Arrays.toString(countBoard));
            countBoard[rightCount.intValue()] ++;
        }
    }

    public int numberMatches(int number) {
        return countBoard[number];
    }
}
