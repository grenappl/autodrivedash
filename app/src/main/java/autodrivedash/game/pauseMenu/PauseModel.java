package autodrivedash.game.pauseMenu;

import com.almasb.fxgl.dsl.FXGL;

import autodrivedash.App;

public class PauseModel {
    public void goToStart() {
        FXGL.getGameController().resumeEngine();
        App.getGameMenu().exitToMainMenu();
    }
}
