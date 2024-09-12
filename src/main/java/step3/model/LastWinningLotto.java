package step3.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LastWinningLotto {

    private final List<Integer> winningLottoNumbers;

    public LastWinningLotto(String numbers) {
        winningLottoNumbers = makeListByString(numbers);
    }

    private List<Integer> makeListByString(String numbers) {
        return Arrays.stream(numbers.split(", "))
                     .mapToInt(Integer::parseInt)
                     .boxed()
                     .collect(Collectors.toList());
    }

    public LastWinningLotto(List<Integer> numbers) {
        winningLottoNumbers = numbers;
    }

    public int howManyRight(Lotto myLotto) {
        List<Integer> myLottoNumbers = myLotto.getLottoNumbers();
        Long rightCount = myLottoNumbers.stream()
                                        .filter(winningLottoNumbers::contains)
                                        .count();
        return rightCount.intValue();
    }
}
