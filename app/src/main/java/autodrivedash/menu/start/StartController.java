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
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;

import autodrivedash.App;
import autodrivedash.game.GameController;
import autodrivedash.menu.login.LoginController;

import static com.almasb.fxgl.dsl.FXGL.*;

public class StartController {
    @FXML
    private Button playBtn, exitBtn;
    @FXML
    private ImageView accountIcon;
    @FXML
    private Label highestScoreLabel;

    @FXML
    protected void showGame(ActionEvent e) {
        App.getMainMenu().startGame();
    }

    @FXML
    protected void checkAccount() {
        LoginController loginCtrl = App.getMainMenu().getLoginController();
        loginCtrl.hidePopUp();
        App.getMainMenu().displayLoginPage();
        loginCtrl.getLoginBtn().requestFocus();
    }

    @FXML
    protected void exitGame() {
        FXGL.getGameController().exit();
    }

    public Label getHighestScoreLabel() {
        return this.highestScoreLabel;
    }
}
