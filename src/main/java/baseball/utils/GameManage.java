package baseball.utils;

import java.io.IOException;
import java.util.List;

public class GameManage {
    private static GameManage gameManager = new GameManage();

    private Player player = Player.getInstance();
    private Computer com = Computer.getInstnace();

    private GameManage() {}


    public static GameManage getInstance() {
        return gameManager;
    }

    // 스트라이크, 볼, 낫싱 판단하는 함수
    private int[] checkBall(List<Integer> userInputNumber, List<Integer> answerNumber) {
        // 스트라이크, 볼, 낫싱 cnt
        int[] StrikeAndBallCnt = new int[2];

        // 스트라이크, 볼, 낫싱 Check
        A:for (int i = 0; i < 3; i++) {
            if (userInputNumber.get(i) == answerNumber.get(i)) {
                StrikeAndBallCnt[0]++; // 스트라이크
                continue;
            }

            for (int j = 0; j < 3; j++) {
                if (userInputNumber.get(i) == answerNumber.get(j)) {
                    StrikeAndBallCnt[1]++; // 볼
                    continue A;
                }
            }
        }
        return StrikeAndBallCnt;
    }

    private int getGameResult(List<Integer> userInputNumber, List<Integer> answerNumber){
        int[] StrikeAndBallCnt = checkBall(userInputNumber,answerNumber);

        if (StrikeAndBallCnt[1] != 0) System.out.print(StrikeAndBallCnt[1] + "볼 ");
        if (StrikeAndBallCnt[0] != 0) System.out.print(StrikeAndBallCnt[0] + "스트라이크");

        if (StrikeAndBallCnt[0] + StrikeAndBallCnt[1] == 0) System.out.print("낫싱");
        System.out.println();

        return StrikeAndBallCnt[0];
    }

    // 게임 실행 관리 함수
    public void gameStart() throws IOException {
        List<Integer> answer = com.generateNumberList();
        List<Integer> userNumber;

        System.out.println("숫자 야구 게임을 시작합니다.");

        while (true) {
            userNumber = player.userInput();

            int strikeCnt = getGameResult(userNumber, answer);

            if (strikeCnt == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
        }

        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        if (player.reGame()) gameStart();
    }

}
