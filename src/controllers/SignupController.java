package controllers;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import app.App;
import bases.BaseController;
import views.SignupPage;

public class SignupController extends BaseController {
    public SignupPage getSignupPage(){ return (SignupPage)this.page; }

    public SignupController(SignupPage signupPage){
        super(signupPage);
        this.getSignupPage().getSignupBtn().addMouseListener(handleSignupBtnActions());
        this.getSignupPage().getGoToLoginBtn().addActionListener(showLogin());
    }

    public MouseListener handleSignupBtnActions(){
        SignupPage sp = this.getSignupPage();
        Color origColor = sp.getSignupBtn().getBackground();

        return new MouseListener() {
            @Override
            public void mouseEntered(MouseEvent e) {
                sp.getSignupBtn().setBackground(Color.GRAY);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                sp.getSignupBtn().setBackground(origColor);
            }
            @Override
            public void mouseClicked(MouseEvent e) {
                String username = sp.getUsernameField().getText();
                String email = sp.getEmailField().getText();
                String password = String.valueOf(sp.getPasswordField().getPassword());
                String confPassword = String.valueOf(sp.getConfirmPasswordField().getPassword());

                System.out.println(
                    username + " | " +
                    email + " | " +
                    password + " | " +
                    confPassword);
                if(password.equals(confPassword)){
                    try {
                        int result = App.db.users.createUser(username, email, confPassword);
                        System.out.println(result);
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                } else {
                    System.out.println("Passwords don't match!");
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {}
            @Override
            public void mouseReleased(MouseEvent e) {}
        };
    }
    public ActionListener showLogin(){
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                App.window.display(App.window.LOGIN_KEY);
            }
        };
    }
}
