package step3.view;

import java.util.Scanner;

public class InputView {

    private final static Scanner sc = new Scanner(System.in);

    public static Long inputPayment() {
        return Long.parseLong(sc.nextLine());
    }

    public static String inputLastWinningNumbers() {
        return sc.nextLine();
    }
}
