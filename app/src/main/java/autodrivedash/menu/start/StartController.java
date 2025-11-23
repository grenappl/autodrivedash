package autodrivedash.menu.start;

import com.almasb.fxgl.app.scene.MenuType;
import com.almasb.fxgl.dsl.FXGL;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
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

    public Label getUsernameLabel() {
        return usernameLabel;
    }

    public Label getEmailLabel() {
        return emailLabel;
    }

    public Label getHighestScoreLabel() {
        return this.highestScoreLabel;
    }

    @FXML
    protected void showGame(ActionEvent e) {
        Start.showGame();
    }

    @FXML
    protected void checkAccount() {
        if (App.getDb().getConn() != null) {
            LoginController loginCtrl = App.getMainMenu().getLoginController();
            loginCtrl.hidePopUp();
            App.getMainMenu().displayLoginPage();
            loginCtrl.getLoginBtn().requestFocus();
        } else {
            String error = "Unable to log in/sign up! Please try again later.";
            System.out.println("gsrgw");
        }
    }

    @FXML
    protected void exitGame() {
        Start.exitGame();
    }

    @Override
    public void hidePopUp() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'hidePopUp'");
    }
}
