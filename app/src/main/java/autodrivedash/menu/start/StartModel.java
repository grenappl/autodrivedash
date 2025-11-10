package autodrivedash.menu.start;

import com.almasb.fxgl.dsl.FXGL;

import autodrivedash.App;

public class StartModel {
    public void startGame() {
        App.getMainMenu().startGame();
    }

    public void showLogin() {
        App.getMainMenu().displayLoginPage();
    }

    public void exitGame() {
        FXGL.getGameController().exit();
    }
}
