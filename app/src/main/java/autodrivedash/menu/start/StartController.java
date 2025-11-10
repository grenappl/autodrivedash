package autodrivedash.menu.start;

import java.io.IOException;

import com.almasb.fxgl.dsl.FXGL;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;

import autodrivedash.App;
import autodrivedash.game.GameController;

import static com.almasb.fxgl.dsl.FXGL.*;

public class StartController {
    private StartModel startModel = new StartModel();

    @FXML
    private Button playBtn, exitBtn;
    @FXML
    private ImageView accountIcon;

    @FXML
    protected void showGame(ActionEvent e) {
        startModel.startGame();
    }

    @FXML
    protected void checkAccount() {
        startModel.showLogin();
    }

    @FXML
    protected void exitGame() {
        startModel.exitGame();
    }
}
