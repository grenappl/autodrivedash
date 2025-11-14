package autodrivedash.menu.login;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.almasb.fxgl.animation.Animation;

import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.util.Duration;
import autodrivedash.App;
import autodrivedash.menu.signup.SignupController;

public class LoginController {
    @FXML
    private TextField emailTf;
    @FXML
    private PasswordField passwordTf;
    @FXML
    private Button loginBtn, createAccBtn, errorOkBtn;
    @FXML
    private Pane popUpCtn, loginCtn;
    @FXML
    private Text errorText;

    @FXML
    private void goToStart() {
        App.getMainMenu().displayStartPage();
    }

    @FXML
    private void goToSignup(ActionEvent e) {
        SignupController signupCtrl = App.getMainMenu().getSignupController();
        signupCtrl.hidePopUp();
        App.getMainMenu().displaySignupPage();
        signupCtrl.getSignupBtn().requestFocus();
    }

    @FXML
    private void handleLogin(ActionEvent e) {
        String email = emailTf.getText();
        String password = passwordTf.getText();
        try {
            ResultSet result = Login.find(email, password);
            if (result.next()) {
                Login.goStart(result);
            } else {
                displayError("Invalid email or password!");
            }
        } catch (Exception e1) {
            displayError(e1.getMessage());
        }
    }

    @FXML
    public void hidePopUp() {
        App.getMainMenu().setMouseFocuses(loginCtn, popUpCtn);
        popUpCtn.setOpacity(0);
    }

    public Button getLoginBtn() {
        return this.loginBtn;
    }

    private void displayError(String error) {
        App.getMainMenu().setMouseFocuses(popUpCtn, loginCtn);
        errorText.setText("Error: " + error);
        FadeTransition ft = new FadeTransition(Duration.millis(50), popUpCtn);
        ft.setFromValue(0.0);
        ft.setToValue(1.0);
        ft.play();
    }
}
