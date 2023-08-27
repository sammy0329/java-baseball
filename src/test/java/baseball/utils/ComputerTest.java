package baseball.utils;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class ComputerTest {

    @Test
    void Repeats1000TimesCreateRandomNumber() {
        boolean result = true;
        Computer com = Computer.getInstnace();
        for(int i = 0; i< 1000; i++) {
            List<Integer> randomNumber = com.generateNumberList();
            if(!confirmDuplicationNumber(randomNumber)) {
                result = false;
            }
        }
        assertThat(result).isEqualTo(true);
    }

    boolean confirmDuplicationNumber(List<Integer> number) {
        return (number.get(0) != number.get(1)) && (number.get(1) != number.get(2)) && (number.get(0) != number.get(2));
    }

}