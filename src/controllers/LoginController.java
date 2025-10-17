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
import views.LoginPage;

public class LoginController extends BaseController {
    public LoginPage getLoginPage(){ return (LoginPage)this.page; }

    public LoginController(LoginPage loginPage){
        super(loginPage);
        getLoginPage().getLoginBtn().addMouseListener(handleLoginBtnActions());
        getLoginPage().getGoToSignUpBtn().addActionListener(showSignup());
    }

    public MouseListener handleLoginBtnActions(){
        LoginPage lp = this.getLoginPage();
        Color origColor = lp.getLoginBtn().getBackground();

        return new MouseListener() {
            @Override
            public void mouseEntered(MouseEvent e) {
                lp.getLoginBtn().setBackground(Color.GRAY);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                lp.getLoginBtn().setBackground(origColor);
            }
            @Override
            public void mouseClicked(MouseEvent e) {
                String email = lp.getEmailField().getText();
                String password = String.valueOf(lp.getPasswordField().getPassword());

                try {
                    ResultSet result = App.db.users.findByEmailAndPassword(email, password);
                    if(result.next()){ // go to menu
                        System.out.println(
                            result.getInt("id") + " | " +
                            result.getString("email") + " | " +
                            result.getString("password")
                        );
                    } else { // show error pop
                        System.out.println("No results");
                    }
                    result.close();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
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
