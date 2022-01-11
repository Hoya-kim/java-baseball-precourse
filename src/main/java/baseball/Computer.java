package baseball;

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
}
