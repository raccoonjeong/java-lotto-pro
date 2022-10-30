package step3.view;

import java.util.List;

public class OutputView {

    public static void printInputPayment() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void printPayCount(long lottoCount) {
        System.out.printf("%d개를 구매했습니다.%n", lottoCount);
    }

    public static void printLottoNumbers(List lottoNumbers) {
        System.out.println(lottoNumbers);
    }

    public static void printLastWinningNumbers() {
        System.out.println("\n지난 주 당첨 번호를 입력해 주세요.");
    }

    public static void printWinsStatistics() {
        System.out.println("\n당첨 통계\n---------");
    }

    public static void printRankResult(String showRankResult) {
        System.out.println(showRankResult);
    }

    public static void printYieldResult(double yield, String furtherExplain) {
        System.out.printf("총 수익률은 %.2f입니다.%s", yield, furtherExplain);
    }

}
