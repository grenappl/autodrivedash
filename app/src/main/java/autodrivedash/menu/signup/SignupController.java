package autodrivedash.menu.signup;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import autodrivedash.App;
import autodrivedash.menu.login.LoginController;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class SignupController {
    @FXML
    private TextField usernameTf, emailTf;
    @FXML
    private PasswordField passwordTf, confPasswordTf;
    @FXML
    private Button signupBtn;
    @FXML
    private Pane popUpCtn, signupCtn;
    @FXML
    private Text errorText;

    @FXML
    private void goToStart() {
        App.getMainMenu().displayStartPage();
    }

    @FXML
    private void goToLogin(ActionEvent e) {
        LoginController loginCtrl = App.getMainMenu().getLoginController();
        loginCtrl.hidePopUp();
        App.getMainMenu().displayLoginPage();
        loginCtrl.getLoginBtn().requestFocus();
    }

    @FXML
    private void handleSignup(ActionEvent e) {
        String username = usernameTf.getText();
        String email = emailTf.getText();
        String password = passwordTf.getText();
        String confPassword = confPasswordTf.getText();

        if (checkEmptyFields(username, email, password, confPassword)) {
            displayError("One or more inputs are empty!");
            return;
        }

        if (Signup.confirmPasswords(password, confPassword)) {
            try {
                ResultSet result = Signup.find(email);
                if (result.next()) {
                    displayError("Duplicate user found!");
                } else {
                    Signup.register(username, email, password);
                    Signup.goLogin();
                }
            } catch (SQLException e1) {
                displayError(e1.getMessage());
            }
        } else {
            displayError("Passwords don't match!");
        }
    }

    private boolean checkEmptyFields(String... details) {
        for (String detail : details) {
            if (detail.isEmpty())
                return true;
        }
        return false;
    }

    @FXML
    public void hidePopUp() {
        App.getMainMenu().setMouseFocuses(signupCtn, popUpCtn);
        popUpCtn.setOpacity(0);
    }

    public Button getSignupBtn() {
        return this.signupBtn;
    }

    private void displayError(String error) {
        App.getMainMenu().setMouseFocuses(popUpCtn, signupCtn);
        errorText.setText("Error: " + error);
        FadeTransition ft = new FadeTransition(Duration.millis(50), popUpCtn);
        ft.setFromValue(0.0);
        ft.setToValue(1.0);
        ft.play();
    }
}
