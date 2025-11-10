package autodrivedash.menu.login;

import static com.almasb.fxgl.dsl.FXGL.animationBuilder;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.almasb.fxgl.animation.Animation;

import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import autodrivedash.App;

public class LoginController {
    private LoginModel loginModel = new LoginModel();

    @FXML
    private TextField emailTf, passwordTf;
    @FXML
    private Button loginBtn, createAccBtn, errorOkBtn;
    @FXML
    private Pane popUpCtn;

    @FXML
    private void goToSignup(ActionEvent e) throws IOException {
        App.getMainMenu().displaySignupPage();
    }

    @FXML
    private void handleLogin(ActionEvent e) {
        String email = emailTf.getText();
        String password = passwordTf.getText();
        try {
            loginModel.findByEmailAndPassword(email, password);
        } catch (Exception e1) {
            popUpCtn.setMouseTransparent(false);
            FadeTransition ft = new FadeTransition(Duration.millis(50), popUpCtn);
            ft.setFromValue(0.0);
            ft.setToValue(1.0);
            ft.play();
        }
    }

    @FXML
    private void hidePopUp(ActionEvent e) {
        popUpCtn.setMouseTransparent(true);
        popUpCtn.setOpacity(0);
    }
}
