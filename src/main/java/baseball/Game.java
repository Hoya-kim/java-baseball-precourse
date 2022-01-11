package baseball;

import java.util.InputMismatchException;
import nextstep.utils.Console;

import static utils.Constant.*;

public class Game {
    private Computer computer;
    private Player player;

    private int gameStatus;

    public Game(Computer computer, Player player) {
        this.computer = computer;
        this.player = player;
    }

    // Start game process
    public void run() {
        do {
            startGame();
            // Request command & Get game status
            this.gameStatus = requestRestart();
        } while(this.gameStatus == ON_GOING);
    }

    private void startGame() {
        // Set computer's answer
        computer.createAnswer();

        int corrected = -1;
        // Finished, if correct answer
        do {
            player.pitchBalls();
            int[] pitchings = player.getPitchings();

            // scoring
            corrected = computer.scorePitchings(pitchings);
            if (corrected == FULFILLED) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 끝");
            }
        } while(corrected != FULFILLED);
    }

    private int requestRestart() {
        System.out.println("게임을 새로 시작하려면 " + RESTART_GAME + ", 종료하려면 " + STOP_GAME + "를 입력하세요.");
        while(true) {
            try {
                String command = Console.readLine();
                if(command.equals(RESTART_GAME)) return ON_GOING;
                if (command.equals(STOP_GAME)) return END;
                throw new InputMismatchException();
            } catch (InputMismatchException e) {
                System.out.println("[ERROR] 잘못된 입력입니다.");
            }
        }
    }
}
