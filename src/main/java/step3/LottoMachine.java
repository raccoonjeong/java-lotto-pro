package step3;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {

    private final long LOTTO_SINGLE_PRICE = 1_000;
    private long payment;
    private List<Lotto> lottos = new ArrayList<>();

    public LottoMachine(long payment) {
        this.payment = payment;

        System.out.println(lottoCount() + "개를 구매했습니다.");
        issueLotto();
    }

    public long lottoCount() {
        return payment / LOTTO_SINGLE_PRICE;
    }

    public void issueLotto() {
        long count = lottoCount();

        for (int i = 0; i < count; i++) {
            lottos.add(new Lotto());
        }
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
