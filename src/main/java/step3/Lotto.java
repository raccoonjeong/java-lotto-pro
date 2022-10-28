package step3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Lotto {

    public static final int MAX = 45;

    private List<Integer> lottoNumbers;
    private List<Integer> numberBox = new ArrayList<>();

    public Lotto() {
        for (int i = 1; i <= MAX; i++) {
            numberBox.add(i);
        }
        Collections.shuffle(numberBox);
        lottoNumbers = numberBox.subList(0, 6);
        Collections.sort(lottoNumbers);
    }

    public Lotto(List<Integer> numbers) {
        lottoNumbers = numbers;
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }
}
