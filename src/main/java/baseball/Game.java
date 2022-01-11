package baseball;

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
            // @TODO: Implement game process

            // @TODO: Set conditionally
            this.gameStatus = END;
        } while(this.gameStatus == ON_GOING);
    }
}
