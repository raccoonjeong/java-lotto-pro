public class StringManager {

    public String[] splitByComma(String string) {

        return string.split(",");
    }

    public String[] splitByCommaWithoutBracket(String string) {

        int openBracketIndex = string.indexOf("(");
        int closeBracketIndex = string.indexOf(")");

        string = string.substring(openBracketIndex + 1, closeBracketIndex);

        return string.split(",");
    }

    public char findTargetIndexCharacter(String string, int targetIndex) {

        char result;
        try {
            result = string.charAt(targetIndex);
        } catch(IndexOutOfBoundsException e) {
            throw new IndexOutOfBoundsException("Index: " + targetIndex + ", Size: " + string.length());
        }

        return result;

    }

}
