package baseball;

import java.util.InputMismatchException;
import nextstep.utils.Console;

import static utils.Constant.*;

class Player {
    private int[] pitchings = new int[PITCHING_LENGTH];

    public void setPitchings(int[] pitchings){
        this.pitchings = pitchings;
    }

    public int[] getPitchings() {
        return pitchings;
    }

    public void pitchBalls() {
        boolean isValid = true;
        do {
            isValid = inputBalls();
        } while(!isValid);
    }

    // 3자리 수 입력
    private boolean inputBalls() {
        System.out.print("숫자를 입력해 주세요 : ");
        String input = Console.readLine();
        try{
            boolean checkLength = checkStringLength(PITCHING_LENGTH, input);
            if(!checkLength) throw new InputMismatchException();
            setPitchings(stringToArray(input));
            return true;
        } catch(NumberFormatException e) {
            System.out.println("[ERROR] 1-9로 구성된 숫자를 입력해 주세요.");
        } catch(InputMismatchException ime) {
            System.out.println("[ERROR] 한번에 "+ PITCHING_LENGTH +"개의 숫자만 입력할 수 있습니다.");
        }
        return false;
    }

    // 입력의 길이 확인
    private boolean checkStringLength(int maxSize, String numString) {
        if(numString.length() <= maxSize) return true;
        else return false;
    }

    private int[] stringToArray(String str) {
        String[] strArr = str.split("");
        int[] intArr = new int[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            intArr[i] = Integer.parseInt(strArr[i]);
        }
        return intArr;
    }
}
