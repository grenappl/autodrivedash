package autodrivedash.menu.login;

import java.sql.ResultSet;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import autodrivedash.App;
import autodrivedash.menu.MenuPageController;
import autodrivedash.menu.signup.SignupController;

public class LoginController extends MenuPageController {
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

    public Button getLoginBtn() {
        return this.loginBtn;
    }

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
            Login.checkEmptyFields(email, password);
            ResultSet result = Login.find(email, password);
            if (result.next()) {
                emailTf.setText(null);
                passwordTf.setText(null);
                Login.start(result);
            } else {
                throw new Exception("Invalid email or password!");
            }
        } catch (Exception e1) {
            displayError(e1.getMessage(), popUpCtn, loginCtn, errorText);
        }
    }

    @FXML
    public void hidePopUp() {
        setMouseFocuses(loginCtn, popUpCtn);
        popUpCtn.setOpacity(0);
    }
}
