package autodrivedash.game.gameMenu;

import autodrivedash.App;
import javafx.fxml.FXML;
import javafx.scene.text.Text;

public class GamePaused extends GameMenuController {
    @FXML
    private Text highScoreText;

    public void setHighScoreText() {
        highScoreText.setText("Highest Score:  " +
                App.getMainMenu().getStartController().getHighestScoreLabel().getText());
    }

    @FXML
    private void resumeGame() {
        App.getGameMenu().resumeGame();
    }
}
