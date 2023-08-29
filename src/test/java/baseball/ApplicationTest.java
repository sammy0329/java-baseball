package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    @Test
    void 게임종료_후_재시작() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("246", "135", "1", "597", "589", "2");
                    assertThat(output()).contains("낫싱", "3스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료");
                },
                1, 3, 5, 5, 8, 9
        );
    }

    @Test
    void 네글자입력_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 중복숫자입력_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("122"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void _1_9_이외의_숫자_입력시_예외_테스트_문자() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("12w"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void _1_9_이외의_숫자_입력시_예외_테스트_숫자0포함() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("120"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 낫싱체크() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("246", "135","2");
                    assertThat(output()).contains("낫싱", "3스트라이크", "게임 종료");
                },
                1, 3, 5
        );
    }

    @Test
    void 쓰리볼_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("351", "513","135","2");
                    assertThat(output()).contains("3볼", "3볼", "3스트라이크", "게임 종료");
                },
                1, 3, 5
        );
    }

    @Test
    void 투볼_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("358", "519","135","2");
                    assertThat(output()).contains("2볼", "2볼", "3스트라이크", "게임 종료");
                },
                1, 3, 5
        );
    }

    @Test
    void 투볼_원스트라이크_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("315", "153","135","2");
                    assertThat(output()).contains("2볼 1스트라이크", "2볼 1스트라이크", "3스트라이크", "게임 종료");
                },
                1, 3, 5
        );
    }

    @Test
    void 쓰리스트라이크_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("135","2");
                    assertThat(output()).contains("3스트라이크", "게임 종료");
                },
                1, 3, 5
        );
    }

    @Override
    public void runMain() {
        try {
            Application.main(new String[]{});
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
