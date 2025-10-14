package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import app.App;

public class SignupController {
    public ActionListener switchToLoginPage(){
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                App.window.getPageController().show(App.window.getPages(), "Login");
            }
        };
    }
}
