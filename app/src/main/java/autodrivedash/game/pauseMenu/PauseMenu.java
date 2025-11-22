package autodrivedash.game.pauseMenu;

import com.almasb.fxgl.dsl.FXGL;

import autodrivedash.App;
import autodrivedash.menu.start.StartController;
import javafx.scene.control.Label;

public class PauseMenu {
    public void goToStart() {
        StartController startCtrl = App.getMainMenu().getStartController();
        Label highestScoreLabel = startCtrl.getHighestScoreLabel();
        if ((int) FXGL.getd("SCORE") > Integer.valueOf(highestScoreLabel.getText()))
            highestScoreLabel.setText(String.valueOf((int) FXGL.getd("SCORE")));
        FXGL.getGameController().resumeEngine();
        App.getGameMenu().exitToMainMenu();
    }
}
