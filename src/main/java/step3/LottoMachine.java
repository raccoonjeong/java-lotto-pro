package step3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LottoMachine {

    private final long LOTTO_SINGLE_PRICE = 1_000;
    private long payment;
    private List<Lotto> lottos;

    public LottoMachine() {
        System.out.println("구입금액을 입력해 주세요.");
        Scanner sc = new Scanner(System.in);
        this.payment = sc.nextLong();

        System.out.println(lottoCount() + "개를 구매했습니다.");
        issueLotto();
    }

    public LottoMachine(long payment) {
        this.payment = payment;

        System.out.println(lottoCount() + "개를 구매했습니다.");
        issueLotto();
    }

    public long lottoCount() {
        return payment / LOTTO_SINGLE_PRICE;
    }

    public void issueLotto() {
        List<Lotto> lottos = new ArrayList<>();
        long count = lottoCount();

        for (int i = 0; i < count; i++) {
            lottos.add(new Lotto());
        }

        this.lottos = lottos;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
