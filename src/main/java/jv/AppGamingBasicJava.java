package jv;

import jv.game.GameRunner;
import jv.game.MarioGame;

public class AppGamingBasicJava {
    public static void main(String[] args) {

        var marioGame = new MarioGame();
        var gameRunner = new GameRunner(marioGame);
        System.out.println("Java Test");
        gameRunner.run();

    }
}
