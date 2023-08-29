package baseball.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import camp.nextstep.edu.missionutils.Console;

public class Player {
    private static Player player = new Player();
    private Player(){ }
    public static Player getInstance(){
        return player;
    }
    public List<Integer> userInput() throws IOException {
            System.out.print("숫자를 입력해주세요 : ");
            List<Integer> uesrInputNumber = new ArrayList<>();

            char[] input = Console.readLine().toCharArray();

            for(char ch:input){
                uesrInputNumber.add(ch-'0');
            }

            // 타당한지 체크하고, 타당하지 않으면 예외 발생
            if(!isValid(uesrInputNumber)) throw new IllegalArgumentException("잘못된 입력입니다. 1~9까지 서로 다른 3자리 숫자를 입력해주세요.");

            // 타당하다면 userInputNumber 반환
            return uesrInputNumber;
        }

        protected boolean isValid(List<Integer> uesrInputNumber){
            // 3글자가 아니면 false 반환
            if(uesrInputNumber.size()!=3) return false;
            // 1~9까지 숫자가 아니면 false 반환
            for(int num: uesrInputNumber){
                if(num<1 || num>9) return false;
            }
            // 중복된 값이 있다면 false 반환 -> set한 사이즈와 현재 리스트 사이즈 비교해서 중복 체크
            Set<Integer> userInputNumberSet = new HashSet<>(uesrInputNumber);

            if(userInputNumberSet.size() != uesrInputNumber.size()) return false;

            // 모든 조건에 맞다면 true 반환
            return true;
        }
        

        public boolean reGame() throws IOException {

            int reStart = Integer.parseInt(Console.readLine());

            if(reStart==1) return true;
            else if(reStart==2) return false;
            else throw new IllegalArgumentException("잘못된 입력 형식입니다. 1과 2 중 입력해주세요.");

        }

}
