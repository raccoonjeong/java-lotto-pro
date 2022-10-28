package step3;

public class LottoMachine {

    private final long LOTTO_SINGLE_PRICE = 1_000;
    private long payment;

    public LottoMachine(long payment) {
        this.payment = payment;
    }

    public long lottoCount() {
        return payment / LOTTO_SINGLE_PRICE;
    }

}
