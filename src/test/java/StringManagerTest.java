import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;


class StringManagerTest {

    StringManager stringManager;

    @BeforeEach
    void before() {
        stringManager = new StringManager();
    }

    @Test
    @DisplayName("잘 분리되는지 테스트")
    void splitTest() {
        String test = "1,2";
        assertThat(stringManager.splitByComma(test)).contains("1");
        assertThat(stringManager.splitByComma(test)).contains("2");
        assertThat(stringManager.splitByComma(test)).containsExactly("1","2");
    }

    @Test
    @DisplayName("단일 문자 분리 테스트")
    void singleSplitTest() {
        String test = "1,";
        assertThat(stringManager.splitByComma(test)).containsExactly("1");
    }

    @Test
    @DisplayName("괄호 제거 테스트")
    void splitRemoveBracketTest() {
        String test = "(1,2)";
        assertThat(stringManager.splitByCommaWithoutBracket(test)).containsExactly("1", "2");
    }

    @Test
    @DisplayName("특정 위치 문자 못가져올 때 테스트")
    void notFindTargetIndexCharacter() {
        assertThatThrownBy(() -> {
            stringManager.findTargetIndexCharacter("aa", 3);
        }).isInstanceOf(IndexOutOfBoundsException.class)
            .hasMessageContaining("Index: 3, Size: 2");

    }

    @Test
    @DisplayName("특정 위치 문자 잘가져올 때 테스트")
    void findTargetIndexCharacter() {
        assertThat(stringManager.findTargetIndexCharacter("abc", 2)).isEqualTo('c');
    }

}
