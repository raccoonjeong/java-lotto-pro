package step3;

import java.util.Scanner;

public class LottoApplication {
    private final static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("구입금액을 입력해 주세요.");
        long payment = Long.parseLong(sc.nextLine());
        LottoMachine lottoMachine = new LottoMachine(payment);

        System.out.println("\n지난 주 당첨 번호를 입력해 주세요.");
        String lastWinningNumbers = sc.nextLine();
        LastWinningLotto lastWinningLotto = new LastWinningLotto(lastWinningNumbers);
        LottoAnalyzer lottoAnalyzer = new LottoAnalyzer(lastWinningLotto, lottoMachine.getLottos());
        lottoAnalyzer.calculateYield(payment);
    }
}
