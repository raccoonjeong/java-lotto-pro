package step3;

import java.util.List;

public class Lotto {

    List<Integer> lottoNumbers;

    public Lotto() {
    }

    public Lotto(List<Integer> numbers) {
        lottoNumbers = numbers;
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }
}
