package controllers;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import app.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import models.LoginModel;

public class LoginController {
    private LoginModel loginModel;
    public void setModel(LoginModel model) {
        this.loginModel = model;
    }

    @FXML private TextField tf;
    @FXML private Button createOneBtn;

    @FXML private void goToSignup(ActionEvent e) throws IOException {
        App.window.display(new Scene(App.window.getSignupPage()));
    }
    @FXML private void handleLogin(ActionEvent e) {
        try {
            loginModel.findByEmailAndPassword(null, null);
        } catch (SQLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
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
