package onJava8.factoryMode;

public class PlayGame {

    public static void PlayGame(GameFactory factory) {
        Game game = factory.getGame();
        game.move();
    }


    public static void main(String[] args) {
        PlayGame(new CheckGameFactory());
        PlayGame(new TigerGameFactory());
    }
}
