package autodrivedash.game;

import com.almasb.fxgl.dsl.FXGL;

import autodrivedash.App;
import autodrivedash.game.entity.player.Player;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class GameController {
    @FXML
    private AnchorPane gameCtn;
    @FXML
    private Text scoreCount;
    @FXML
    private Rectangle boostBar;
    @FXML
    private ImageView hp1, hp2, hp3, hp4, hp5;
    @FXML
    private Label countdown;

    private ImageView[] health = new ImageView[5];

    public Rectangle getBoostBar() {
        return boostBar;
    }

    @FXML
    protected void pauseGame() {
        FXGL.getGameController().gotoGameMenu();
    }

    public void startGame() {
        initializeHp();
        App.getGameMenu().displayPause();
        Game.spawnEntities();
        Game.addCollisions(health);
        Game.startCountdown(countdown);
    }

    private void initializeHp() {
        ImageView[] tempHp = { hp1, hp2, hp3, hp4, hp5 };
        int lives = Player.getSelectedCharacter().getLives();
        for (int i = 0; i < 5; i++) {
            health[i] = tempHp[i];
            if (i + 1 > lives)
                gameCtn.getChildren().remove(health[i]);
        }
    }

    public void update() {
        Game.setScore(scoreCount);
        Game.checkMusicState();
    }
}
