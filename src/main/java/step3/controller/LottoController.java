package step3.controller;

import java.util.List;
import step3.model.CountBoard;
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
        LottoMachine lottoMachine = new LottoMachine(InputView.inputPayment());
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
        CountBoard board = new CountBoard();
        LottoAnalyzer lottoAnalyzer = new LottoAnalyzer(winLotto, myLottos, board);

        OutputView.printWinsStatistics();

        double yield = lottoAnalyzer.calculateYield();
        OutputView.printRankResult(board.showRankResult());

        String furtherExplain = lottoAnalyzer.furtherExplain(yield);
        OutputView.printYieldResult(yield, furtherExplain);
    }
}
