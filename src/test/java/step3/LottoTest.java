package step3;

import java.util.Arrays;
import static org.assertj.core.api.Assertions.*;
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
    public void howManyLottoByPrice() {
        final long payment = 14_000;

        LottoMachine lottoMachine = new LottoMachine(payment);

        final long expect = 14;
        final long actual = lottoMachine.lottoCount();

        assertThat(actual).isEqualTo(expect);
    }

}
