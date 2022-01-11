package baseball;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import nextstep.utils.Randoms;

import static utils.Constant.*;

class Computer {
    private Integer[] answer = new Integer[PITCHING_LENGTH];

    public void createAnswer() {
        Set<Integer> answerSet = new LinkedHashSet<>();
        do {
            answerSet.add(Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER));
        } while (answerSet.size() < PITCHING_LENGTH);
        this.answer = answerSet.toArray(new Integer[0]);
    }

    public int scorePitchings(int[] pitchings) {
        int ball = 0;
        int strike = 0;
        for (int i = 0; i < PITCHING_LENGTH; i++) {
            int idx = Arrays.asList(answer).indexOf(pitchings[i]);
            if (idx == -1) continue;
            if (idx == i) strike++;
            else ball++;
        }
        printMessage(strike, ball);
        return strike;
    }

    public void printMessage(int strike, int ball) {
        if (strike + ball == 0) {
            System.out.println("낫싱");
            return;
        }
        String message = "";
        if (strike > 0) message += (strike + "스트라이크 ");
        if (ball > 0) message += (ball + "볼");
        System.out.println(message);
    }
}
