package autodrivedash.game.gameMenu;

import autodrivedash.App;
import javafx.fxml.FXML;

public class GamePaused extends GameMenuController {
    @FXML
    private void resumeGame() {
        App.getGameMenu().resumeGame();
    }
}
