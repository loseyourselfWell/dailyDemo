package onJava8.factoryMode;

public class CheckGameFactory implements GameFactory {
    @Override
    public Game getGame() {
        return new CheckGame();
    }
}
