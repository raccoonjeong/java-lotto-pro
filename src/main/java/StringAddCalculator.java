
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    /**
     * 요구사항
     * 1. 빈 문자열 또는 null 값을 입력할 경우 0을 반환해야 한다.(예 : “” => 0, null => 0)
     * 2. 숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다.(예 : “1”)
     * 3. 숫자 두개를 컴마(,) 구분자로 입력할 경우 두 숫자의 합을 반환한다.(예 : “1,2”)
     * 4. 구분자를 컴마(,) 이외에 콜론(:)을 사용할 수 있다. (예 : “1,2:3” => 6)
     * 5. “//”와 “\n” 문자 사이에 커스텀 구분자를 지정할 수 있다. (예 : “//;\n1;2;3” => 6)
     * 6. 음수를 전달할 경우 RuntimeException 예외가 발생해야 한다. (예 : “-1,2,3”)
     * */
    public static int splitAndSum(String text) {
        if (isEmpty(text)) {
            return 0;
        }

        String[] tokens = splitByDelimiter(text);

        for (int i = 0; i < tokens.length; i++) {
            isPlusNumber(tokens[i]);
        }

        return sumTokens(tokens);
    }

    private static int sumTokens(String[] tokens) {

        int result = 0;

        for (int i = 0; i < tokens.length; i++) {
            result += Integer.parseInt(tokens[i]);
        }

        return result;
    }

    private static void isPlusNumber(String token) {
        if (Integer.valueOf(token) < 0) {
            throw new IllegalArgumentException();
        }

    }

    private static String[] splitByDelimiter(String text) {
        String delimiter = ",|:";

        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);

        if (m.find()) {
            delimiter = m.group(1);
            text = m.group(2);
        }

        return text.split(delimiter);
    }

    private static boolean isEmpty(String text) {
        if (text == null) {
            return true;
        }

        if (text.isEmpty()) {
            return true;
        }

        return false;
    }
}
