package autodrivedash.menu.start;

import com.almasb.fxgl.dsl.FXGL;

import autodrivedash.App;

public class Start {
    public static void showGame() {
        App.getMainMenu().startGame();
    }

    public static void exitGame() {
        FXGL.getGameController().exit();
    }
}
