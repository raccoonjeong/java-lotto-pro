package step3;

import java.util.List;

public class LastWinningLotto {

    private List winningLottoNumbers;

    public LastWinningLotto(List numbers) {
        winningLottoNumbers = numbers;
    }

    public long howManyRight(Lotto myLotto) {
        List<Integer> myLottoNumbers = myLotto.getLottoNumbers();

        return myLottoNumbers.stream()
                             .filter(myNumber -> winningLottoNumbers.contains(myNumber))
                             .count();
    }
}
