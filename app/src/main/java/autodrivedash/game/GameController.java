package autodrivedash.game;

import com.almasb.fxgl.dsl.FXGL;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

public class GameController {
    private GameModel gameModel = new GameModel();

    @FXML
    private Text scoreCount, livesCount;
    @FXML
    private Button pauseBtn;

    @FXML
    protected void pauseGame() {
        FXGL.getGameController().gotoGameMenu();
    }

    public void startGame() {
        pauseBtn.setFocusTraversable(false);

        gameModel.spawnEntities();
        gameModel.addCollisions(livesCount);
    }

    public void update() {
        gameModel.setScore(scoreCount);
    }
}
