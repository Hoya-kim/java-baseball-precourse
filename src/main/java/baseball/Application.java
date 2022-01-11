package baseball;

import java.util.InputMismatchException;
//import nextstep.utils.Console;
//import nextstep.utils.Randoms;
//
//import static utils.Constant.*;


public class Application {
    public static void main(String[] args) {
        Game baseballGame = new Game(new Computer(), new Player());
        baseballGame.run();
    }
}
