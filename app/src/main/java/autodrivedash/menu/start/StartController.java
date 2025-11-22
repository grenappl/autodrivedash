package autodrivedash.menu.start;

import com.almasb.fxgl.app.scene.MenuType;
import com.almasb.fxgl.dsl.FXGL;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

import autodrivedash.App;
import autodrivedash.menu.MenuPageController;
import autodrivedash.menu.login.LoginController;

public class StartController extends MenuPageController {
    @FXML
    private Label usernameLabel, emailLabel, highestScoreLabel;
    @FXML
    private Button playBtn, exitBtn;
    @FXML
    private ImageView accountIcon;

    public Label getHighestScoreLabel() {
        return this.highestScoreLabel;
    }

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
}
