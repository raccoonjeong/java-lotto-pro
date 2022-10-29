package step3;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LastWinningLotto {

    private List<Integer> winningLottoNumbers;

    public LastWinningLotto(String numbers) {
        winningLottoNumbers = makeListByString(numbers);
    }

    private List<Integer> makeListByString(String numbers) {
        return Arrays.asList(numbers.split(", "))
            .stream()
            .mapToInt(Integer::parseInt)
            .boxed()
            .collect(Collectors.toList());
    }

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
