package onJava8.factoryMode;

import onJava8.factoryMode.Game;

public class TigerGame implements Game {
    @Override
    public void move() {
        System.out.println("tiger game");
    }
}
