package step3;

public class LottoApplication {
    public static void main(String[] args) {
        LottoMachine lottoMachine = new LottoMachine();
        lottoMachine.issueLotto();
        System.out.println("");
        LastWinningLotto lastWinningLotto = new LastWinningLotto();
        System.out.println("");
    }
}
