package autodrivedash.game.pauseMenu;

import autodrivedash.App;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class PauseMenuController {
    PauseMenu pauseModel = new PauseMenu();

    @FXML
    private Button mainMenuBtn;

    @FXML
    protected void goToMainMenu() {
        pauseModel.goToStart();
    }
}
