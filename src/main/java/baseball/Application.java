package baseball;

public class Application {
    public static void main(String[] args) {
        Game baseballGame = new Game(new Computer(), new Player());
        baseballGame.run();
    }
}
