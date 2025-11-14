package autodrivedash.game.pauseMenu;

import com.almasb.fxgl.dsl.FXGL;

import autodrivedash.App;
import autodrivedash.menu.start.StartController;

public class PauseMenu {
    public void goToStart() {
        StartController startCtrl = App.getMainMenu().getStartController();
        startCtrl.getHighestScoreLabel().setText(String.valueOf((int) FXGL.getd("SCORE")));
        FXGL.getGameController().resumeEngine();
        App.getGameMenu().exitToMainMenu();
    }
}
