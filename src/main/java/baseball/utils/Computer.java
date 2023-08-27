package baseball.utils;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {
    private static Computer com = new Computer();

    private Computer(){ }
    public static Computer getInstnace(){
        return com;
    }

    // 컴퓨터가 3자리 랜덤값 뽑는 함수
    public List<Integer> generateNumberList(){
        List<Integer> answer = new ArrayList<>();
        while (answer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!answer.contains(randomNumber)) {
                answer.add(randomNumber);
            }
        }
        return answer;
    }

}
