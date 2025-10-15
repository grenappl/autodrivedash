package controllers;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import app.App;
import bases.BaseController;
import views.LoginPage;

public class LoginController extends BaseController {
    public LoginPage getLoginPage(){ return (LoginPage)this.page; }

    public LoginController(LoginPage loginPage){
        super(loginPage);
        this.getLoginPage().getLoginButton().addMouseListener(handleLoginBtnActions());
        this.getLoginPage().getGoToSignUpButton().addActionListener(showSignup());
    }

    public MouseListener handleLoginBtnActions(){
        LoginPage lp = this.getLoginPage();
        Color origColor = lp.getLoginButton().getBackground();

        return new MouseListener() {
            @Override
            public void mouseEntered(MouseEvent e) {
                lp.getLoginButton().setBackground(Color.GRAY);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                lp.getLoginButton().setBackground(origColor);
            }
            @Override
            public void mouseClicked(MouseEvent e) {
                String email = lp.getEmailField().getText();
                String password = String.valueOf(lp.getPasswordField().getPassword());

                System.out.println(email + " | " + password);
            }

            @Override
            public void mousePressed(MouseEvent e) {}
            @Override
            public void mouseReleased(MouseEvent e) {}
        };
    }
    public ActionListener showSignup(){
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                App.window.display(App.window.SIGNUP_KEY);
            }
        };
    }

    
    // loginBtn.setEnabled(false);
}
