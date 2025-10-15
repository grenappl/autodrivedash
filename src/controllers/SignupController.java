package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import app.App;
import bases.BaseController;
import views.SignupPage;

public class SignupController extends BaseController {
    public SignupPage getSignupPage(){ return (SignupPage)this.page; }

    public SignupController(SignupPage signupPage){
        super(signupPage);
        this.getSignupPage().getGoToLoginBtn().addActionListener(showLogin());
    }

    public ActionListener handleSignupAction(){
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
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
