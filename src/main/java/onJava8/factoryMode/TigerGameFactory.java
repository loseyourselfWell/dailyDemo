package onJava8.factoryMode;

public class TigerGameFactory implements GameFactory {
    @Override
    public Game getGame() {
        return new TigerGame();
    }
}
