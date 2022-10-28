package step3;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {

    private final long LOTTO_SINGLE_PRICE = 1_000;
    private long payment;

    public LottoMachine(long payment) {
        this.payment = payment;
    }

    public long lottoCount() {
        return payment / LOTTO_SINGLE_PRICE;
    }

    public List<Lotto> issueLotto() {
        List<Lotto> lottos = new ArrayList<>();
        long count = lottoCount();

        for (int i = 0; i < count; i++) {
            lottos.add(new Lotto());
        }

        return lottos;
    }
}
