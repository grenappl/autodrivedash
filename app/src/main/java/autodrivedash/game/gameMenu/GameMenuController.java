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

    // restarts game and executes init methods within App
    @FXML
    protected void restartGame() {
        App.getGameMenu().restartGame();
    }

    // goes back to main menu and display start page
    @FXML
    private void goToMainMenu() {
        App.getGameMenu().backToMainMenu();
    }
}
