package autodrivedash.game.gameMenu;

import autodrivedash.App;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public abstract class GameMenuController {
    @FXML
    private Button mainMenuBtn;

    public Button getMainMenuBtn() {
        return mainMenuBtn;
    }

    @FXML
    protected void restartGame() {
        App.getGameMenu().restartGame();
    }

    @FXML
    private void goToMainMenu() {
        App.getGameMenu().backToMainMenu();
    }
}
