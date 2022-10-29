package step3.controller;

import java.util.List;
import step3.model.LastWinningLotto;
import step3.model.Lotto;
import step3.model.LottoAnalyzer;
import step3.model.LottoMachine;
import step3.view.InputView;
import step3.view.OutputView;

public class LottoController {
    List<Lotto> myLottos;
    LastWinningLotto winLotto;

    public void start() {
        payment();
        whatIsLastWinningNumbers();
        analyzeLotto();
    }

    public void payment() {
        OutputView.printInputPayment();
        long payment = InputView.inputPayment();

        LottoMachine lottoMachine = new LottoMachine(payment);
        OutputView.printPayCount(lottoMachine.lottoCount());

        List<Lotto> lottos = lottoMachine.getLottos();
        lottos.forEach(lotto -> OutputView.printLottoNumbers(lotto.getLottoNumbers()));
        myLottos = lottos;
    }

    public void whatIsLastWinningNumbers() {
        OutputView.printLastWinningNumbers();
        winLotto = new LastWinningLotto(InputView.inputLastWinningNumbers());
    }

    public void analyzeLotto() {
        LottoAnalyzer lottoAnalyzer = new LottoAnalyzer(winLotto, myLottos);
        double yield = lottoAnalyzer.calculateYield();
        String furtherExplain = lottoAnalyzer.furtherExplain(yield);
        OutputView.printResult(yield, furtherExplain);
    }
}
