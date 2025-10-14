package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import app.App;
import views.LoginPage;

public class LoginController {
    public ActionListener switchToSignupPage(){
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                App.window.getPageController().show(App.window.getPages(), "Signup");
            }
        };
    } 
}
