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
    private LoginModel loginModel;
    public void setModel(LoginModel model) {
        this.loginModel = model;
    }

    @FXML private TextField emailTf, passwordTf;
    @FXML private Button loginBtn, createAccBtn, errorOkBtn;
    @FXML private Pane popUpCtn;

    @FXML private void goToSignup(ActionEvent e) throws IOException {
        App.getMainMenu().display(App.getMainMenu().getSignupPage());
    }
    @FXML private void handleLogin(ActionEvent e) {
        try {
            loginModel.findByEmailAndPassword(null, null);
        } catch (Exception e1){
            popUpCtn.setMouseTransparent(false);
            FadeTransition ft = new FadeTransition(Duration.millis(50), popUpCtn);
            ft.setFromValue(0.0);
            ft.setToValue(1.0);
            ft.play();
        }
    }
    @FXML private void hidePopUp(ActionEvent e) {
        popUpCtn.setMouseTransparent(true);;
        popUpCtn.setOpacity(0);
    }

    // public LoginController(LoginPage loginPage){
    //     super(loginPage);
    //     getLoginPage().getLoginBtn().addMouseListener(handleLoginBtnActions());
    //     getLoginPage().getGoToSignUpBtn().addActionListener(showSignup());
    // }

    // public MouseListener handleLoginBtnActions(){
    //     LoginPage lp = this.getLoginPage();
    //     Color origColor = lp.getLoginBtn().getBackground();

    //     return new MouseListener() {
    //         @Override
    //         public void mouseEntered(MouseEvent e) {
    //             lp.getLoginBtn().setBackground(Color.GRAY);
    //         }
    //         @Override
    //         public void mouseExited(MouseEvent e) {
    //             lp.getLoginBtn().setBackground(origColor);
    //         }
    //         @Override
    //         public void mouseClicked(MouseEvent e) {
    //             String email = lp.getEmailField().getText();
    //             String password = String.valueOf(lp.getPasswordField().getPassword());

    //             try {
    //                 ResultSet result = AutoDriveDash.db.users.findByEmailAndPassword(email, password);
    //                 if(result.next()){ // go to menu
    //                     System.out.println(
    //                         result.getInt("id") + " | " +
    //                         result.getString("email") + " | " +
    //                         result.getString("password")
    //                     );
    //                 } else { // show error pop
    //                     System.out.println("No results");
    //                 }
    //                 result.close();
    //             } catch (SQLException e1) {
    //                 e1.printStackTrace();
    //             }
    //         }

    //         @Override
    //         public void mousePressed(MouseEvent e) {}
    //         @Override
    //         public void mouseReleased(MouseEvent e) {}
    //     };
    // }
    // public ActionListener showSignup(){
    //     return new ActionListener() {
    //         @Override
    //         public void actionPerformed(ActionEvent e) {
    //             AutoDriveDash.window.display(AutoDriveDash.window.SIGNUP_KEY);
    //         }
    //     };
    // }
}
