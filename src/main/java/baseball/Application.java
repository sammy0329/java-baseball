package baseball;

import baseball.utils.GameManage;

import java.io.IOException;

public class Application {
    public static void main(String[] args) throws IOException {
        // TODO: 프로그램 구현
        GameManage gameManager = GameManage.getInstance();
        gameManager.gameStart();

    }
}
