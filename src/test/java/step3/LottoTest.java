package step3;

import java.util.Arrays;
import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoTest {

    @Test
    @DisplayName("로또 1개에서 몇개 맞았나 테스트")
    public void howManyRightAtOneLotto() {
        final LastWinningLotto lastWinningLotto = new LastWinningLotto(Arrays.asList(1,2,3,4,5,6));
        final Lotto myLotto = new Lotto(Arrays.asList(1,2,3,7,8,9));

        final long expect = 3;
        final long actual = lastWinningLotto.howManyRight(myLotto);

        assertThat(actual).isEqualTo(expect);
    }

    @Test
    @DisplayName("구입금액으로 로또 몇개인지 계산 테스트")
    public void howManyLottoByPayment() {
        final long payment = 14_000;

        LottoMachine lottoMachine = new LottoMachine(payment);

        final long expect = 14;
        final long actual = lottoMachine.lottoCount();

        assertThat(actual).isEqualTo(expect);
    }

    @Test
    @DisplayName("구입금액으로 로또가 실제로 그 갯수만큼 반환되었는지 테스트")
    public void howManyLottoByPaymentAccurately() {
        final long payment = 14_000;

        LottoMachine lottoMachine = new LottoMachine(payment);

        final long expect = 14;
        lottoMachine.issueLotto();

        List<Lotto> myLottos = lottoMachine.getLottos();
        final long actual = myLottos.size();

        assertThat(actual).isEqualTo(expect);
    }

    @Test
    @DisplayName("랜덤 출력 확인 테스트")
    public void showRandom() {
        for (int i = 0; i < 6; i++) {
            Lotto lotto = new Lotto();
            System.out.println(lotto.getLottoNumbers());
        }
    }

    @Test
    @DisplayName("지난주 당첨번호 문자열 입력 테스트")
    public void winningLottoInputTest() {
        final LastWinningLotto lastWinningLotto = new LastWinningLotto("1, 2, 3, 4, 5, 6");
        final Lotto myLotto = new Lotto(Arrays.asList(1,2,3,7,8,9));

        final long expect = 3;
        final long actual = lastWinningLotto.howManyRight(myLotto);

        assertThat(actual).isEqualTo(expect);
    }

    @Test
    @DisplayName("3개 맞은게 몇개인가 테스트")
    public void analyzeCount() {
        final LastWinningLotto lastWinningLotto = new LastWinningLotto("1, 2, 3, 4, 5, 6");
        final List<Lotto> myLottos = Arrays.asList(
            new Lotto(Arrays.asList(1,2,3,7,8,9)),
            new Lotto(Arrays.asList(1,2,7,8,9,10)),
            new Lotto(Arrays.asList(4,5,6,7,8,9)));

        LottoAnalyzer lottoAnalyzer = new LottoAnalyzer(lastWinningLotto, myLottos);

        final int expect = 2;
        final int actual = lottoAnalyzer.numberMatches(3);

        assertThat(actual).isEqualTo(expect);
    }

    @Test
    @DisplayName("총 수령금 계산 테스트")
    public void calculateTotalReward() {
        final LastWinningLotto lastWinningLotto = new LastWinningLotto("1, 2, 3, 4, 5, 6");
        final List<Lotto> myLottos = Arrays.asList(
            new Lotto(Arrays.asList(1,2,3,7,8,9)),
            new Lotto(Arrays.asList(1,2,7,8,9,10)),
            new Lotto(Arrays.asList(4,5,6,7,8,9)));

        LottoAnalyzer lottoAnalyzer = new LottoAnalyzer(lastWinningLotto, myLottos);

        final long expect = 10_000;
        final long actual = lottoAnalyzer.calculateReward();

        assertThat(actual).isEqualTo(expect);
    }

    @Test
    @DisplayName("총 수익률 계산 테스트")
    public void calculateYield() {
        final LastWinningLotto lastWinningLotto = new LastWinningLotto("1, 2, 3, 4, 5, 6");
        final List<Lotto> myLottos = Arrays.asList(
            new Lotto(Arrays.asList(1,2,3,7,8,9)),
            new Lotto(Arrays.asList(1,2,7,8,9,10)),
            new Lotto(Arrays.asList(4,5,6,7,8,9)));

        LottoAnalyzer lottoAnalyzer = new LottoAnalyzer(lastWinningLotto, myLottos);

        final double expect = (double)10_000 / (double)3_000;
        final double actual = lottoAnalyzer.calculateYield(3_000);

        assertThat(actual).isEqualTo(expect);
    }
}
