package step3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {

    public static final int MAX = 45;

    private final List<Integer> lottoNumbers;

    public Lotto() {
        List<Integer> numberBox = new ArrayList<>();
        for (int i = 1; i <= MAX; i++) {
            numberBox.add(i);
        }
        Collections.shuffle(numberBox);
        lottoNumbers = numberBox.subList(0, 6);
        Collections.sort(lottoNumbers);
        System.out.println(lottoNumbers);
    }

    public Lotto(List<Integer> numbers) {
        lottoNumbers = numbers;
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }
}
