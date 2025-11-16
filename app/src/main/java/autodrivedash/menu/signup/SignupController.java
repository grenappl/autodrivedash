package autodrivedash.menu.signup;

import autodrivedash.App;
import autodrivedash.menu.login.LoginController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

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

    public Button getSignupBtn() {
        return this.signupBtn;
    }

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

        try {
            Signup.checkEmptyFields(username, email, password, confPassword);

            if (Signup.confirmPasswords(password, confPassword)) {
                if (Signup.isFound(email)) {
                    displayError("Duplicate user found!");
                } else {
                    if (Signup.register(username, email, password) == 1) {
                        Signup.goLogin();
                    } else {
                        displayError("Something went wrong!");
                    }
                }
            } else {
                throw new Exception("Passwords don't match!");
            }
        } catch (Exception e1) {
            displayError(e1.getMessage());
        }
    }

    @FXML
    public void hidePopUp() {
        App.getMainMenu().utils.setMouseFocuses(signupCtn, popUpCtn);
        popUpCtn.setOpacity(0);
    }

    private void displayError(String error) {
        App.getMainMenu().utils.displayError(popUpCtn, signupCtn, errorText, error);
    }
}
