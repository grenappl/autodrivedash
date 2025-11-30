package autodrivedash.game.gameMenu;

import com.almasb.fxgl.dsl.FXGL;

import autodrivedash.App;
import javafx.fxml.FXML;
import javafx.scene.text.Text;

public class GameOver extends GameMenuController {
    @FXML
    private Text newScoreText;

    public Text getNewScoreText() {
        return newScoreText;
    }

    public boolean setNewHighScore() {
        App.getGameSound().getCurrentGameMusic().stop();
        int highScore = Integer.valueOf(App.getMainMenu().getStartController().getHighestScoreLabel().getText());
        if (highScore > FXGL.getd("SCORE")) {
            getNewScoreText().setOpacity(0);
            return false;
        } else {
            getNewScoreText().setOpacity(1);
            return true;
        }
    }
}
