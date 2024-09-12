package step3.model;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {

    private final long LOTTO_SINGLE_PRICE = 1_000;
    private final long payment;
    private final List<Lotto> lottos = new ArrayList<>();

    public LottoMachine(long payment) {
        this.payment = payment;
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
